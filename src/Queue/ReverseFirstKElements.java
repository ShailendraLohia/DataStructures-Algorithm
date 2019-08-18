package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k=5;
        queue=reverseQueueFirstKElements(queue,k,0); //reverse first K elements

        while(k!=queue.size()) {
            queue.add(queue.poll());
            k++;
        }
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static Queue<Integer> reverseQueueFirstKElements(Queue<Integer> queue, int k, int count) {
        if(k==count)
            return queue;
        if(queue.isEmpty())
            return queue;

        int data= queue.poll();
        reverseQueueFirstKElements(queue,k,count+1);
        queue.add(data);
        return queue;

    }
}
