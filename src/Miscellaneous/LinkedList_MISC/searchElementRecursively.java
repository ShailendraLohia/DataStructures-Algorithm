package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

/**
 * Created by shailendralohia on 12/24/17.
 */
public class searchElementRecursively {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.next = new LinkedList(15);
        ll.next.next = new LinkedList(12);
        ll.next.next.next = new LinkedList(13);
        ll.next.next.next.next = new LinkedList(20);
        ll.next.next.next.next.next = new LinkedList(14);

        boolean result=searchElement(25,ll);
        System.out.println(result);
    }

    public static boolean searchElement(int data, LinkedList headNode) {
        if(headNode==null){
            return false;
        }
        if(headNode.data==data) {
            return true;
        }
        return searchElement(data,headNode.next);
    }
}
