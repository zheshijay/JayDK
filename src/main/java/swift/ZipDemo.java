package swift;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
	
public class ZipDemo {
	
	public static UUID getTUUID() {
		return java.util.UUID.fromString(new com.eaio.uuid.UUID().toString());
	}
	
	public void zipFiles(List<String> files){

		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream("C:/Users/Zshi/Desktop/testFiles/" + getTUUID() + ".zip");
			zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			for(String filePath:files){
				File input = new File(filePath);
				fis = new FileInputStream(input);
				ZipEntry ze = new ZipEntry(input.getName());
				System.out.println("Zipping the file: "+input.getName());
				zipOut.putNextEntry(ze);
				byte[] tmp = new byte[4*1024];
				int size = 0;
				while((size = fis.read(tmp)) != -1){
					zipOut.write(tmp, 0, size);
				}
				zipOut.flush();
				fis.close();
			}
			zipOut.close();
			System.out.println("Done... Zipped the files...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(fos != null) fos.close();
			} catch(Exception ex){

			}
		}
	}

	public static void main(String a[]){

		ZipDemo test = new ZipDemo();
		List<String> files = new ArrayList<String>();
		files.add("C:/Users/Zshi/Desktop/testFiles/foo1.pdf");
		files.add("C:/Users/Zshi/Desktop/testFiles/foo2.pdf");
		test.zipFiles(files);
	}
}
