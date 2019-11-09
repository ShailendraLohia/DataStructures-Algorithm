package GeeksForGeeksPractice.LinkedList;

import Miscellaneous.LinkedList;

public class MiddleElement {
    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList(1);
        linkedList.next=new LinkedList(2);
        linkedList.next.next=new LinkedList(3);
        linkedList.next.next.next=new LinkedList(4);
        linkedList.next.next.next.next=new LinkedList(5);
        linkedList.next.next.next.next.next=new LinkedList(6);
        linkedList.next.next.next.next.next.next=new LinkedList(7);
        linkedList.next.next.next.next.next.next.next=new LinkedList(8);
        //linkedList.next.next.next.next.next.next.next.next=new LinkedList(9);

        findMiddleElement(linkedList);
    }

    public static void findMiddleElement(LinkedList headNode) {
        if(headNode==null)
            return;

        LinkedList slow_ptr=headNode;
        LinkedList fast_ptr= headNode;


        while(fast_ptr !=null && fast_ptr.next!=null) {
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;

        }
        System.out.println(slow_ptr.data);
    }
}
