package Stack;

import Miscellaneous.LinkedList;

// Adding node in last: 1->2->3->4->NULL
// Adding node at beginning (help to build Stack using linked list): 4->3->2->1->NULL

public class StackUsingLinkedList {
    private static LinkedList topNode;
    private static int size=0;

    public static void main(String[] args) {
        LinkedList list= new LinkedList(10);
        push(list);
        LinkedList list_2=new LinkedList(20);
        push(list_2);
        System.out.println("Size of stack: "+ size());
        top();
        pop();
        top();
        System.out.println("Stack is Empty: " + isEmpty());
        pop();
        System.out.println("Stack is Empty: " + isEmpty());
        System.out.println("Size of Stack: " + size());
    }

    public static void push(LinkedList node) {
        if(size==0) {
            topNode=node;
            System.out.println(topNode.data);
            size++;
        } else {
            node.next=topNode;
            topNode=node;
            System.out.println(topNode.data);
            size++;
        }

    }

    public static void pop() {
        topNode=topNode.next;
        size--;
    }

    public static void top() {
        System.out.println(topNode.data);
    }

    public static boolean isEmpty() {
        return topNode==null;
    }

    public static int size() {
        return size;
    }

}
