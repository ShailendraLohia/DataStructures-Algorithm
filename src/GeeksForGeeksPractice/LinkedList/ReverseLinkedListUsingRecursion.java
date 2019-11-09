package GeeksForGeeksPractice.LinkedList;

import Miscellaneous.LinkedList;
//https://www.geeksforgeeks.org/recursive-approach-to-find-nth-node-from-the-end-in-the-linked-list/

public class ReverseLinkedListUsingRecursion {
    static int counter=0;
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList(1);
        linkedList.next=new LinkedList(2);
        linkedList.next.next=new LinkedList(3);
        linkedList.next.next.next=new LinkedList(4);
        linkedList.next.next.next.next=new LinkedList(5);

        reverseLinkedList(linkedList,2);
    }

    public static void reverseLinkedList(LinkedList headNode, int nthNodeFromLast) {
        if(headNode!=null) {
            reverseLinkedList(headNode.next, nthNodeFromLast);

            counter++;
            if (counter == nthNodeFromLast)
                System.out.println(headNode.data);
        }

    }
}
