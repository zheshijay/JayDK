package algo.utils;

public class PrintUtils {
	public static void printTwoDArray(Object[][] a){

		for(int row=0; row< a.length; row++){
			for(int col=0; col < a[row].length; col++){
				System.out.print(a[row][col]+ " ");
			}
			System.out.println();
		}
	}

	public static void printTwoDArray(boolean[][] a){

		for(int row=0; row< a.length; row++){
			for(int col=0; col < a[row].length; col++){
				System.out.print(a[row][col]+ " ");
			}
			System.out.println();
		}
	}
}
