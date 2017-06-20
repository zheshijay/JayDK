package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

public class ReadImagesByJavaImageIO {

	public static void main(String[] args) throws FileNotFoundException{
		
		File cmykJPEGFile = new File("C:/Users/Zshi/Desktop/WHCU MM Image/FairTicketlowresNew.jpg");
		
		try {
			BufferedImage bufferedImage = ImageIO.read(cmykJPEGFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
