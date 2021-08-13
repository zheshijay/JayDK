package algo.leetcode;


public class FindShortestPathTwoWord {

	int findPath(String[] strings, String targetString, String targetString2){
		int index1 = -1;
		int index2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int tempDistance = 0;

		for (int x = 0; x < strings.length; x++) {
			if (strings[x].equals(targetString)) {
				index1 = x;
			}
			if (strings[x].equals(targetString2)) {
				index2 = x;
			}
			if (index1 != -1 && index2 != -1) { // both words have to be found
				tempDistance = (int) Math.abs(index2 - index1);
				if (tempDistance < minDistance) {
					minDistance = tempDistance;
				}
			}
		}

		return minDistance;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
