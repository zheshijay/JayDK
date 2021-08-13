package algo.string_and_array;

public class FindNthNum {
	/*
	 * 
	 * 
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ... is a 0, which is part of the number 10.

	 */

	/*
	 * 
Straight forward way to solve the problem in 3 steps:

find the length of the number where the nth digit is from
find the actual number where the nth digit is from
find the nth digit and return
	 */

	/*
	 * 
	 * 
1   1-9
2   10-99
3   100-999
4   1000-9999
5   10000-99999
6   100000-999999
7   1000000-9999999
8   10000000-99999999
9   100000000-99999999
	 * 
	 * 
Idea:

The first idea is: the result will only be within 0~9, can we find a cycle?

For input 1 to 20, the result is:

1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5

No cycle found. While we can find that digits matter! The result sequence should be like:

1~9: 1*9=9 in total

10~99: 2*90=180 in total

100~999: 3*900=2700 in total

Then, 49000, 590000, k910^k

For input 12345, we have 9+180+2700<12345<9+180+2700+36000, so the corresponding number is 1000+.

12345-9-180-2700=9456-1=9455

9455/4 = 2363+1000=3363, 9455%4=3, so the result should be 3. For 12346: 3, for 12347: 3, for 12348: 6, for 12349: 4

336(12345 start from the next 3)3

(12346)3(12347)3(12348)6(12349)4
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
1   1 2,3 4 5 6 7 8 9
2   10 11 12 13 14 15 16 17 ... 99
3   100-999
	 * 
	 * 
	 */
	public int findNthDigit(int n) {

		int len = 1;
		long count = 9;
		int start = 1;
		
		//1. Find the target group
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
			System.out.println("n:"+n + " start: " + start + " len: " + len);  //n is reducing, the last n is the nth in target row
		}

		//2. find the exact number 
		System.out.println("first number of target group: " + start);
		start += (n - 1) / len;  //find the exact number in this group
		System.out.println("find target number in this group:" + start);
		String s = Integer.toString(start);
		System.out.println("---------------------");
		System.out.println("n:"+n + " s: " + s + " len: " + len);

		//3. return the index in the target digit
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
	public int findNthDigitBackup(int n) {

		int len = 1;
		int start = 1;
		long count = 9;
		
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
		
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
	public static void main(String args[]){
		FindNthNum test = new FindNthNum();

		System.out.println(test.findNthDigit(15));


	} 
}
