package structure.twoDarray;

public class TwoDArrayTest {
	public static void main(String[] args){
		String[][] names = {
				{"Mr. ", "Mrs. ", "Ms. "},
				{"Jay ", "Zhe "},
				{"Shi"},
				{"Shi"}
		};
		//Mr. Jay Shi
		System.out.println(names[0][0] + names[1][0] + names[2][0]);
		
		//Mrs. Zhe Shi
		System.out.println(names[0][1] + names[1][1] + names[2][0]);
		
		
		 System.out.println("----------------------------------");
		 System.out.println("names rows: " + names.length);
		 
		for(int row=0; row <names.length; row++)
		{
		   for(int col=0; col <names[row][col].length(); col++)
		   {
		      //your code to access display[row][col]
			   
			   System.out.print("names["+ row+"]" + "["+ col+"]" + names[row][col]);
		   }
		   System.out.println();
		}
	}
}
