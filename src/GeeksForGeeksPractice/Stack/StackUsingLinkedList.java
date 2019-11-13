package GeeksForGeeksPractice.Stack;

public class StackUsingLinkedList {
    private static int size=0;
    private static LinkedList headNode;

    class LinkedList {
        private int data;
        private LinkedList next;
    }

    public void pushDataInReverseOrder(int data) {

        LinkedList linkedList=new LinkedList();
        if(size==0) {
            headNode=linkedList;
            linkedList.data=data;
            linkedList.next=null;
            size++;
        }
        else {
            linkedList.next=headNode;
            linkedList.data=data;
            headNode=linkedList;
            size++;
        }

    }

    public static void main(String[] args) {
        StackUsingLinkedList linkedList=new StackUsingLinkedList();

        linkedList.pushDataInReverseOrder(1);
        linkedList.pushDataInReverseOrder(2);
        linkedList.pushDataInReverseOrder(3);

        System.out.println(size);

        while(headNode!=null) {
            System.out.print(headNode.data + " ");
            headNode=headNode.next;
        }
    }
}
