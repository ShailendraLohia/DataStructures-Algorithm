package linkedlist;

/**
 * Created by Shailendra on 10/8/2016.
 */
public class createLinkedList {

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        LinkedListNode node = new LinkedListNode();
        LinkedListNode node2 = new LinkedListNode();
        LinkedListNode lastNode = new LinkedListNode();

        node.setData(20);
        list.insertAtBegin(node);

        node2.setData(10);
        list.insertAtBegin(node2);

        lastNode.setData(30);
        list.insertAtLast(lastNode);

        System.out.println(list.length);

        LinkedListNode node3 = node.getNode();
        //node3 = node2.getNode();
        int data = node3.getData();


        System.out.println(data);

        boolean value = validateCircularLinkedList(list);

        System.out.println(value);

    }

    public static boolean  validateCircularLinkedList(LinkedListImpl listImpl) {

        if(listImpl.length == 0) {
            return false;
        }

        if(listImpl.length == 1) {
            return false;
            /*LinkedListNode node = listImpl.headNode;
            if(node.getNode() == null) {
                return false;
            }*/
        }
        else {
            LinkedListNode node,anotherNode;
            for(node = listImpl.headNode;(anotherNode=node.getNode()) !=null; node = anotherNode);
            return false;
        }

    }
}
