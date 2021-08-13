package algo.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：

用返回一个整数列表来代替打印
n 为正整数

 */

public class Q012PathToWord {
	 public boolean exist(char[][] board, String word) {
	        char[] words = word.toCharArray();
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length;j++){
	                if(helper(board,words,i,j,0)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }    
	    public boolean helper(char[][] board, char[] words, int i, int j, int p){
	        //是否越界或者字符不匹配
	        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[p]){
	            return false;
	        }
	        if(p == words.length - 1){
	            return true;
	        }       
	        char tmp = board[i][j];
	        board[i][j] = '#';
	        boolean res = helper(board,words,i-1,j,p+1) || helper(board,words,i+1,j,p+1)
	                        || helper(board,words,i,j-1,p+1) || helper(board,words,i,j+1,p+1);
	        board[i][j] = tmp;
	        return res;
	    }

	public static void main(String[] args) {

		Q012PathToWord test = new Q012PathToWord();
		int[] nums = new int[] { 2, 0, 5, 0, 1 };
		System.out.println(test.isStraight(nums));

	}

}