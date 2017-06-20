package oauth2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/*
 * SSCUHttpUtil 
 * This class is to install all-trusted certificate and post the request
 */
public class SSCUHttpUtil {
	private static final int HTTP_CONNECTION_TIMEOUT = 5000;
	private static final int HTTP_READ_TIMEOUT = 5000;
	private static final int SLEEP_TIME = 1000;
	private static final int MAX_RETRY_COUNT = 3;
	private static final String CERTIFACATE_PASS = "changeit";
	private static final String CERTIFACATE_ALIAS = "estatement";
	private static final String CHARSET = "UTF-8";

	// Create all-trusting host name verifier
	private static HostnameVerifier ALL_HOST_VALID = new HostnameVerifier() {

		public boolean verify(String paramString, SSLSession paramSSLSession) {
			// good_address return true
			return true;
		}
	};

	static {
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(ALL_HOST_VALID);
	}

	public static String postURL(String urlStr, String data, int retryCount,
			String contentType, String p12certResource) throws SocketTimeoutException {
		String result = null;
		try {
			result = retryablePost(urlStr, data, contentType, p12certResource);
		} catch (SocketTimeoutException ste) {
			if (retryCount >= MAX_RETRY_COUNT) {
				throw ste;
			}
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = postURL(urlStr, data, ++retryCount, contentType,
					p12certResource);
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}

		return result;
	}

	private static String retryablePost(String urlStr, String data,
			String contentType, String p12certResource) throws Exception {
		java.net.URL url = new java.net.URL(urlStr);
		HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();

		// Let the run-time system (RTS) know that we want input.
		urlConn.setDoInput(true);
		// Let the RTS know that we want to do output.
		urlConn.setDoOutput(true);
		urlConn.setRequestProperty("Accept-Charset", CHARSET);
		
		// No caching, we want the real thing.
		urlConn.setUseCaches(false);
	
		// Setting timeout
		urlConn.setConnectTimeout(HTTP_CONNECTION_TIMEOUT);
		urlConn.setReadTimeout(HTTP_READ_TIMEOUT);
		SSLSocketFactory sslSocketFactory = getSSLFactory(p12certResource,
				CERTIFACATE_PASS, CERTIFACATE_ALIAS);
		urlConn.setSSLSocketFactory(sslSocketFactory);
		if (data != null) {
			// Specify the content type if needed.
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", contentType);
			DataOutputStream output = new DataOutputStream(
					urlConn.getOutputStream());

			// Send the request data.
			output.writeBytes(data);
			output.flush();
			output.close();
		}

		InputStream is;
		if (urlConn.getResponseCode() >= 400) {
			is = urlConn.getErrorStream();
		} else {
			is = urlConn.getInputStream();
		}

		// Get response data.
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		String line = null;
		String result = null;
		while ((line = bfr.readLine()) != null) {
			result = line;
		}
		bfr.close();

		return result;
	}

	private static SSLSocketFactory getSSLFactory(String p12certResource,
			String pKeyPassword, String certAlias) throws Exception {
		KeyManagerFactory keyManagerFactory = KeyManagerFactory
				.getInstance("SunX509");
		KeyStore keyStore = KeyStore.getInstance("JKS");
		InputStream keyInput = Thread.currentThread().getContextClassLoader().getResourceAsStream(p12certResource);
		keyStore.load(keyInput, pKeyPassword.toCharArray());
		//keyInput.close();
		keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
		// Replace the original KeyManagers with the AliasForcingKeyManager
		KeyManager[] kms = keyManagerFactory.getKeyManagers();
		for (int i = 0; i < kms.length; i++) {
			if (kms[i] instanceof X509KeyManager) {
				kms[i] = new AliasForcingKeyManager((X509KeyManager) kms[i],
						certAlias);
							
			}
		}
		X509TrustManager trustManager = new X509TrustManager() {

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkServerTrusted(
					X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			public void checkClientTrusted(
					X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}
		};
		SSLContext context = SSLContext.getInstance("TLS");
		// context.init(kms, null, null);
		context.init(kms, new TrustManager[] { trustManager }, null);
		SSLContext.setDefault(context); // added
		return context.getSocketFactory();
	}
	
	
	
	/*
	 * This wrapper class overwrites the default behavior of a X509KeyManager
	 * and always render a specific certificate whose alias matches that
	 * provided in the constructor
	 */
	private static class AliasForcingKeyManager implements X509KeyManager {
		
		X509KeyManager baseKM = null;
		String alias = null;

		public AliasForcingKeyManager(X509KeyManager keyManager, String alias) {
			baseKM = keyManager;
			this.alias = alias;
		}

		/*
		 * Always render the specific alias provided in the constructor
		 */
		public String chooseClientAlias(String[] keyType, Principal[] issuers,
				Socket socket) {
			return alias;
		}

		public String chooseServerAlias(String keyType, Principal[] issuers,
				Socket socket) {
			return baseKM.chooseServerAlias(keyType, issuers, socket);
		}

		public X509Certificate[] getCertificateChain(String alias) {
			return baseKM.getCertificateChain(alias);
		}

		public String[] getClientAliases(String keyType, Principal[] issuers) {
			return baseKM.getClientAliases(keyType, issuers);
		}

		public PrivateKey getPrivateKey(String alias) {
			return baseKM.getPrivateKey(alias);
		}

		public String[] getServerAliases(String keyType, Principal[] issuers) {
			return baseKM.getServerAliases(keyType, issuers);
		}
	}
}
