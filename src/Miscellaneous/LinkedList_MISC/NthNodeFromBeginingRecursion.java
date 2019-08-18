package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

public class NthNodeFromBeginingRecursion {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList(1);
        ll.next=new LinkedList(2);
        ll.next.next=new LinkedList(3);
        ll.next.next.next=new LinkedList(4);

        int result = findNthNode(ll,2);
        System.out.println(result);

    }
    // TODO This program is not working if node become null
    public static int findNthNode(LinkedList headNode, int index) {
        int count = 1;
        /*if(headNode==null)
            return 0;*/
        if(count==index) {
            return headNode.data;
        }

        return findNthNode(headNode.next,index-1);
    }
}
