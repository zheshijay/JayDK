package algo.string_and_array;

public class FindSingle {

	
	// [1,1,2,2,3,4,4]
	public int findSingle(int[] nums){
		boolean[] status = new boolean[10];
		
		int i=0;
		while(i<nums.length){
			
			if(status[nums[i]] == true) status[nums[i]]=false;
			else{
				status[nums[i]] = true;
			}
			i++;
		}
		
		int j=0;
		while(j<status.length){
			if(status[j]) return j;
			j++;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		FindSingle test = new FindSingle();
		
		System.out.println(test.findSingle(new int[]{1,1,2,2,3,3,4}));
	}


}
