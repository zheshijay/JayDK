package file.remote.smb;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
/**
 * Read a file inside a zip file (remote server)
 *
 */

public class CheckImageService {


	public void sendPDF(HttpServletResponse response, ByteArrayOutputStream output, int length, boolean isIE) throws Exception {
		response.setContentType("application/pdf");
		response.setContentLength(length);
		if (isIE) { //if it is IE
			response.setHeader("Accept-Ranges" , "none" );
		}
		//		response.flushBuffer();
		output.writeTo(response.getOutputStream());
		response.flushBuffer();
	}

	//outputStream to inputStream
	public ByteArrayInputStream toInputStream(OutputStream out) throws Exception
	{
		ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
		baos=(ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
		return swapStream;
	}
	//inputStream to outputStream
	public ByteArrayOutputStream toOutputStream(InputStream in) throws Exception {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		int ch;
		while ((ch = in.read()) != -1) {
			swapStream.write(ch);
		}
		return swapStream;
	}

	public SmbFile readFile(String remoteFileName){
		System.out.println("============================" + remoteFileName);
		SmbFile smbFile = null;
		//    BufferedReader reader = null;
		//    List<String> resultLines = null;

		String conStr = null;   //\\10.8.8.216\indiv_afp\idcu\compressed-afp\20120319-09_52_40.609.zip
		//		conStr = "smb://"+account+":"+password+"@"+remoteHostIp+"/"+shareDocName+"/"+remoteFileName;
		conStr = remoteFileName;
		try {
			smbFile = new SmbFile(conStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return smbFile;
	}

	public InputStream getFileStream(String smbMachine){

		System.out.println("Go to getFileStream");
		File localfile=null;
		InputStream bis=null;
		OutputStream bos=null;
		try {
			System.out.println("smbMachine is : " + smbMachine);
			SmbFile rmifile = readFile(smbMachine);
			System.out.println("rmifile is : " + rmifile);
			String filename=rmifile.getName();
			System.out.println("filename is : " + filename);
			bis=new BufferedInputStream(new SmbFileInputStream(rmifile));

			return bis;
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}finally{
			//            try {
			//                bis.close();
			//            } catch (IOException e) {
			//                e.printStackTrace();
			//            }
		}
		return null;
	}   
	
	public ByteArrayOutputStream getCheckImageFileBySMB(String cid, String filePath, String fileName) throws Exception {
		byte[] buffer = new byte[2048];
		//RemoteFileUtil util = new RemoteFileUtil("10.8.8.216", "script", "3statements*", null);
		//		System.out.println(util.getFileStream("smb://script:3statements*@10.8.8.216/indiv_afp/idcu/compressed-afp/20120319-09_52_40.609.zip"));
		InputStream input = this.getFileStream("smb://"+"script"+":"+"3statements*"+"@10.8.8.216/indiv_afp/"+cid+"/" + filePath);
		ZipInputStream stream = new ZipInputStream(input);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ZipEntry entry;

		while((entry = stream.getNextEntry())!=null)
		{
			// reading until read returns 0 or less.
			try
			{
				if(entry.getName().equals(fileName)){
					int len = 0;
					while ((len = stream.read(buffer)) > 0)
					{
						output.write(buffer, 0, len);	
					}

					String s = String.format("Entry: %s len %d added %TD",
							entry.getName(), entry.getSize(),
							new Date(entry.getTime()));
					System.out.println(s);
				}
			}
			finally
			{
				// we must always close the output file
				if(output!=null) output.close();
			}
		}
		return output;
	}
	
	public static void main(String[] args){
		String cid = "fffc";
		String filePath = "compressed-afp/";
		String fileName = "20151002-13_10_05.195_62216.zip";
		CheckImageService service = new CheckImageService();
		try {
			System.out.println(service.getCheckImageFileBySMB(cid, filePath, fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
