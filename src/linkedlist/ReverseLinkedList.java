package linkedlist;

/**
 * Created by Shailendra on 10/8/2016.
 */
public class ReverseLinkedList {

    // 10->20->30->40
    public static LinkedListNode reverseList(LinkedListNode headNode) {

        LinkedListNode previousNode = headNode;
        LinkedListNode currentNode = previousNode.getNode();
        LinkedListNode nextNode = currentNode.getNode();

        previousNode.node = null;

        while(currentNode != null) {
            currentNode.node = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(currentNode !=null) {
                nextNode = currentNode.node;
            }

            headNode = previousNode;
        }
        return headNode;
    }

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

        LinkedListNode resultNode = reverseList(node3);
        //LinkedListNode firstNode, secondNode;
        firstNode = resultNode;

        System.out.println("******After******");

        while(firstNode.getNode() != null) {

            System.out.print(firstNode.getData() + " " + "->");
            secondNode = firstNode.getNode();
            firstNode = secondNode;
        }
        System.out.print(firstNode.getData());
    }
}
