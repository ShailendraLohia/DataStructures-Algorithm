package linkedlist;

/**
 * Created by Shailendra on 2/13/2017.
 */
public class SortLinkedListInAscending {
    public static void main(String[]args) {
        LinkedList linkedList= new LinkedList(20);
        linkedList.next=new LinkedList(4);
        linkedList.next.next=new LinkedList(19);
        linkedList.next.next.next=new LinkedList(3);
        linkedList.next.next.next.next=new LinkedList(5);

        LinkedList resultNode = sortInAscending(linkedList);
        LinkedList firstNode, secondNode;
        firstNode = resultNode;

        System.out.println("\n");
        System.out.println("******After******");

        while(firstNode.next != null) {

            System.out.print(firstNode.data + " " + "->");
            secondNode = firstNode.next;
            firstNode = secondNode;
        }
        System.out.print(firstNode.data);

    }

    public static LinkedList sortInAscending(LinkedList headNode) {
        if(headNode==null) {
            return null;
        }
        LinkedList node=headNode;
        LinkedList tempNode=null;
        while(headNode!=null) {
            tempNode=headNode.next;

            if(headNode.data>tempNode.data) {
                LinkedList listNode = tempNode.next;
                tempNode.next = headNode.next;
                headNode.next = listNode;
                headNode = tempNode.next;
            }else{
                headNode=headNode.next;

            }
        }
        return headNode;
    }
}
