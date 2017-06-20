package file.csv.opencsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class Readcsv {

	// csv format constant.
	private final static CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

	public void readCSVFileHeader(File file) throws IOException{
		System.out.println("File Path: " + file.getCanonicalPath());
		System.out.println(file.canExecute() + ":" + file.canRead() + ":" + file.canWrite());
//		CSVParser parser = CSVParser.parse(file, Charset.forName("ISO_8859_1"), CSVFormat.TDF);
		CSVParser parser = new CSVParser(new FileReader(file), format);
		
		if(parser.isClosed()) System.out.println("is closed");
		
//		System.out.println(parser.getCurrentLineNumber() + "\t" + 
//				parser.getRecordNumber() + "\t" + parser.getRecords());
		
		
		Map<String, Integer> headerMap = parser.getHeaderMap();
		
		System.out.println("HeaderMap: " + headerMap);
		System.out.println("Header keySet: " + headerMap.keySet());
		
		for(String header : headerMap.keySet()){
			System.out.println("-->Header: " + header);
			String[] arr =header.split("_");
			
			if(arr.length == 1 || arr.length == 2){
				System.out.println("length is 1 or 2");
			}		
			else if(arr.length == 3)
				System.out.println("length is 3");
			}
		
		
		try {
			// parsing file using apache CSV parser.
			
			parser.close();
			
		} catch(NullPointerException e){
			System.out.println("getCSVHeader() function"+ e);
			parser = null;
		} catch (FileNotFoundException e) {
			System.out.println("getCSVHeader() function"+ e);
			parser = null;

		} catch (IOException e) {
			System.out.println("getCSVHeader() function"+ e);
			parser = null;
		}
		
		
		
	}


	public static void main(String[] args){
		Readcsv rs = new Readcsv();
//		File file = new File("C:/tmp/csv/applePayTest.csv");
		File file = new File("C:/tmp/csv/8veriables.csv");
		
		try {
			rs.readCSVFileHeader(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	/**
	 * 
	 * CSVHelper.java
	 * @Author: pshah
	 * @Date: Sep 17, 2014
	 * @Params: File object
	 * @Return: Map<String, Integer>
	 * @Exception: FileNotFoundException, IOException
	 */
	public static Map<String, Integer> getCSVHeader(InputStream stream) {

		// csv parser object.
		CSVParser parser = null;

		// Map that will hold headers of csv.
		Map<String, Integer> headerMap = null;
		try {
			// parsing file using apache CSV parser.

			parser = new CSVParser(new InputStreamReader(stream), format);

			// Getting csv header in to map.
			headerMap = parser.getHeaderMap();

			// closing parser.
			parser.close();
		} catch(NullPointerException e){
			System.out.println("getCSVHeader() function" + e);
			parser = null;
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("getCSVHeader() function"+ e);
			parser = null;
			return null;

		} catch (IOException e) {
			System.out.println("getCSVHeader() function"+ e);
			parser = null;
			return null;
		}
		return headerMap;
	}   

}
