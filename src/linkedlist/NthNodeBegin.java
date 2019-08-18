package linkedlist;

/**
 * Created by Shailendra on 10/16/2016.
 */
public class NthNodeBegin {

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        LinkedListNode node = new LinkedListNode();
        LinkedListNode node2 = new LinkedListNode();
        LinkedListNode lastNode = new LinkedListNode();
        LinkedListNode node3 = new LinkedListNode();

        node.setData(30);
        list.insertAtBegin(node);

        node2.setData(20);
        list.insertAtBegin(node2);

        node3.setData(10);
        list.insertAtBegin(node3);

        lastNode.setData(40);
        list.insertAtLast(lastNode);

        LinkedListNode firstNode, secondNode;
        firstNode = node3;

        System.out.println("******Before******");
        while(firstNode.getNode() != null) {
            System.out.print(firstNode.getData() + " " + "->");
            secondNode = firstNode.getNode();
            firstNode = secondNode;
        }

        System.out.print(firstNode.getData());
        System.out.print("\n"); // new line

        boolean result = findNthNodeFromBegin(node3,10);

        System.out.println(result);

    }

    public static boolean findNthNodeFromBegin(LinkedListNode headNode, int data) {

        if(headNode.getData() == data) {
            return true;
        }

        LinkedListNode listNode = headNode.getNode();

        while(listNode.node != null) {

            if(listNode.getData() == data) {
                return true;
            }
            else {
                listNode = listNode.getNode();
            }
        }


        return false;
    }
}
