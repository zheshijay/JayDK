package encrypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;

public class Encryption {

	/**
	 * Encodes and decodes to and from Base64.
	 *
	 * @author Zhe Shi
	 * @author zheshijay@gmail.com
	 * @version 1.0
	 */
	public String encrypt(String secretKey, String strToEncrypt, int iterations){
		try {
			byte[] input = strToEncrypt.toString().getBytes("utf-8");
			byte[] salt = secretKey.getBytes("UTF-8");
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey tmp = factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(), salt, iterations, 256));
			SecretKeySpec skc = new SecretKeySpec(tmp.getEncoded(),"AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skc);
			byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
			int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
			ctLength += cipher.doFinal(cipherText, ctLength);
			String query = Base64.encodeBase64URLSafeString(cipherText);
			return query;
		} catch (Exception e) {
			System.out.println("Error while encrypting :" + e);
		}
		return null;
	}
	
	public String encrypt2(String strToEncrypt, String secretKey, int iterations){
		try {
		    // strToEncrypt could be either ‘Composite Auth String’ or ‘Account Number’ value
		    byte[] input = strToEncrypt.toString().getBytes("utf-8");
		    byte[] salt = secretKey.getBytes("UTF-8");
		    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		    SecretKey tmp = factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(), salt, iterations, 256));
//		    System.out.println("tmp.getEncoded: : " + tmp.getEncoded());
		    SecretKeySpec skc = new SecretKeySpec(tmp.getEncoded(),"AES");
		    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		    cipher.init(Cipher.ENCRYPT_MODE, skc);
		    byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		    int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		    ctLength += cipher.doFinal(cipherText, ctLength);
		    return Base64.encodeBase64URLSafeString(cipherText);
		} catch (Exception e) {
			System.out.println("Error while encrypting :" + e);
		}
		return null;
	}
	
	public static String encrypt3(String strToEncrypt, String secretKey, int iterations){

		try {
			byte[] input = strToEncrypt.toString().getBytes("UTF-8");
			byte[] salt = secretKey.getBytes("UTF-8");
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey tmp = factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(), salt, iterations, 256));
		    System.out.println("tmp.getEncoded: " + tmp.getEncoded());
			SecretKeySpec skc = new SecretKeySpec(tmp.getEncoded(),"AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skc);
			byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
			int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
			ctLength += cipher.doFinal(cipherText, ctLength);
			return Base64.encodeBase64URLSafeString(cipherText);
		} catch (Exception e) {
			System.out.println("Error while encrypting :" + e);
		}
		return null;
	}


	/**
	 * Decrypt String
	 * 
	 * @param secretKey
	 * @param strToEncrypt
	 * @param iterations
	 * @return
	 */
	public static String decrypt(String strToDecrypt,String secretKey,int iterations){
		try {
			byte[] salt = secretKey.getBytes("UTF-8");
			System.out.println("JAYLOG: salt is: " + salt);
			
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey tmp = factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(), salt, iterations, 256));
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(),"AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
			return decryptedString;
		} catch (Exception e) {
			System.out.println("Error while decrypting :" + e);
		}
		return null;
	}
	
	/**
	 * Decrypt String  SHA
	 * 
	 * @param secretKey
	 * @param strToEncrypt
	 * @param iterations
	 * @return
	 */
	public static String decryptSHA(String strToDecrypt,String secretKey,int iterations){
		try {
			byte[] salt = secretKey.getBytes("UTF-8");
			System.out.println("JAYLOG: salt is: " + salt);
			
			SecretKeyFactory factory = SecretKeyFactory.getInstance("SHA");
			SecretKey tmp = factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(), salt, iterations, 256));
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(),"AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
			return decryptedString;
		} catch (Exception e) {
			System.out.println("Error while decrypting :" + e);
		}
		return null;
	}
	
	public String getBase(String strToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException{
		byte[] input = strToEncrypt.toString().getBytes("utf-8");
		return Base64.encodeBase64URLSafeString(input);
	}
	
	
	public String getProdEncryptedStr(String  cid, String str, String type){
		String idcu_prod_secretKey = "v26hd118S6cdV1u"; 
		String idcu_pilot_secretKey = "NvS04aP1f25G66y"; 
		
		int idcu_prod_iterations = 7294;
		int idcu_pilot_iterations = 9357;
		
		String edcu_pilot_secretKey = "97vupTSC5ucPCSe";
		int edcu_pilot_iterations = 6278;
		
		String edcu_prod_secretKey = "ybrD295aoNKdw2n";
		int edcu_prod_iterations = 8247;
		
		String kfcu_pilot_secretKey = "d6VvUn0RSBqvvMd";
		int kfcu_pilot_iterations = 4925;
		
		
		if(type.equalsIgnoreCase("account")){
//			long timeMillis = System.currentTimeMillis();
//			String strToEncrypt = cid+"|"+timeMillis+"|"+iterations;
			String strToEncrypt = str;
			System.out.println("strToEncrypt: " + strToEncrypt);
			return this.encrypt(kfcu_pilot_secretKey, strToEncrypt, kfcu_pilot_iterations);
		}
		
		if(type.equalsIgnoreCase("client")){
			long timeMillis = System.currentTimeMillis();
//			String strToEncrypt = cid+"|"+timeMillis+"|"+kfcu_pilot_iterations;
			String strToEncrypt = "kfcu|1446752061899|4925";
			System.out.println("strToEncrypt: " + strToEncrypt);
			
			return this.encrypt(kfcu_pilot_secretKey, strToEncrypt, kfcu_pilot_iterations);
		}
		
		return null;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String secretKey, String strToEncrypt, int iteration
		
		//create StringToEncrypt
		Encryption e = new Encryption();
//		System.out.println("encrypted : " + e.encrypt2("kycu|1471274674430|2856", "bSGbMB5PBAwUHDy", 2856));
		System.out.println("encrypted : " + e.encrypt3("kycu|1471274674430|2856", "bSGbMB5PBAwUHDy", 2856));
		
//		System.out.println("client key: " + e.getProdEncryptedStr("kfcu", "kfcu", "client"));
//		System.out.println("encrypted account: " + e.getProdEncryptedStr("kfcu", "315", "account"));
		
//		System.out.println("decrypted account: " + e.decrypt("EgjG0AbfDh11Bj_gMze-EQ", "v26hd118S6cdV1u", 7294));
//		System.out.println("decrypted account: " + e.decrypt("d6VvUn0RSBqvvMd", "1thiMs5u0RwyMDVfcRymcw", 4925));
		
//		System.out.println("decrypted account: " + e.decryptSHA("3640906d9ae23293c0511f2b368f6016", "changeme", 10000));
	}

}
