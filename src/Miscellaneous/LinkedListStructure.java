package Miscellaneous;


/**
 * Created by shailendralohia on 12/20/17.
 */
public class LinkedListStructure {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(10);
        linkedList.next=new LinkedList(20);
        linkedList.next.next=new LinkedList(30);
        linkedList.next.next.next=new LinkedList(40);

        reverseList(linkedList);
        //printData(linkedList);
        //insertNewNode(linkedList,40);
    }

    public static void printData(LinkedList ll) {
        if(ll==null) {
            System.out.println("Empty List");
        }
        LinkedList node=ll;

        while(node!=null) {
            System.out.println(node.data);
            node=node.next;

        }
    }

    public static void insertNewNode(LinkedList ll, int data) {
        if(ll==null) {
            System.out.println("Empty Node");
        }
            LinkedList node=new LinkedList(data);
            //node.data=data;

            if(ll.next==null){
                ll.next=node;
                node.data=data;
            }
            else {
                LinkedList tempNode=null;
                tempNode=ll.next;
                node.next=tempNode;
                //node.data=data;
                ll.next=node;
            }
            printData(ll);

    }

    public static void reverseList(LinkedList headNode) {
        LinkedList prevNode=null;
        LinkedList currentNode=headNode;
        LinkedList nextNode=null;

        currentNode=headNode;


        while(currentNode!=null) {
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        headNode=prevNode;
        printData(headNode);
    }


}
