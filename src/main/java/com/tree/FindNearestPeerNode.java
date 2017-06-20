package com.tree;

import java.util.LinkedList;
import java.util.List;

import com.tree.Tree.Node;
import com.tree.Tree.NodeVisitor;

public class FindNearestPeerNode<String> implements NodeVisitor<String> {

	public List<List> treeBranch = new LinkedList<List>();
	List<java.lang.String> nodeList = null;
	
	/**
	 * Method to form the parent -child link of the given tree structure
	 */
	@Override
	public boolean visit(Node<String> node) {
		Node<String> curr = node;
		int count =0;
		do {
			curr = curr.getParent();
			} while (curr != null);
		createBranch(node,count);
		count++;
		return true;

	}
	
	/**
	 * Method use to divide the tree into branch and each branch inserted into linkedlist
	 * @param currentNode
	 * @param count
	 */
	public void createBranch(Node<String> currentNode, int count) {
		
		Node<String> parentNode = currentNode.getParent();
		
		if(parentNode == null && count == 0){
			nodeList = new LinkedList<java.lang.String>();
			nodeList.add(currentNode.getValue().toString());
		}else if(!(nodeList.contains(currentNode.getValue().toString())) && (nodeList.size() !=0) && nodeList.get(nodeList.size()-1).toString() !=null && parentNode !=null && nodeList.get(nodeList.size()-1).toString().equalsIgnoreCase(parentNode.getValue().toString())) {
				nodeList.add(currentNode.getValue().toString());
			} else {
				if(!nodeList.contains(treeBranch)){
					treeBranch.add(nodeList);
				}
				nodeList = new LinkedList<java.lang.String>();
				Node<String> currNode = currentNode;
				nodeList.add(currentNode.getValue().toString());
				do {
					currNode = currNode.getParent();
					if(currNode !=null)
						nodeList.add(currNode.getValue().toString());
				} while(currNode.getParent() !=null);
				
				nodeList = reverseList(nodeList);
			}
	}
	
	/**
	 * Method used to reverse the list
	 * @param linkedList
	 * @return
	 */
	public static List<java.lang.String> reverseList(List<java.lang.String> linkedList) {
		LinkedList<java.lang.String> reversedlist = new LinkedList<java.lang.String>();
        for(int i=linkedList.size()-1;i>=0;i--) {
        	reversedlist.add(linkedList.get(i));
        }
        //System.out.println(reversedlist);
		return reversedlist;
    } 

	/**
	 * This method used to insert the last branch into branchList LinkedList
	 */
	public void completeBranch() {
		if(!nodeList.contains(treeBranch)){
			treeBranch.add(nodeList);
		}
	}
	
	/*void showTree() {
		for(int i=0;i<=treeBranch.size()-1;i++) {
			System.out.println(treeBranch.get(i));
		}
		
	}*/
	
	/**
	 * This method used to find the nearest peer node from the branchList
	 * @param nodeVal
	 * @return
	 */
	
	public String findClosestPeerNode(final String nodeVal) {
		
		int branchIndex = 0;
		int nodeIndex = 0;
		int incrementIndex = 0;
		String nearestNodeVal = null;
		//find the branch index based on the given node
		for(int i=0;i<=treeBranch.size();i++) {
			if(treeBranch.get(i).contains(nodeVal)) {
				branchIndex = i;
				break;
			}
		}
		
		//Find the node index from branch
		for(int j=0;j<treeBranch.get(branchIndex).size();j++) {
			String val = (String) treeBranch.get(branchIndex).get(j).toString();
			if(val.equals(nodeVal)) {
				nodeIndex = j;
				break;
			}
		}
		
		incrementIndex = branchIndex+1;
		
		do{
			if( (treeBranch.size() > incrementIndex)&& (treeBranch.get(incrementIndex).size()-1 >= nodeIndex) && (!nodeVal.equals(treeBranch.get(incrementIndex).get(nodeIndex)))) {
				nearestNodeVal = (String) treeBranch.get(incrementIndex).get(nodeIndex);
				//System.out.println("Closest Peer Node ::"+nearestNodeVal);
				break;
			} incrementIndex++;
		}while(treeBranch.size() > incrementIndex);
		
		return nearestNodeVal;
		
	}
}
