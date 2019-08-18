package Stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> result = reverseStack(stack);
        int length=stack.size();

        /*System.out.println("**** Before*****");
        for(int i=0;i<length;++i) {
            System.out.println(stack.pop());
        }*/
        System.out.println("**** After*****");
        for(int i=0;i<length;i++) {
            System.out.println(result.pop());
        }


    }
    // Using recursion

    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return stack;

        int temp=stack.pop();
        reverseStack(stack);
        insertAtBottom(stack,temp);
        return stack;
    }
    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int temp=stack.pop();
        insertAtBottom(stack,element);
        stack.push(temp);
    }
}
