package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;

public class NthNodeFromLast {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(20);
        ll.next= new LinkedList(4);
        ll.next.next= new LinkedList(15);
        ll.next.next.next= new LinkedList(35);
        findNthNodeFromLast(3,ll);

    }

    public static void findNthNodeFromLast(int n, LinkedList headNode) {
        LinkedList main_ptr = headNode;
        LinkedList ref_ptr = headNode;

        int count=0;
        if(headNode!=null) {
            while(count<n) {
                if (ref_ptr == null) {
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
                while (ref_ptr != null)
                {
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println(main_ptr.data);

        }
        //return main_ptr.data;
    }
}
