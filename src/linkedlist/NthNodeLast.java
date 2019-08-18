package linkedlist;

/**
 * Created by Shailendra on 10/16/2016.
 */
public class NthNodeLast {
    static int counter=0;

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

        LinkedListNode result = findNthNodeFromLastUsingRecursion(node3,3);

        System.out.println(result.getData());

    }


    public static LinkedListNode findNthNodeFromLast(LinkedListNode headNode, int listPosition) {

        LinkedListNode node = headNode, NthNode=null;
        int listLength = 1;

        while(listLength != listPosition) {
            if(node != null)
            node = node.getNode();
            listLength++;
        }
        while(node != null) {
            if(NthNode == null)
            {
                NthNode = headNode;
            }
            else{
                NthNode = NthNode.getNode();
            }
            node = node.getNode();
        }
        if(NthNode != null){
            return NthNode;
        }
        return null;
    }

    public static LinkedListNode findNthNodeFromLastUsingRecursion(LinkedListNode headNode, int listPosition) {
        if(headNode!=null) {
            findNthNodeFromLastUsingRecursion(headNode.getNode(),listPosition);
            counter++;
            if(counter==listPosition) {
                return headNode;
            }
        }
        return null;
    }
}
