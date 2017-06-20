package file.csv.readcsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCVS {

	public static void main(String[] args) {

		ReadCVS obj = new ReadCVS();
		obj.run();

	}

	public void run() {

		String csvFile = "C:/Download/20150129041540_ProofOfInduction_D.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] cellValue = line.split(cvsSplitBy);
				System.out.println("JobID" + cellValue[0] );
				System.out.println("City:" + cellValue[1] );
				System.out.println("State: " + cellValue[2] );
				System.out.println("MID: " + cellValue[3] );
				System.out.println("CRID:" + cellValue[4] );
				System.out.println("Permit Number:" + cellValue[5] );
				System.out.println("IMB:" + cellValue[6] );
				System.out.println("Mailing Date:" + cellValue[7] );
				
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

}