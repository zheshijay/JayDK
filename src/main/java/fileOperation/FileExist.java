package fileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;

public class FileExist {



	public static void main(String[] args){
//		String localDir = "//10.8.8.216/input/I3/MsgSample/snfb/pdf";
//		String fileName = "snfbms1119187476.imp.pdf";

		String localDir = "Z:/zshi/MM";
		String fileName = "query.txt";
		
		
		
		
		File file = new File(localDir, fileName);
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		System.out.println("---------------------");
		System.out.println(file.exists());
	}
}
