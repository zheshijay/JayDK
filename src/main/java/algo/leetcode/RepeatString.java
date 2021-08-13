package algo.leetcode;


import java.util.Set;
import java.util.TreeSet;

public class RepeatString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "ABCAB";

		int step = 1;

		Set<String> nonReaptingSeq = new TreeSet<>();

		Set<String> reaptingSeq = new TreeSet<>();

		for (int i = 0; (i < test.length() && (i + step) <= test.length()); i++) {
			System.out.println(" ----------------- ");
			System.out.print(" --- " + i);
			String sub = test.substring(i, i + step);
			

			if (!nonReaptingSeq.add(sub)) {
				reaptingSeq.add(sub);
			}
			
			System.out.print(sub + " ");
			System.out.print("nonReaptingSeq: " + nonReaptingSeq);
			System.out.print("reaptingSeq: " + reaptingSeq);

		}

		System.out.println();
		System.out.println("result: " + reaptingSeq);

	}

}
