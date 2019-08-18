package linkedlist;

/**
 * Created by Shailendra on 10/8/2016.
 */
public class LinkedListImpl {

    public LinkedListNode headNode;
    public int length;

    public LinkedListImpl() {
        length=0;
    }

    public void insertAtBegin(LinkedListNode node) {

        if(length == 0) {
            headNode = node;
            length++;
        }
        else{
            node.setNode(headNode);
            headNode = node;
            length++;
        }
    }

    public void insertAtLast(LinkedListNode endNode) {
        if(length == 0) {
            headNode = endNode;
            length++;
        }
        else{
            LinkedListNode firstNode, secondNode;
            firstNode = headNode;

            while(firstNode.getNode() != null) {
                secondNode = firstNode.getNode();
                firstNode = secondNode;
            }
            firstNode.setNode(endNode);
            length++;
        }

    }

}
