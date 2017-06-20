package encrypt;

import java.security.MessageDigest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;



public class MD5 {

	public boolean isPasswordMatched(String pwd, String currentPwd) {
		//		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		//		String test = md5.encodePassword(aPassword, getUsername());
		return pwd.equals(currentPwd);
	}

	public String getMD5Vlue(String pwd, String salt) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String md5pwd = md5.encodePassword(pwd, salt);

		return md5pwd;
	}


	public String encryptPassword(String newPassword)
	{
		try
		{
			String msg = 16448 +"."+ 17618497 + "|" + newPassword;
			System.out.println("msg: " + msg);
			
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(msg.getBytes());
			byte[] ciphertext = md.digest();
			return "[SHA1]"+Base64.encodeBytes(ciphertext);
		}
		catch (Exception e) 
		{
			return newPassword;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MD5 test = new MD5();
		System.out.println(test.encryptPassword("fffc@2015"));

	}

}
