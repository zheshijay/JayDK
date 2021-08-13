package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0071simplifyPath {

	public static String simplifyPath(String path) {
		Deque<String> queue = new LinkedList<>();
		String[] folders = path.split("/");

		for (int i=0; i< folders.length; i++) {
			String curFolder = folders[i];
			
			if (curFolder.equals("") || curFolder.equals(".") || (curFolder.equals("..") && queue.isEmpty())) continue;

			if (curFolder.equals("..") && !queue.isEmpty()) {
				queue.pollLast();
			} else {
				queue.offer(curFolder);
			}
		}
		
		StringBuffer res = new StringBuffer();
		res.append("/");

		while(!queue.isEmpty()) {
			res.append(queue.poll() + "/");
		}

		if (res.length() > 1) {
			res.deleteCharAt(res.length() - 1);
		}

		return res.toString();
	}
	
	public static void main(String[] args) {
//		String path = "/home/";
//		String path = "/a/./b/../../c/";
		String path = "/a//b////c/d//././/..";
		
		System.out.println(LC0071simplifyPath.simplifyPath(path));
	}

}
