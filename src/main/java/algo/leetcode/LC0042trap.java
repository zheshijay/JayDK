package algo.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC0042trap {

	public static int trap(int[] height) {
		if (height.length < 3)
			return 0;

		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int popIdx = stack.pop();
				while (!stack.isEmpty() && height[stack.peek()] == height[popIdx]) {
					stack.pop();
				}

				if (!stack.isEmpty()) {
					int width = i - stack.peek() - 1;
					int hig = Math.min(height[i] - height[popIdx], height[stack.peek()] - height[popIdx]);
					ans += width * hig;
				}

			}
			stack.push(i);
			System.out.println(stack);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] height = new int[] {4,2,0,3,2,5};
		int res = LC0042trap.trap(height);
		System.out.println(res);

	}
}
