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
	 * �ֲ����������������δ������£��������ң����� 
	 * ��ʵ���ǹ������������ʹ�ö���ʵ�֡����г�ʼ���������ڵ�ѹ����С������в�Ϊ�գ��������²���������һ���ڵ� 
	 * �����ʣ������ӽڵ�����ӽڵ㲻Ϊ�գ�����ѹ����� 
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
	 * ���֮�� �ֲ���������� 
	 * ֮ǰ�Ѿ��ö���ʵ�ֹ��������Ĳ�α����������Ҫ��������У����Ҫ���ʲôʱ��Ҫ���У� 
	 * ��inCount��¼ĳ���ж��ٸ�Ԫ�أ�outCount��¼��ǰ����˶��ٸ�Ԫ�أ���inCount==outCountʱ����˵��ĳ��Ԫ���Ѿ���ȫ�������ʱӦ�û���(outCount����) 
	 * ���⣬�۲췢�֣�����K��Ԫ��ȫ�����ӣ����ѽ��������Һ�����ӣ��󣬶�������պô���˵�K+1�������Ԫ�أ����಻�٣������У�inCount = queue.size(); 
	 *  
	 * ���ϵ���չ����Ҳ������˼���������Ϸֲ����������Ȼ�Ƿ������������һ��Ӧ������ջ 
	 * ��ͬʱ��Ҫ��¼��ʱ���У�ÿ���ж��ٸ�Ԫ�أ���ֻ����ArrayListģ��һ����αջ���� 
	 * 1����һ�������͡��������·ֲ�����������Ƶģ���root��ʼ��������������Ԫ�ط��롰���С���ArrayList������-1��ʾһ��Ľ��� 
	 * 2����������ǴӶ�ͷ��ʼ�����ǴӶ�β��ʼ��������� 
	 * ����������������ArrayList����Ϊ��˫����С������� 
	 */  

	/* 
	     �������·ֲ���� 
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
	 * ����˼·����root�ڵ㿪ʼ��ʼ������root�ڵ�ŵ�list���棬��һ��node��-1�� �������һ��level������
	 * 
	 * ����list��ȡ��ÿһ��node�����ҽڵ㣬��i��ֵ���ӵ�list��size��ʱ�򣬻���˵�Ѿ����������е�ǰlist��node��ȡ�����������еĺ��ӽڵ��Ժ󣬸���sizeΪ��һ��level��size
	 * ע�������ʱ��i��û�и��£�ÿ�α���i���Ǵ��µ�level�ĵ�һ��node��ʼ�ġ�
	 * 
	 * 
	 * 
	    �������Ϸֲ���� 
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
		list.add(new Node(-1));     //-1��ʾһ���������ӡʱҪ����  

		int i = 0;  
		int size = list.size();  

		while (i < size) {

			System.out.println("i:��" + i + "  size: " + + size);

			Node curNode = list.get(i);  

			/*����������������������ʵ������� 
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

				if (curNode.val != -1 && curNode.left == null && curNode.right == null) {   //�Ѿ���������ײ�����һ��Ԫ�أ�����ѭ��  
					break;  
				}  
				size = list.size();  
				list.add(new Node(-1));       
			}  
		}  

		//�Ӻ���ǰ�������൱�ڡ�ջ��  
		
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
