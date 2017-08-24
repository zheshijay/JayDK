package qa;

import java.util.HashSet;
import java.util.Set;

public class NumberPairs {
	public static void main(String[] args) {
		INumber number = new NumberImpl();
		number.insert(-1);
		number.insert(1);
		number.insert(0);
		number.insert(2);
		number.insert(3);
		number.insert(4);
		number.insert(1);
		System.out.println(number.isPresentInPairSum(2, 1));
		System.out.println(number.isPresentInPairSum(2, 2));
		System.out.println(number.isPresentInPairSum(5, 2));
		System.out.println(number.isPresentInPairSum(5, 4));
	}

	private static interface INumber {

		public void insert(int i);

		public boolean isPresentInPairSum(int sum, int i);
	}

	private static class NumberImpl implements INumber {

		private Set<Integer> storage;

		private Set<Integer> sumSet;

		public NumberImpl() {
			storage = new HashSet<Integer>();
			sumSet = new HashSet<Integer>();
		}

		@Override
		public void insert(int i) {
			storage.add(i);
			for(Integer in: storage) {
				sumSet.add( i + in );
			}
		}

		public boolean isPresentInPairSum(int sum, int i) {
			return sumSet.contains(sum) && storage.contains(i) && storage.contains( sum - i);
		}

	}

}
