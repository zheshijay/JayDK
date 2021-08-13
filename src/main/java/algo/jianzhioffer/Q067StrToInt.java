package algo.jianzhioffer;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]


 */

public class Q067StrToInt {
	 public int strToInt(String str) {
	        char[] c = str.trim().toCharArray();
	        if(c.length == 0) return 0;
	        int res = 0, bndry = Integer.MAX_VALUE / 10;
	        int i = 1, sign = 1;
	        if(c[0] == '-') sign = -1;
	        else if(c[0] != '+') i = 0;
	        for(int j = i; j < c.length; j++) {
	            if(c[j] < '0' || c[j] > '9') break;
	            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            res = res * 10 + (c[j] - '0');
	        }
	        return sign * res;
	    }

}