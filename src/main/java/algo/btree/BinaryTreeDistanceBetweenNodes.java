package algo.btree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDistanceBetweenNodes
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		f.left = g;
		f.right = h;

		int distance = findDistance(a, 2, 7);
		System.out.println(distance);

	}

	private static int findDistance(Node root, int val1, int val2)
	{
		List < Node > path1 = new ArrayList < Node >();
		List < Node > path2 = new ArrayList < Node >();
		findPath(root, val1, path1);
		findPath(root, val2, path2);
		
		
		System.out.println("path1:" + path1.size());
		System.out.println("path2:" + path2.size());
		
		if (path1.size() == 0 || path2.size() == 0)
			return -1;
		int index = 0;
		for (; index < path1.size(); ++index)
		{
			if (path1.get(index) != path2.get(index))
				break;
		}
		System.out.println("index:" + index);
		return path1.size() + path2.size() - 2 * index;
	}

	private static boolean findPath(Node root, int value, List < Node > path)
	{
		if (root == null)
			return false;
		path.add(root);
		if (root.value == value)
		{
			return true;
		}
		if (findPath(root.left, value, path)
				|| findPath(root.right, value, path))
			return true;
		path.remove(root);
		return false;
	}

	static class Node
	{
		Node left;
		Node right;
		int value;

		public Node(int value)
		{
			this.value = value;
		}
	}
}