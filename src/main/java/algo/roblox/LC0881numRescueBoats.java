package algo.roblox;

import java.util.Arrays;

public class LC0881numRescueBoats {
	 public int numRescueBoats(int[] people, int limit) {
	        Arrays.sort(people);
	        int i = 0, j = people.length - 1;
	        int ans = 0;

	        while (i <= j) {
	            ans++;
	            if (people[i] + people[j] <= limit)
	                i++;
	            j--;
	        }

	        return ans;
	    }
}


