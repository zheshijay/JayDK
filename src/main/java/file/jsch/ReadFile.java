package file.jsch;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ReadFile {
	


	public ByteArrayOutputStream getPDFFromRemoteServer(String host, String username, String pwd, int port, 
			String zipFilePath, String filename) {

		JSch obj_JSch = new JSch();
		Session obj_Session = null;
		Channel obj_Channel = null;
		ChannelSftp obj_SFTPChannel = null;
		String cid = null;
		byte[] buffer = new byte[2048];
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		ZipFile zipFile = null;
		InputStream input = null;

		StringBuilder obj_StringBuilder = new StringBuilder();
		try
		{
			obj_Session = obj_JSch.getSession(username, host);
			obj_Session.setPort(port);
			obj_Session.setPassword(pwd);
			Properties obj_Properties = new Properties();
			obj_Properties.put("StrictHostKeyChecking", "no");
			obj_Session.setConfig(obj_Properties);
			obj_Session.connect();
			obj_Channel = obj_Session.openChannel("sftp");
			obj_Channel.connect();
			obj_SFTPChannel = (ChannelSftp) obj_Channel;
			input = obj_SFTPChannel.get(zipFilePath);

			ZipInputStream stream = new ZipInputStream(input);
			ZipEntry entry;

			while((entry = stream.getNextEntry())!=null)
			{
				try
				{
					if(entry.getName().equals(filename)){
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
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//			emailService.sendEmailAlert(cid, str_FileName, "[EXCEPTION]", "Please check " + str_FileName + "." +  "<br><br> ");
		}finally{
			obj_SFTPChannel.exit();
			obj_SFTPChannel.disconnect();
			obj_Session.disconnect();
		}
		return output;
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
	
	public ByteArrayOutputStream getPDFBySMB(String host, String username, String pwd, int port, 
			String zipFilePath, String fileName) throws Exception {
		byte[] buffer = new byte[2048];
		//RemoteFileUtil util = new RemoteFileUtil("10.8.8.216", "script", "3statements*", null);
		//		System.out.println(util.getFileStream("smb://script:3statements*@10.8.8.216/indiv_afp/idcu/compressed-afp/20120319-09_52_40.609.zip"));
		InputStream input = this.getFileStream("smb://"+username+":"+pwd+"@10.8.8.216/indiv_afp/abak/compressed-afp/20150625-14_42_36.920_60753.zip");
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
		ReadFile readFile = new ReadFile();
//		String host = "10.8.9.60";
//		String username = "pdev1";
//		String pwd = "infoimage";
//		Integer port = 22;
//		String zipFilePath = "";
//		String filename = "";
		
		String host = "10.8.8.216";
		String username = "script";
		String pwd = "3statements*";
		Integer port = 22;
		String zipFilePath = "";
		String filename = "abak1.pdf";
		
		
		try {
			readFile.getPDFBySMB(host, username, pwd, port, zipFilePath, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
