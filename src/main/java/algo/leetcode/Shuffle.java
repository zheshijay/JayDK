package algo.leetcode;


public class Shuffle {


	public static int[] shuffle(int arr[]){
		for(int i=0;i<arr.length;i++){ 
			int x = (int) (Math.random() * 10);
			int temp = arr[x];
			arr[x]=arr[i];
			arr[i]=temp;			
		}
		return arr;	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,0};
		int[] res = Shuffle.shuffle(nums);
//		System.out.print(Math.random() + " ");
		for(int each: res){
			System.out.print(each + " ");
		}

	}

}
