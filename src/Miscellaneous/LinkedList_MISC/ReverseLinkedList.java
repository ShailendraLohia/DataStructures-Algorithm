package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

/**
 * Created by shailendralohia on 12/24/17.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next=new LinkedList(2);
        ll.next.next= new LinkedList(3);
        ll.next.next.next= new LinkedList(4);
        ll.next.next.next.next=new LinkedList(5);

        LinkedList headNode=reverseList(ll);
        while(headNode!=null) {
            System.out.println(headNode.data);
            headNode=headNode.next;
        }


    }

    public static LinkedList reverseList(LinkedList headNode) {
        if(headNode==null)
            return headNode;

        LinkedList previousNode=null;
        LinkedList currentNode=headNode;
        LinkedList nextNode;

        while(currentNode!=null) {
            nextNode=currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
            /*if(nextNode.next!=null) {
                nextNode = nextNode.next;
            }*/
            headNode=previousNode;
        }
        return headNode;
    }
}
