package fileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;

public class FileIOTest {
	
	public void createDir(String dir){
		 File theDir = new File(dir);
		  // if the directory does not exist, create it
		  if (!theDir.exists()) {
		    System.out.println("creating DIR: " + dir);
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		     } catch(SecurityException se){
		        //handle it
		     }        
		     if(result) {    
		       System.out.println("DIR created");  
		     }
		  }
	}
	
	public void createFile(String fileName){
		
		File file = new File(fileName);
		if(!file.exists()) {
			try {
				System.out.println("Create new file...");
				file.createNewFile();
				System.out.println("File created...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
	}
	
	public static void main(String[] args){
		
		FileIOTest ioTest = new FileIOTest();
		String localDir = "C:/Download/";
		ioTest.createFile("C:/Download/myfile.txt");
		ioTest.createDir("C:/Download/");
	
		try {
			System.out.println("Deleting...");
			File fin = new File(localDir);
			 
			for (File file : fin.listFiles()) {
				try {
				    Thread.sleep(3000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			    FileDeleteStrategy.FORCE.delete(file);
			}
			
			System.out.println("Finished");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
