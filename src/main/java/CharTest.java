import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharTest {

	static void swap(char[] a, int index1, int index2){
		char tmp;
		tmp=a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<char[]> cList = new ArrayList<>();
		
		char[] a1 = new char[] {'a','b','c'};
		
		
		
		cList.add(Arrays.copyOf(a1, a1.length));
		CharTest.swap(a1, 0, 1);
		cList.add(Arrays.copyOf(a1, a1.length));
		
//		char[] a2 = new char[] {'b','a','c'};
//		char[] a3 = new char[] {'c','b','a'};
		
//		cList.add(a1);
//		cList.add(a2);
//		cList.add(a3);
		
		for(char[] each: cList) {
			System.out.println(each);
		}

	}

}
