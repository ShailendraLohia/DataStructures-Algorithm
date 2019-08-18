package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Reverse {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        reverseQueueUsingRecursion(queue);

    }

    public static void reverseQueueUsingRecursion(Queue<Integer> queue) {
        if(queue.size()==0) {
            return;
        }

        int data=queue.poll();
        reverseQueueUsingRecursion(queue);
        queue.add(data);
        System.out.println(queue.poll());
    }
}
