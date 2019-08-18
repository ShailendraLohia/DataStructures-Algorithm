package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;
import sun.awt.image.ImageWatched;

/**
 * Created by shailendralohia on 12/24/17.
 */
public class SwapNodes {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.next = new LinkedList(15);
        ll.next.next = new LinkedList(12);
        ll.next.next.next = new LinkedList(13);
        ll.next.next.next.next = new LinkedList(20);
        ll.next.next.next.next.next = new LinkedList(14);

        LinkedList headNode=swapNodes(ll,10,18);
        while(headNode!=null) {
            System.out.println(headNode.data);
            headNode=headNode.next;
        }
    }

    public static LinkedList swapNodes(LinkedList headNode, int x, int y) {
        if (headNode==null)
            return headNode;

        if(x==y) {
            return headNode;
        }
        LinkedList prevX=null, currX=headNode;
        while(currX!=null && currX.data!=x) { // Track X
            prevX=currX;
            currX=currX.next;
        }

        LinkedList prevY=null, currY=headNode;
        while(currY!=null && currY.data!=y) { // Track Y
            prevY=currY;
            currY=currY.next;
        }

        if(currX==null || currY==null) { // if both currX and currY are null
            return headNode;
        }

        if(prevX!=null) {
            prevX.next=currY;
        }
        else{
            headNode=currY;
        }
        if(prevY!=null) {
            prevY.next=currX;
        }
        else{
            headNode=currX;
        }
        //swap nodes
        LinkedList node=currX.next;
        currX.next=currY.next;
        currY.next=node;

        return headNode;
    }
}
