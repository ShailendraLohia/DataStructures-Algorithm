package Miscellaneous.LinkedList_MISC;

import Miscellaneous.LinkedList;
import com.sun.xml.internal.bind.v2.TODO;

public class SortLinkedListInASC {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(2);
        ll.next.next = new LinkedList(3);
        ll.next.next.next = new LinkedList(4);
        ll.next.next.next.next = new LinkedList(5);

        //LinkedList resultNode = findMiddleElement(ll);
        LinkedList resultNode = mergeList(ll);
        while (resultNode!=null) {
            System.out.println("Sorted list is: " + resultNode.data);
            resultNode=resultNode.next;
        }

    }

    public static LinkedList findMiddleElement(LinkedList headNode) {
        LinkedList currentNode;
        LinkedList nextNode;

        currentNode=headNode;
        nextNode=currentNode.next;

        while(nextNode!=null) {
            nextNode=nextNode.next;
            if(nextNode!=null){
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
        }

        return currentNode;
    }

    public static LinkedList mergeList(LinkedList headNode) {
        if(headNode==null || headNode.next==null) {
            return headNode;
        }

        LinkedList middle=findMiddleElement(headNode);
        LinkedList nextMiddle = middle.next;
        //System.out.println(middle.data);
        middle.next=null;

        LinkedList leftList=mergeList(headNode);
        LinkedList rightList=mergeList(nextMiddle);

        LinkedList mergedList=mergeSorted(leftList,rightList);
        //System.out.println(mergedList.data);
        return mergedList;

    }

    public static LinkedList mergeSorted(LinkedList leftNode, LinkedList rightNode) {

        LinkedList result;

        if(leftNode==null)
            return rightNode;

        if(rightNode==null)
            return leftNode;

        if(leftNode.data <= rightNode.data) {
            result=leftNode;
            mergeSorted(result.next,rightNode);
        }
        else {
            result=rightNode;
            mergeSorted(leftNode,result.next);
        }
        return result;
    }
}
