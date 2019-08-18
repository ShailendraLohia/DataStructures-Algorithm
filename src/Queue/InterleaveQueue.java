package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        int k=5;

        System.out.println("Hello");
        queue=interleaveQueue(queue,k);

        System.out.println("world");

        while(k!=queue.size()) {
            queue.add(queue.poll());
            k++;
        }
        Stack<Integer> stack=new Stack<>();

        while(k/2!=queue.size()) {
            stack.push(queue.poll());
            //k--;
        }
        while(!queue.isEmpty() && !stack.isEmpty()) {
            System.out.print(stack.pop() + " " + queue.poll() + " ");

        }

    }

    static Queue<Integer> interleaveQueue(Queue<Integer> queue, int k) {
        if(k==0)
            return queue;
        if(queue.isEmpty())
            return queue;

        int data=queue.poll();
        interleaveQueue(queue,k-1);
        queue.add(data);
        return queue;
    }
}
