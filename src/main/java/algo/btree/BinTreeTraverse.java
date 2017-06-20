package algo.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinTreeTraverse {

	public static void visit(Node node){  
		System.out.print(node.val +" ");  
	}  
	//nonRecursion perOrder Traverse  
	public static void preOrderStack(Node root){  

		Stack<Node> stack=new Stack<Node>();  
		Node p=root;  
		if(p!=null){  
			stack.push(p);  
			while(!stack.isEmpty()){  
				p=stack.pop();  
				visit(p);  
				if(p.right!=null)stack.push(p.left);  
				if(p.left!=null)stack.push(p.left);  
			}  
		}  
	}  
	//nonRecursion inOrder Traverse  
	public static void inOrderStack(Node p){  
		Stack<Node> stack=new Stack<Node>();  
		while(p!=null||!stack.isEmpty()){  
			//push all LeftChild,when p has no LeftChild,that means it's root,it should be visited  
			while(p!=null){  
				stack.push(p);  
				p=p.left;  
			}  
			if(!stack.isEmpty()){  
				p=stack.pop();  
				visit(p);  
				p=p.right;  
			}  
		}  
	}  

	//nonRecursion postOrder Traverse  
	public static void postOrderStack(Node p){  
		Stack<Node> stack=new Stack<Node>();  
		Node q=p;//q,is the latest Node that has been visited  
		while(p!=null){  
			while(p.left!=null){  
				stack.push(p);  
				p=p.left;  
			}  
			/* 
	             while(p!=null){//wrong.when 'while' ends,p=null 
	                stack.push(p); 
	                p=p.left; 
	            } 
			 */  
			while(p!=null&&(p.right==null||p.right==q)){  
				visit(p);  
				q=p;  
				if(stack.isEmpty())return;  
				p=stack.pop();  
			}  
			stack.push(p);  
			p=p.right;  
		}  
	}
	
	//level order  
	/*
	 * 分层遍历二叉树（按层次从上往下，从左往右）迭代 
	 * 其实就是广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点 
	 * ，访问，若左子节点或右子节点不为空，将其压入队列 
	 * */
	public static void levelTraversal(Node root) {
		if (root == null) {
			return;
		}

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

	public static void preOrder(Node root){  
		if(root==null){return;}  
		System.out.print(root.val+" ");  
		preOrder(root.left);  
		preOrder(root.right);  
	}  
	public static void inOrder(Node root){  
		if(root==null){return;}  
		inOrder(root.left);  
		System.out.print(root.val+" ");  
		inOrder(root.right);  
	}  
	public static void postOrder(Node root){  
		if(root==null){return;}  
		postOrder(root.left);  
		postOrder(root.right);  
		System.out.print(root.val+" ");  
	}  



	/** 
	 * 编程之美 分层遍历二叉树 
	 * 之前已经用队列实现过二叉树的层次遍历，但这次要求输出换行，因此要标记什么时候要换行： 
	 * 用inCount记录某层有多少个元素，outCount记录当前输出了多少个元素；当inCount==outCount时，就说明某层元素已经完全输出，此时应该换行(outCount清零) 
	 * 此外，观察发现，当第K层元素全部出队（并已将各自左右孩子入队）后，队列里面刚好存放了第K+1层的所有元素，不多不少，所以有：inCount = queue.size(); 
	 *  
	 * 书上的扩展问题也很有意思（从下往上分层输出），既然是反过来输出，第一反应是利用栈 
	 * 但同时又要记录何时换行（每行有多少个元素），只好用ArrayList模拟一个“伪栈”： 
	 * 1、第一步操作和“从上往下分层输出”是类似的：从root开始遍历，并将所有元素放入“队列”（ArrayList），用-1表示一层的结束 
	 * 2、输出。不是从队头开始，而是从队尾开始，依次输出 
	 * 分析到这里，这里面的ArrayList定义为“双向队列”更合适 
	 */  

	/* 
	     从上往下分层输出 
	        1  
	        2 3  
	        4 5 6  
	        7 8  
	 */  
	public void traverseByLevelFromTop(Node node) {  
		if (node == null) {  
			return;  
		} 

		Queue<Node> queue = new LinkedList<Node>();  

		queue.offer(node);  

		int inCount = 1;  
		int outCount = 0;  

		while (!queue.isEmpty()) {  
			Node curNode = queue.poll();  
			System.out.print(curNode.val + " ");  
			outCount++;  
			if (curNode.left != null) {  
				queue.offer(curNode.left);  
			}  
			if (curNode.right != null) {  
				queue.offer(curNode.right);  
			}  
			if (outCount == inCount) {  
				System.out.println();  
				inCount = queue.size();  
				outCount = 0;  
			}  
		}  
	}  


	/* 
	 * 
	 * 基本思路：从root节点开始初始化，把root节点放到list里面，用一个node（-1） 来标记这一个level结束。
	 * 
	 * 遍历list，取出每一个node的左右节点，当i的值增加到list的size的时候，或者说已经遍历完所有当前list的node，取出了他们所有的孩子节点以后，更新size为下一个level的size
	 * 注意在这个时候，i并没有更新，每次遍历i都是从新的level的第一节node开始的。
	 * 
	 * 
	 * 
	    从下往上分层输出 
	        7 8  
	        4 5 6  
	        2 3  
	        1  
	 */  

	public void traverseByLevelFromBottom(Node node) {  
		if (node == null) {  
			return;  
		}  

		List<Node> list = new ArrayList<Node>();  
		list.add(node);  
		list.add(new Node(-1));     //-1表示一层结束，打印时要换行  

		int i = 0;  
		int size = list.size();  

		while (i < size) {

			System.out.println("i:　" + i + "  size: " + + size);

			Node curNode = list.get(i);  

			/*交换下面这两个操作，可实现输出： 
	                8 7  
	                6 5 4  
	                3 2  
	                1 
			 */  

			if (curNode.right != null) {  
				list.add(curNode.right);  
			}   

			if (curNode.left != null) {  
				list.add(curNode.left);  
			}  



			i++;  
			if (i == size) {
				System.out.println("--> i equals size " + size);

				if (curNode.val != -1 && curNode.left == null && curNode.right == null) {   //已经遍历到最底层的最后一个元素，结束循环  
					break;  
				}  
				size = list.size();  
				list.add(new Node(-1));       
			}  
		}  

		//从后往前遍历，相当于“栈”  
		
		System.out.println("list final size: "+ list.size());
		for(int j = list.size()-1; j>=0; j--){  
			int val = list.get(j).val;  
			if (val == -1) {  
				System.out.println();  
			} else {  
				System.out.print(val + " ");  
			}  
		}
	}  


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		/* 
        __1__ 
       /     \ 
    __2__     3__ 
   /     \       \ 
  4     __5__     6 
       7     8 
		 */  


		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;

		Node root = node1;

		BinTreeTraverse tt = new BinTreeTraverse();

		System.out.println("preOrder: ");  
		tt.preOrder(root);

		System.out.println();

		System.out.println("inOrder: ");  
		tt.inOrder(root);

		System.out.println();

		System.out.println("levelTraversal: ");  
		tt.levelTraversal(root);

		System.out.println();

		System.out.println("traverseByLevelFromTop: ");  
		tt.traverseByLevelFromTop(root);

		System.out.println();

		System.out.println("traverseByLevelFromBottom: ");  
		tt.traverseByLevelFromBottom(root);

	}

}
