package algo.btree;

public class Node2 {
	public int val;
			public Node2 next;
			public Node2(int val){
				this.val = val;
				this.next = null;
			}
			
			public boolean hasNext(){
				if(this.next != null) return true;
				return false;
			}
}
