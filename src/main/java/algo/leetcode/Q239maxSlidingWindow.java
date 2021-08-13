package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q239maxSlidingWindow {
	// Method to find the maximum for
	// each and every contiguous subarray of size k.

	static void printKMax(int nums[], int n, int k) {
		int j, max;

		for (int i = 0; i <= n - k; i++) {

			max = nums[i];

			for (j = 1; j < k; j++) {
				if (nums[i + j] > max)
					max = nums[i + j];
			}
			System.out.print(max + " ");
		}
	}

	
	
	/*
	 * Solution 2: Sliding window
	 */
	// A Dequeue (Double ended queue) 
    // based method for printing 
    // maximum element of
    // all subarrays of size k
    static void printMax(int nums[], int n, int k)
    {
         
        // Create a Double Ended Queue, Qi 
        // that will store indexes of array elements
        // The queue will store indexes of 
        // useful elements in every window and it will
        // maintain decreasing order of values 
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] 
        // are sorted in decreasing order
        Deque<Integer> deque = new LinkedList<Integer>();
 
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i) 
        {
            
            // For every element, the previous 
            // smaller elements are useless so
            // remove them from Qi
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // Remove from rear
            	 System.out.println("removing: " + deque.peekLast());
            	deque.removeLast(); 
            }
      
            // Add new element at rear of queue
            System.out.println("adding: " + i);
            deque.addLast(i);
        }
 
        System.out.println("before: " + deque);
        
        
        // Process rest of the elements, 
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) 
        {
         
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(nums[deque.peek()] + " ");
 
            // Remove the elements which are out of this window
            while ((!deque.isEmpty()) && deque.peek() <= i - k) {
            	deque.removeFirst();
            }

            // Remove all elements smaller 
            // than the currently
            // being added element (remove 
            // useless elements)
            while ((!deque.isEmpty()) && nums[i] >= 
                              nums[deque.peekLast()])
            	deque.removeLast();
 
            // Add current element at the rear of Qi
            deque.addLast(i);
        }
 
        // Print the maximum element of last window
        System.out.print(nums[deque.peek()]);
    }
	
	
	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
