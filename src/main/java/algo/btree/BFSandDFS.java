package algo.btree;

import java.util.ArrayList;
import java.util.List;

public class BFSandDFS {
	public Node a;

	@SuppressWarnings("unused")
	public BFSandDFS() {
		// Construct the tree.

		a = new Node("a");
		Node b = a.createChildNode("b");
		Node c = a.createChildNode("c");
		Node d = b.createChildNode("d");
		Node e = c.createChildNode("e");
		Node f = c.createChildNode("f");
		Node g = e.createChildNode("g");
		Node h = e.createChildNode("h");
	}

	public void testDFS() {
		System.out.println();
		System.out.println("Testing DFS");
		visitDFS(a); // visit from the root

	}

	// performs DFS from the given node

	public void visitDFS(Node nodeStart) {
		// Entering node - pre-order walk

		for (Node child : nodeStart.children) {
			visitDFS(child); // recursive call

		}
		// Leaving node - post-order walk

		System.out.print(nodeStart.nodeName + " ");
	}

	public void testBFS() {
		System.out.println("Testing BFS");
		visitBFS(a); // visit from the root

	}

	// performs BFS from the given node

	public void visitBFS(Node nodeStart) {
		List<Node> pendingExplore = new ArrayList<Node>(); // list of nodes

		// pending

		// exploration

		pendingExplore.add(nodeStart);
		while (pendingExplore.size() > 0) {
			Node currentNode = pendingExplore.remove(0);
			System.out.print(currentNode.nodeName + " ");
			pendingExplore.addAll(currentNode.children);
		}
	}

	// Application entry point

	public static void main(String[] args) {
		BFSandDFS testTree = new BFSandDFS();
		testTree.testBFS();
		testTree.testDFS();
	}

	// Node class

	public static class Node {
		public Node parent;
		public List<Node> children = new ArrayList<Node>();

		public String nodeName;

		public Node(String nodeName) {
			this.nodeName = nodeName;
		}

		public Node createChildNode(String childNodeName) {
			Node child = new Node(childNodeName);
			child.parent = this;
			children.add(child);
			return child;
		}
	}

}
