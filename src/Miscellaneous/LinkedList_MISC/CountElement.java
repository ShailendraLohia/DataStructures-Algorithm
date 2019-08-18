package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

public class CountElement {
    static int frequency;

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(2);
        ll.next.next=new LinkedList(3);
        ll.next.next.next= new LinkedList(4);
        ll.next.next.next.next= new LinkedList(2);

        System.out.println(countElementOccurrence(ll, 2));
    }

    public static int countElementOccurrence(LinkedList headNode, int data) {
        if(headNode==null) {
            return frequency;
        }
        if(headNode.data== data){
            return frequency++;
        }
         countElementOccurrence(headNode.next,data);
        return frequency;
    }
}
