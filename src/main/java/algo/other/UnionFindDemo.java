package algo.other;

import java.util.Arrays;

public class UnionFindDemo {
	int size;
	int[] parent;

	public UnionFindDemo(int size) {
		this.size = size;
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = -1;
        }
	}

	int find(int v) {
		int vRoot = v;
		while (parent[vRoot] != -1) {
			vRoot = parent[vRoot];
		}
		return vRoot;
	}

	boolean joint(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		System.out.println("x:" + x + "|y:" + y);
		System.out.println("xRoot:" + xRoot + "|yRoot:" + yRoot);
		
		
		if (xRoot == yRoot) {
			return false;
		} else {
			parent[yRoot] = xRoot;
//			parent[xRoot] = yRoot;
			return true;
		}
	}

	public static void main(String[] args) {
		int size = 5;
		UnionFindDemo test = new UnionFindDemo(size);
		
		
		int[][] v = new int[][] {
			{0,1},{1,2},{1,3},
			{2,4}
			,{3,4}
		};
		
		
		boolean hasCycle = false;
		for(int i=0; i<v.length; i++) {
			if(!test.joint(v[i][0], v[i][1])) {
				hasCycle = true;
				System.out.println("cycle detected!");
				break;
			}
		}
		
		System.out.println("has Cycle:"+ hasCycle);
//		test.joint(1, 2);
//		System.out.println("parent:"+ Arrays.toString(test.parent));
		
//		
		
		
//		System.out.println("parent:" + Arrays.toString(test.parent));
//		System.out.println("find(0):" + test.find(0));
//		System.out.println("find(1):" + test.find(1));
//		System.out.println("find(2):" + test.find(2));
		
		
		

	}

}
