package DoubleLinkedList;

public class DoubleLinkedListImpl {
    public static int size=0;
    public static DoubleLinkedListNode headNode;

    public static void main(String[] args) {
        insertAtBeginning(2);
        insertAtBeginning(1);
        insertAtLast(4);
        insertInBetween(3,2);
        System.out.println("Size: " + size());

        while(headNode.next!=null) {
            //DoubleLinkedListNode tempNode=headNode;
            System.out.print( headNode.data + ",");
            headNode=headNode.next;
            if(headNode.next==null)
                System.out.print(headNode.data + ",");
        }

    }

    public static int size() {
        return size;
    }

    public static void insertAtBeginning(int data) {
        if(size()==0) {
            headNode=new DoubleLinkedListNode(data);
            headNode.next=null;
            headNode.prev=null;

            size++;
        }else {
            DoubleLinkedListNode tempNode = new DoubleLinkedListNode(data);
            tempNode.next=headNode;
            tempNode.prev=null;
            headNode=tempNode;
            size++;
        }
    }

    public static void insertAtLast(int data) {
        if(size()==0) {
            headNode=new DoubleLinkedListNode(data);
            headNode.next=null;
            headNode.prev=null;

            size++;
        }else {
            DoubleLinkedListNode node=headNode;

            while (node.next!=null) {
                node=node.next;
                if(node.next==null) {

                    DoubleLinkedListNode tempNode = new DoubleLinkedListNode(data);
                    tempNode.next=null;
                    tempNode.prev=node;
                    node.next=tempNode;
                    node=tempNode;

                   // headNode=tempNode;
                    size++;
                }

            }
        }

    }
    public static void insertInBetween(int data,int nextTo) {
        DoubleLinkedListNode node=headNode;
        while(node!=null) {
            if(node.data==nextTo) {
                DoubleLinkedListNode tempNode = new DoubleLinkedListNode(data);
                tempNode.next=node.next;
                node.next=tempNode;
                tempNode.prev=node;
                node.next.prev=tempNode;

                size++;
                break;
            }
            node=node.next;
        }

    }

}
