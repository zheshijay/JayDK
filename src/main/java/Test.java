import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		Integer[] nums = new Integer[] {1,6,2,9};
		
		Arrays.sort(nums, (x, y)->{return -1;});
//		Arrays.sort(nums);
//		Arrays.sort(nums, new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return b-a;
//            }
//        });
		
		System.out.println(Arrays.toString(nums));
//		System.out.println("z".compareTo("a"));
//		System.out.println("a".compareTo("z"));
	}
}

