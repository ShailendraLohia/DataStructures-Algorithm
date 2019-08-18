package linkedlist;

import java.util.HashMap;

/**
 * Created by Shailendra on 2/11/2017.
 */
public class NullTerminatedOrCyclic {
    public static void main(String[] args) {
        LinkedList linkedList= new LinkedList(10);
        linkedList.next=new LinkedList(20);
        linkedList.next.next=new LinkedList(30);
        linkedList.next.next.next=new LinkedList(40);
        linkedList.next.next.next.next=new LinkedList(50);
        linkedList.next.next.next.next.next=new LinkedList(60);
        linkedList.next.next.next.next.next.next=new LinkedList(70);
        linkedList.next.next.next.next.next.next.next=new LinkedList(80);
        //linkedList.next.next.next.next.next.next.next.next=linkedList.next.next;

        boolean result=isNullTerminated(linkedList);
        if(result) {
            System.out.println("Null Terminated");
        }
        else {
            System.out.println("Cyclic");
        }
    }

    public static boolean isNullTerminated(LinkedList headNode) {
        if(headNode==null)
            return false;
        HashMap<LinkedList,Integer> map=new HashMap<>();
        while(headNode!=null) {

            if(!(map.containsKey(headNode))) {
                map.put(headNode,headNode.data);
                headNode=headNode.next;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
