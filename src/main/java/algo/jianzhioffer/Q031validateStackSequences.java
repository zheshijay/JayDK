package algo.jianzhioffer;

import java.util.Stack;

/*

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */

public class Q031validateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}