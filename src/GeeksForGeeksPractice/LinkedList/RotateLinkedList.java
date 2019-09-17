package GeeksForGeeksPractice.LinkedList;

import Miscellaneous.LinkedList;

import java.util.stream.Stream;

public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList(1);
        linkedList.next=new LinkedList(2);
        linkedList.next.next=new LinkedList(3);
        linkedList.next.next.next=new LinkedList(4);
        linkedList.next.next.next.next=new LinkedList(5);
        linkedList.next.next.next.next.next=new LinkedList(6);
        linkedList.next.next.next.next.next.next=new LinkedList(7);
        linkedList.next.next.next.next.next.next.next=new LinkedList(8);

        LinkedList resultNode= rotateLinkedList(linkedList,4);

        while(resultNode!=null) {
            System.out.println(resultNode.data);
            resultNode=resultNode.next;
        }

//        Stream.of(resultNode)
//                .forEach(resultNode.data);

    }


    public static LinkedList rotateLinkedList(LinkedList headNode, int position) {
        if(headNode==null)
            return headNode;

        LinkedList tempNode=null;
        LinkedList lastNode=null;
        LinkedList firstNode=headNode;

        int count=1;

        while(headNode!=null) {
            if(count==position)
                tempNode=headNode;
            if(headNode.next==null)
                lastNode=headNode;

            headNode=headNode.next;
            count++;
        }
        lastNode.next=firstNode;
        firstNode=tempNode.next;
        tempNode.next=null;

        return firstNode;


    }
}
