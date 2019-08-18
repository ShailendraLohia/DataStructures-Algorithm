package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

public class FindLength {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next=new LinkedList(2);
        ll.next.next=new LinkedList(3);

        int result=findLengthRecursive(ll);
        System.out.println(result);
    }

    public static int findLengthRecursive(LinkedList headNode) {

        if(headNode==null) {
            return 0;
        }
        //count++;
        return 1 + findLengthRecursive(headNode.next);

    }
}
