package algo.treeMatrixGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import algo.jianzhioffer.TreeNode;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeBasic {
	// preOrder, inOrder, postOrder
	// mirror
	// DFS, BFS
	// levelOrderTraversal. TopView, ButtomView
	// findLCA
	// search node
	// maxDepth, minimumDepth

	static class Node {
		int val, hd;
		Node left, right;

		Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}

	private void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}

	public void depthOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("empty tree");
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (stack.isEmpty() == false) {
			Node Node = stack.pop();
			System.out.print(Node.val + "    ");
			if (Node.right != null) {
				stack.push(Node.right);
			}
			if (Node.left != null) {
				stack.push(Node.left);
			}
		}
		System.out.print("\n");
	}

	public void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("empty tree");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			Node Node = queue.poll();
			System.out.print(Node.val + "    ");
			if (Node.left != null) {
				queue.add(Node.left);
			}
			if (Node.right != null) {
				queue.add(Node.right);
			}
		}
		System.out.print("\n");
	}

	private void levelTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}
	}

	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
	        if (root == null) {
	            return levelOrder;
	        }

	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            List<Integer> level = new ArrayList<Integer>();
	            int currentLevelSize = queue.size();
	            for (int i = 1; i <= currentLevelSize; ++i) {
	                TreeNode node = queue.poll();
	                level.add(node.val);
	                if (node.left != null) {
	                    queue.offer(node.left);
	                }
	                if (node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	            levelOrder.add(level);
	        }
	        
	        return levelOrder;
	    }

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
		if (root == null) {
			return levelOrder;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				TreeNode left = node.left, right = node.right;
				if (left != null) {
					queue.offer(left);
				}
				if (right != null) {
					queue.offer(right);
				}
			}
			levelOrder.add(0, level);
		}
		return levelOrder;
	}

	// Find Lowest Common Ancestor
	private Node findLCA(Node root, Node Node1, Node Node2) {
		if (root == null)
			return null;

		if (root.val == Node1.val || root.val == Node2.val) {
			return root;
		}

		Node left_lca = findLCA(root.left, Node1, Node2);
		Node right_lca = findLCA(root.right, Node1, Node2);

		// Found LCA: because 2 target nodes on appeared on the left and right
		if (left_lca != null && right_lca != null) {
			return root;
		}

		// return to upper stack if not found
		return left_lca != null ? left_lca : right_lca;
	}

	// Method that prints the bottom view.
	public void bottomView(Node root) {
		if (root == null)
			return;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<Node>();

		int index = 0;
		root.hd = index;
		queue.add(root);

		// Loop until the queue is empty (standard level order loop)
		while (!queue.isEmpty()) {
			Node cur = queue.remove();

			index = cur.hd;

			System.out.println("put hd:" + index + " - val:" + cur.val);
			map.put(index, cur.val);

			if (cur.left != null) {
				cur.left.hd = index - 1;
				queue.add(cur.left);
			}
			if (cur.right != null) {
				cur.right.hd = index + 1;
				queue.add(cur.right);
			}
		}
		System.out.print(map.values());
	}

	// Method that prints the bottom view.
	public void topView(Node root) {
		if (root == null)
			return;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<Node>();

		int hd = 0;
		root.hd = hd;
		queue.add(root);

		// Loop until the queue is empty (standard level order loop)
		while (!queue.isEmpty()) {
			Node cur = queue.remove();

			hd = cur.hd;

			if (!map.containsKey(hd))
				map.put(hd, cur.val);

			if (cur.left != null) {
				cur.left.hd = hd - 1;
				queue.add(cur.left);
			}
			if (cur.right != null) {
				cur.right.hd = hd + 1;
				queue.add(cur.right);
			}
		}
		System.out.print(map.values());
	}

	private Node search(Node Node, int target) {
		Node result = null;

		if (Node == null)
			return null;

		if (Node.val == target)
			return Node;

		if (Node.left != null)
			result = search(Node.left, target);

		if (result == null)
			result = search(Node.right, target);
		return result;

	}

	/* Function to calculate the minimum depth of the tree */
	int minimumDepth(Node root) {
		// Corner case. Should never be hit unless the code is
		// called on root = NULL
		if (root == null)
			return 0;

		// Base case : Leaf Node. This accounts for height = 1.
		if (root.left == null && root.right == null)
			return 1;

		// If left subtree is NULL, recur for right subtree
		if (root.left == null)
			return minimumDepth(root.right) + 1;

		// If right subtree is NULL, recur for right subtree
		if (root.right == null)
			return minimumDepth(root.left) + 1;

		return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
	}

	int maximumDepth(Node root) {
		// Corner case. Should never be hit unless the code is
		// called on root = NULL
		if (root == null)
			return 0;

		// Base case : Leaf Node. This accounts for height = 1.
		if (root.left == null && root.right == null)
			return 1;

		// If left subtree is NULL, recur for right subtree
		if (root.left == null)
			return maximumDepth(root.right) + 1;

		// If right subtree is NULL, recur for right subtree
		if (root.right == null)
			return maximumDepth(root.left) + 1;

		return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;
	}

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(Node root) {
		maxGain(root);
		return maxSum;
	}

	public int maxGain(Node node) {
		if (node == null) {
			return 0;
		}

		// 递归计算左右子节点的最大贡献值
		// 只有在最大贡献值大于 0 时，才会选取对应子节点
		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain = Math.max(maxGain(node.right), 0);

		// 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
		int priceNewpath = node.val + leftGain + rightGain;

		// 更新答案
		maxSum = Math.max(maxSum, priceNewpath);

		// 返回节点的最大贡献值
		return node.val + Math.max(leftGain, rightGain);
	}

	void mirror(Node Node) {
		if (Node == null) {
			return;
		} else {
			Node temp;

			/* do the subtrees */
			mirror(Node.left);
			mirror(Node.right);

			/* swap the objects/values in this Node */
			temp = Node.left;
			Node.left = Node.right;
			Node.right = temp;
		}
	}

	// remove node
	// Get minimum element in binary search tree
	public static Node minimumElement(Node root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}

	public static Node maxElement(Node root) {
		if (root.right == null)
			return root;
		else {
			return maxElement(root.right);
		}
	}

	public static Node deleteNode(Node root, int value) {
		if (root == null)
			return null;
		if (root.val > value) {
			root.left = deleteNode(root.left, value);
		} else if (root.val < value) {
			root.right = deleteNode(root.right, value);
		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				Node temp = root;
				// Finding minimum element from right
				Node minNodeForRight = minimumElement(temp.right);
				// Replacing current node with minimum node from right subtree
				root.val = minNodeForRight.val;
				// Deleting minimum node from right now
				deleteNode(root.right, minNodeForRight.val);

			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
		     1
		   /   \ 
		  2     3
	 	 / \    / 
	 	4   5  6 
	 	   / \
	 	  7   8
*/

		TreeNode Node1 = new TreeNode(1);
		TreeNode Node2 = new TreeNode(2);
		TreeNode Node3 = new TreeNode(3);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node5 = new TreeNode(5);
		TreeNode Node6 = new TreeNode(6);
		TreeNode Node7 = new TreeNode(7);
		TreeNode Node8 = new TreeNode(8);

		Node1.left = Node2;
		Node1.right = Node3;
		Node2.left = Node4;
		Node2.right = Node5;
		Node3.left = Node6;
		Node5.left = Node7;
		Node5.right = Node8;

		TreeNode root = Node1;

		BinaryTreeBasic test = new BinaryTreeBasic();

		System.out.println("preOrder: ");  
		test.preOrder(root);
		System.out.println("");  

		//
		//		System.out.println();
		//
		System.out.println("inOrder: ");  
		test.inOrder(root);
		System.out.println("");  
		//
		//		System.out.println();
		//
		System.out.println("postOrder: ");  
		test.postOrder(root);
//		System.out.println("");  
//		//
//		System.out.println("levelTraversal: ");  
//		tt.levelTraversal(root);
//		System.out.println("");  
//		//
//		//
//		System.out.println("traverseByLevelFromTop: ");  
//		tt.traverseByLevelFromTop(root);
//		//
//		//		System.out.println();
//		//
//		System.out.println("traverseByLevelFromBottom: ");  
//		tt.traverseByLevelFromBottom(root);
//		List<List<Integer>> res = test.levelOrderBottom(root);
//		System.out.println(res);
//		//
//		//		System.out.println();
//		//
//		System.out.println("findLCA: ");  
//		Node lca = tt.findLCA(root,Node4, Node6);
//		System.out.println("lca: " + lca.val);
		//
		// System.out.println();
		//
		// System.out.println("search Node: ");
		// Node found = tt.search(root, 11);
		// if(found!=null) System.out.println("found: " + found.val);
		// else{ System.out.println("Not found"); }
		//
		// System.out.println();
		//
		// System.out.println("Mirro:");
		//
		// System.out.println("before: "+root.left.val);
		// tt.mirror(root);
		// System.out.println("after: "+root.left.val);

//		System.out.println();
//
//		System.out.println("DFS:");
//		tt.depthOrderTraversal(root);
//
//		System.out.println("BFS:");
//		tt.levelOrderTraversal(root);

//		System.out.println("bottomView:");
//		tt.bottomView(root);
//
//		System.out.println("topView:");
//		tt.topView(root);
//
//
//
//		System.out.println("maximumDepth:" + tt.maximumDepth(root));
//		System.out.println("minimumDepth:" + tt.minimumDepth(root));
//		System.out.println("maxPathSum:" + tt.maxPathSum(root));
		


	}

}
