package linkedlist;

/**
 * Created by Shailendra on 10/22/2016.
 */
public class SortInAscending {

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        LinkedListNode node = new LinkedListNode();
        LinkedListNode node2 = new LinkedListNode();
        LinkedListNode lastNode = new LinkedListNode();
        LinkedListNode node3 = new LinkedListNode();

        node.setData(10);
        list.insertAtBegin(node);

        node2.setData(20);
        list.insertAtBegin(node2);

        node3.setData(40);
        list.insertAtLast(node3);

        lastNode.setData(5);
        //lastNode.setNode(node3); //uncomment this to make this list cyclic.
        list.insertAtLast(lastNode);

        LinkedListNode firstNode, secondNode;
        firstNode = node2;
        System.out.println("******Before******");
        while(firstNode.getNode() != null) {
            System.out.print(firstNode.getData() + " " + "->");
            secondNode = firstNode.getNode();
            firstNode = secondNode;
        }
        System.out.print(firstNode.getData());

        LinkedListNode resultNode = sortNode(node2);
        //LinkedListNode firstNode, secondNode;
        firstNode = resultNode;

        System.out.println("\n");
        System.out.println("******After******");

        while(firstNode.getNode() != null) {

            System.out.print(firstNode.getData() + " " + "->");
            secondNode = firstNode.getNode();
            firstNode = secondNode;
        }
        System.out.print(firstNode.getData());

    }


    public static LinkedListNode sortList(LinkedListNode headNode) {

        LinkedListNode firstNode, secondNode;
        firstNode = headNode;
        int data = headNode.getData();
        int nextData;

        while(firstNode.getNode()!=null) {
            secondNode=firstNode.getNode();
            nextData=secondNode.getData();

            if(data>nextData) {
                firstNode.setData(nextData);
                secondNode.setData(data);
                firstNode = headNode;
                data = firstNode.getData();
            }
            else {
                firstNode = secondNode;
                data = firstNode.getData();
            }
        }

        return headNode;
    }

    public static LinkedListNode sortNode(LinkedListNode headNode) {
         LinkedListNode firstNode, secondNode;
            firstNode = headNode;
            int data = headNode.getData();
            int nextData;

            while(firstNode.getNode()!=null) {
                secondNode=firstNode.getNode();
                nextData=secondNode.getData();

                if(data>nextData) {
                    LinkedListNode tempNode =new LinkedListNode();
                    tempNode.node=secondNode.node;
                    secondNode.node= firstNode.node;
                    firstNode.node=tempNode.node;
                    //headNode=firstNode;
                    data = firstNode.getData();


                    /*firstNode.setData(nextData);
                    secondNode.setData(data);
                    firstNode = headNode;
                    data = firstNode.getData();*/
                }
                else {
                    firstNode = secondNode;
                    data = firstNode.getData();
                }
            }

            return firstNode;
    }


}


