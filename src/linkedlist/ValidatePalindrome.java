package linkedlist;

/**
 * Created by Shailendra on 10/8/2016.
 */
public class ValidatePalindrome {
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
        //lastNode.setNode(node3); //uncomment this to make this list cyclic.
        list.insertAtLast(lastNode);

        boolean result = isPalindrome(node3);
        System.out.println(result);
    }

    public static boolean isPalindrome(LinkedListNode headNode) {

        LinkedListNode tempNode = headNode;
        LinkedListNode reverseListNode= ReverseLinkedList.reverseList(tempNode);
        System.out.println(reverseListNode.getData());

        LinkedListNode firstNode, secondNode, reverseFirstNode,reverseSecondNode;
        firstNode = headNode;
        reverseFirstNode = reverseListNode;
        while(firstNode.getNode() != null && reverseFirstNode.getNode() !=null) {

            if(firstNode.getData() == reverseFirstNode.getData()) {
                secondNode = firstNode.getNode();
                firstNode = secondNode;
                reverseSecondNode = reverseFirstNode.getNode();
                reverseFirstNode = reverseSecondNode;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
