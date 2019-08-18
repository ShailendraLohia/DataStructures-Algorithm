package linkedlist;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by Shailendra on 10/22/2016.
 */
public class ValidateNullTerminatedList {

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

        LinkedListNode firstNode, secondNode;
        firstNode = node3;

        /*System.out.println("******Before******");
        while(firstNode.getNode() != null) {
            System.out.print(firstNode.getData() + " " + "->");
            secondNode = firstNode.getNode();
            firstNode = secondNode;
        }
        System.out.print(firstNode.getData());*/

       boolean result = validateCyclicList(node3);
       System.out.println(result);
    }

    public static boolean validateCyclicList(LinkedListNode headNode) {
        Map<LinkedListNode,Integer> map = new HashMap();

        LinkedListNode node,nextNode;
        node = headNode.getNode();
        int i=0;
        while(node != null) {
            if(!(map.containsKey(node.node))) {
                map.put(node.node,i++);
                node = node.getNode();
            }
            else {
                return true;
            }
        }
        return false;
    }
}
