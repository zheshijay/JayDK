package stringTest;

public class Other {
	public static void main(String [] args){
		
//		String emails = "a,b,c";
//		String[] emailArray = emails.split(",");
//		System.out.println(emailArray[0]);
//		
//		emailArray[0] ="d";
//		
//		System.out.println(emailArray[0]);
		
		String zip = "11111, 22222, 33333 ";


String output = zip.replaceAll("\\s+",""); 


		
		System.out.println(output);
		
		
	}
}
