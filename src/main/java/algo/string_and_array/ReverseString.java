package algo.string_and_array;


public class ReverseString {

	public String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		int i = 0;
		while(i < n) {

			System.out.println(" i is:  " + i );
			int j = Math.min(i + k - 1, n - 1);
			
			System.out.println(" swap " + i + " and " + j);
			swap(arr, i, j);
			i += 2 * k;
		}
		return String.valueOf(arr);
	}


	private void swap(char[] arr, int l, int r) {
		while (l < r) {
			char temp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = temp;
		}
	}


	public static void main(String args[]){
		ReverseString test = new ReverseString();

		String str = "abcdefgh";
		String reversed = test.reverseStr(str ,3);

		System.out.println("reversed: "+ reversed);


	}
}
