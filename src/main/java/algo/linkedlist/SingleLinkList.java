package algo.linkedlist;

import java.util.Hashtable;

import algo.linkedlist.RemoveDuplicateNode.Node;

public class SingleLinkList {
	public  Listnode head;
    public  Listnode current;

    // 添加节点
    public   void addnode(int data) {
        if (head == null) {
            head = new Listnode(data);
            current=head;
        }
        else {
            current.next=new Listnode(data);
            current=current.next;//移位
        }
    }


    // 节点类
    public  class Listnode {
        int value;
        Listnode next;
        Listnode(int x) {
            this.value = x;
        }
    }


    //遍历循环，打印链表的元素
    public  void printList(Listnode l) {
        if(l==null) return;
        current=l;
        if(current!=null){
            System.out.print(current.value+"\t");
            current=current.next;
            printList(current);//递归调用
        }
    }

    // 根据节点的data删除节点(仅仅删除第一个)  
    public void deleteNode(int data) {
        Listnode cur = head;
        Listnode pre=cur;//保存位置

        //找到目标元素的节点位置，cur
        while(cur.value!=data){
            if(cur.next==null){
                return;
            }
            pre=cur;
            cur=cur.next;
        }

        //判断cur的位置与头结点的关系
        if(cur==head){
            head=head.next;}
        else {
            pre.next=cur.next;
        }
    }

    //主方法
    public static void main(String [] args) {

        int[] a={1,2,3,5,6,5,8};
//        int[] b={6,4,3,2,1};

        SingleLinkList l1=new SingleLinkList();
//        SingleLinkList l2=new SingleLinkList();

        //在链表中插入元素
        for(int i=0;i<a.length;i++){
            l1.addnode(a[i]);
        }

//        for(int j=0;j<b.length;j++){
//            l2.addnode(b[j]);
//        }

        //删除操作
        l1.deleteNode(5);
        

        //打印链表的元素
        l1.printList(l1.head);
//        System.out.print("\n");
//        l2.printList(l2.head);
    }
}
