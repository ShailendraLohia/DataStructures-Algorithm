package GeeksForGeeksPractice.LinkedList;

import Miscellaneous.LinkedList;

public class LinkedListInReverseOrder {
    private static int size=0;
    private static LinkedList headNode;

    public static void main(String[] args) {
        pushDataInReverseOrder(1);
        pushDataInReverseOrder(2);
        pushDataInReverseOrder(3);

        System.out.println(size);

        while(headNode!=null) {
            System.out.print(headNode.data + "->");
            headNode=headNode.next;
        }

    }

    public static void pushDataInReverseOrder(int data) {

        LinkedList linkedList=new LinkedList(data);
        if(size==0) {
            headNode=linkedList;
            linkedList.next=null;
            size++;
        }
        else {
            linkedList.next=headNode;
            headNode=linkedList;
            size++;
        }

    }
}
