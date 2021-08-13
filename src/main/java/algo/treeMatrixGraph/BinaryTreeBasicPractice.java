package algo.treeMatrixGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import algo.jianzhioffer.TreeNode;
import algo.treeMatrixGraph.BinaryTreeBasic.Node;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeBasicPractice {
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
	
	private void preOrder(TreeNode node) {
		// 12457836
		if (node == null) {
			return;
		}
		System.out.print(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void inOrder(TreeNode node) {
		// 42758136
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.val);
		inOrder(node.right);
	}
	
	private void postOrder(TreeNode node) {
		// 47852631
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val);
	}

	private void levelOrder(TreeNode node) {
		// 12345678
		if (node == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			System.out.print(curNode.val);
			
			if (curNode.left != null) {
				queue.offer(curNode.left);
			}
			
			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
			
		}
	}

	private TreeNode findLCA(TreeNode node, int v1, int v2) {
		if (node == null || node.val == v1 || node.val == v2) {
			return node;
		}
		
		TreeNode leftLCA = findLCA(node.left, v1, v2);
		TreeNode rightLCA = findLCA(node.right, v1, v2);
		
		if (leftLCA != null && rightLCA != null) {
			return node;
		}
		
		return leftLCA != null? leftLCA: rightLCA;
	}
	
	public List<List<Integer>> levelOrderList(TreeNode root) {
	 	LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) {
            return ret;
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
            ret.add(level);
        }
        
        return ret;
    }
	
	private boolean searchValDFS(TreeNode node, int target) {
		if (node == null) {
			return false;
		}
		
		if (node.val == target) {
			return true;
		}
		
		return searchValDFS(node.left, target) || searchValDFS(node.right, target);
	}
	
	//maxDepth: Solution 1
	// 从上面开始level++
	public int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(dfs(node.left, 1), dfs(node.right, 1));
	}
	
	public int dfs(TreeNode node, int level) {
		if (node == null) {
			return level;
		}

		level++;
		return Math.max(dfs(node.left, level), dfs(node.right, level));
	}

	// maxDepth: Solution 2
	// 从下面开始 level++
	 public int maxDepth2(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }

	       int leftHeight = maxDepth(root.left);
	       int rightHeight = maxDepth(root.right);
	       return Math.max(leftHeight, rightHeight) + 1;
	    }
	
	 // delete node in BST
	 public TreeNode deleteNode(TreeNode node, int target) {
		 if (node == null) return null;

		 if (target < node.val) {
			 node.left = deleteNode(node.left, target);
		 } else	if (target > node.val) {
			 node.right = deleteNode(node.right, target);
		 } else {
			 if (node.left == null && node.right == null) {
				 node = null;
			 } else if (node.left != null) {
				 // find the max from left (predecessor)
				 node.val = predecessor(node);
				 node.left = deleteNode(node.left, node.val);
			 } else {
				 // find the min from right (successor)
				 node.val = successor(node);
				 node.right = deleteNode(node.right, node.val);
			 }
		 }
		 return node;
	 }
	 
	 // the max on left subtree
	 private int predecessor(TreeNode node) {
		 node = node.left;
		 while(node.right != null) {
			 node = node.right;
		 }
		 return node.val;
	 }
	 
	// the min on right subtree
	 private int successor(TreeNode node) {
		node = node.right;
		while(node.left != null) {
			 node = node.left;
		}
		return node.val;
	}

	 // top view
	 public void topView(TreeNode root) {
			if (root == null)
				return;

			Map<Integer, Integer> map = new TreeMap<>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();

			int hd = 0;
			root.hd = hd;
			queue.add(root);

			// Loop until the queue is empty (standard level order loop)
			while (!queue.isEmpty()) {
				TreeNode cur = queue.remove();

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
	 
	 // bottom view
//	 public void bottomView(TreeNode root) {
//			if (root == null)
//				return;
//
//			Map<Integer, Integer> map = new TreeMap<>();
//			Queue<TreeNode> queue = new LinkedList<TreeNode>();
//
//			int hd = 0;
//			root.hd = hd;
//			queue.add(root);
//
//			// Loop until the queue is empty (standard level order loop)
//			while (!queue.isEmpty()) {
//				TreeNode cur = queue.remove();
//
//				hd = cur.hd;
//
//				map.put(hd, cur.val);
//					
//
//				if (cur.left != null) {
//					cur.left.hd = hd - 1;
//					queue.add(cur.left);
//				}
//				if (cur.right != null) {
//					cur.right.hd = hd + 1;
//					queue.add(cur.right);
//				}
//			}
//			System.out.print(map.values());
//		}
	 
	// Method that prints the bottom view.
		public void bottomView(TreeNode root) {
			if (root == null)
				return;

			Map<Integer, Integer> map = new TreeMap<>();
			Queue<TreeNode> queue = new LinkedList<>();

			int index = 0;
			root.hd = index;
			queue.add(root);

			// Loop until the queue is empty (standard level order loop)
			while (!queue.isEmpty()) {
				TreeNode cur = queue.remove();

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
		
		
		//11. dfsTraverse
//		private void dfsTraverse(TreeNode node) {
//			 Stack<TreeNode> stack = new Stack<>();
//		     stack.push(node);
//		     
//		     while(!stack.isEmpty()) {
//		    	 TreeNode curNode = stack.pop();
//		    	 System.out.print(curNode.val);
//		    	 
//		    	 if (curNode.left != null) {
//		    		 stack.push(curNode.left);
//		    	 }
//		    	 
//		    	 if (curNode.right != null) {
//		    		 stack.push(curNode.right);
//		    	 }
//		     }
//		}
		
		public void dfsTraverse(TreeNode root) {
			if (root == null) {
				System.out.println("empty tree");
				return;
			}
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while (stack.isEmpty() == false) {
				TreeNode Node = stack.pop();
				System.out.print(Node.val + " ");
				if (Node.right != null) {
					stack.push(Node.right);
				}
				if (Node.left != null) {
					stack.push(Node.left);
				}
			}
			System.out.print("\n");
		}
		
		

	 
	 
	public static void main(String[] args) {

/*
		     1
		   /   \ 
		  2     3
	 	 / \   /  \
	 	4   5 6    7 
	 	   /   \
	 	  8     9
*/

		TreeNode Node1 = new TreeNode(1);
		TreeNode Node2 = new TreeNode(2);
		TreeNode Node3 = new TreeNode(3);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node5 = new TreeNode(5);
		TreeNode Node6 = new TreeNode(6);
		TreeNode Node7 = new TreeNode(7);
		TreeNode Node8 = new TreeNode(8);
		TreeNode Node9 = new TreeNode(9);

		Node1.left = Node2;
		Node1.right = Node3;
		Node2.left = Node4;
		Node2.right = Node5;
		Node3.left = Node6;
		Node3.right = Node7;
		Node5.left = Node8;
		Node5.right = Node9;
		

		TreeNode root = Node1;
		

		BinaryTreeBasicPractice test = new BinaryTreeBasicPractice();
		System.out.println("1. preOrder:");
		test.preOrder(root);
		System.out.print("\n\n");
		
		System.out.println("2. inOrder:");
		test.inOrder(root);
		System.out.print("\n\n");
		
		System.out.println("3. postOrder:");
		test.postOrder(root);
		System.out.print("\n\n");
		
		System.out.println("4. levelOrder:");
		test.levelOrder(root);
		System.out.print("\n\n");
		
		System.out.println("5. levelOrderList:");
		List<List<Integer>> res = test.levelOrderList(root);
		System.out.println(res);
		System.out.print("\n\n");
		
		System.out.println("6. findLCA:");
		TreeNode lca = test.findLCA(root, 2, 6);
		System.out.println(lca.val);
		System.out.print("\n\n");
		
		System.out.println("7. searchValDFS:");
		boolean hasVal = test.searchValDFS(root, 9);
		System.out.println(hasVal);
		System.out.print("\n\n");
		
		System.out.println("8. maxDepth:");
		int maxDepth = test.maxDepth(root);
		System.out.println(maxDepth);
		System.out.print("\n\n");
		
		System.out.println("9. topView:");
		test.topView(root);
		System.out.print("\n\n");
		
		System.out.println("10. bottomView:");
		test.bottomView(root);
		System.out.print("\n\n");
		
		System.out.println("11. dfsTraverse:");
		test.dfsTraverse(root);
		System.out.print("\n\n");
		

	}

	

}
