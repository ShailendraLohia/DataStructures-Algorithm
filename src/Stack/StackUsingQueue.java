package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());

    }

    static class Stack {
        private static Queue<Integer> q1 = new LinkedList<>();
        private static Queue<Integer> q2 = new LinkedList<>();

        static int currentPosition;

        Stack() {
            currentPosition=0;
        }

        static void push(int element) {
            q1.add(element);
            currentPosition++;

            while(!q2.isEmpty()) {
                q1.add(q2.remove());
            }

            Queue<Integer> q = q2;
            q2=q1;
            q1=q;

        }

        static void pop() {
            if(q2.isEmpty()) {
                return;
            }
            q2.remove();
            currentPosition--;
        }
        static int top() {
            if(q2.isEmpty()) {
                return -1;
            }
            return q2.peek();
        }
        static int size() {
            return currentPosition;
        }

    }
}
