package algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * 1. 先找出来有多少个email ( 图中的每一个结点 )
 * 2. 连接所有emails，用户相同的emails会在一个集合里面
 * 3. 用一个HashMap，key=本集合的root结点，values=本集合中所有的email
 * 4. 从集合里面随便找一个邮箱，找到用户名字
 */
public class LC0721mergeAccount {
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, Integer> emailToIndex = new HashMap<String, Integer>(); // 给每一个邮箱一个唯一编号
		Map<String, String> emailToName = new HashMap<String, String>(); // 记录每一个邮箱的用户名

		int emailsCount = 0;		
		for (List<String> account : accounts) {
			String name = account.get(0);
			int size = account.size();
			for (int i = 1; i < size; i++) {
				String email = account.get(i);
				if (!emailToIndex.containsKey(email)) {
					emailToIndex.put(email, emailsCount++);
					emailToName.put(email, name);
				}
			}
		}

		System.out.println("emailToIndex:" + emailToIndex);
		System.out.println("emailToName:" + emailToName);

		// 构造一个图，使用并查集来查找是否属于一个集合
		UnionFind uf = new UnionFind(emailsCount);

		for (List<String> account : accounts) {
			String firstEmail = account.get(1);
			int firstIndex = emailToIndex.get(firstEmail);
			int size = account.size();

			for (int i = 2; i < size; i++) {
				String nextEmail = account.get(i);
				int nextIndex = emailToIndex.get(nextEmail);
				uf.union(firstIndex, nextIndex);
			}
		}
		
		// Key是当前集合的root, values是emails
		Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
		for (String email : emailToIndex.keySet()) {
			int rootIndex = uf.find(emailToIndex.get(email));
			List<String> account = indexToEmails.getOrDefault(rootIndex, new ArrayList<String>());
			account.add(email);
			indexToEmails.put(rootIndex, account);
		}
		
		System.out.println("indexToEmails:" + indexToEmails);
	
		List<List<String>> merged = new ArrayList<List<String>>();
		for (List<String> emails : indexToEmails.values()) {
			Collections.sort(emails);
			String name = emailToName.get(emails.get(0));
			List<String> account = new ArrayList<String>();
			account.add(name);
			account.addAll(emails);
			merged.add(account);
		}
		return merged;
	}

	// Driver code
	public static void main(String args[]) {

		/*
		 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
		 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
		 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
		 */

		List<List<String>> accounts = new ArrayList<>();

		List<String> acct1 = new ArrayList<>();
		acct1.add("John");
		acct1.add("join@gmail.com");
		acct1.add("join2@gmail.com");

		List<String> acct2 = new ArrayList<>();
		acct2.add("John");
		acct2.add("join@gmail.com");
		acct2.add("join@hotmail.com");

		List<String> acct3 = new ArrayList<>();
		acct3.add("Mary");
		acct3.add("mary@gmail.com");

		accounts.add(acct1);
		accounts.add(acct2);
		accounts.add(acct3);

		LC0721mergeAccount test = new LC0721mergeAccount();
		List<List<String>> res = test.accountsMerge(accounts);
		System.out.println("res:" + res);

	}
}

class UnionFind {
	int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public void union(int index1, int index2) {
		parent[find(index2)] = find(index1);
	}

	// return top parent
	public int find(int index) {
		if (parent[index] != index) {
			parent[index] = find(parent[index]);
		}
		return parent[index];
	}
}
