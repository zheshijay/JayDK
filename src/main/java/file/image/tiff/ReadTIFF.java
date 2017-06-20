package file.image.tiff;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ReadTIFF {
	public static void main(String[] args){
//		File tiffFile = new File("C:/tmp/tiff/InfoImage-HELOC-2.tif");
//		File tiffFile = new File("C:/tmp/tiff/sample.tif");
		File tiffFile = new File("C:/tmp/tiff/test1234.tiff");
		System.out.println("File path: " + (tiffFile.getPath()));
		System.out.println("File exists: " + (tiffFile.exists()));
		
		try {
			InputStream is = new FileInputStream(tiffFile);
			System.out.println("empty stream: " + (is == null));
			
			BufferedImage imgSelected = ImageIO.read(is);
			System.out.println("empty img: " + (imgSelected == null));
			
//			System.out.println("getHeight: " + imgSelected.getHeight());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
