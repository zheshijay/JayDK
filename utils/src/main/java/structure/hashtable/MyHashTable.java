package structure.hashtable;
//file MyHashTable.java
//Impelemtation of a chaining hash table saving values of class Person under
//keys of class String

//Node of the linked list associated with each entry of the hash table

class MyNode {
	protected String key;
	protected String value;
	protected MyNode next;
	protected MyNode(String kk, String vv) {    // Constructor
		key=kk; value=vv; }
	public String toString() {
		return "Node[" + key +  " " + value.toString() + "]"; }

}

//
//Each element of the hash table is the first node in a singly-linked
//unheaded list of nodes holding the key and the value.

public class MyHashTable {

	private static int DefaultSize = 17;

	private MyNode[] table;

	public MyHashTable(int size) {   // Constructor
		table = new MyNode[size];
	}

	public MyHashTable() { this(DefaultSize); } // Default constructor

	//Hashes string S to a value between 0 and L-1;
	public int MyHash(String S) {
		int Mult = 37;
		int Rem = table.length % Mult;
		if (Rem==0 || Rem==1 || Rem == table.length-1) Mult=43;
		int Sum = 0;
		for (int i=0; i<S.length(); i++)
			Sum = (Mult*Sum +  (int)S.charAt(i)) % table.length;
		return Sum;
	}


	//Find node for  Key at Index
	private MyNode FindNode(String Key, int Index) {
		MyNode N = table[Index];
		while (N != null && !(N.key.equals(Key))) 
			N = N.next; 
		return N;
	}

	//Add Person PP under key Key
	public void put(String Key, String value) { 
		int Index = MyHash(Key);
		if (FindNode(Key,Index) == null) {
			MyNode New = new MyNode(Key,value);
			New.next = table[Index];
			table[Index] = New;
		}
	}

	//Locate the Person object under string Key
	public String get(String Key) {
		int Index = MyHash(Key);
		MyNode N = FindNode(Key,Index);
		if (N==null) return null;
		else return N.value;
	}
}

