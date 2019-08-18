package Stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(-1);
        input.add(5);
        input.add(6);
        input.add(2);


        // This is the temporary stack
        Stack<Integer> tmpStack=sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.isEmpty() || stack.size()==1) {
            return stack;
        }

        Stack<Integer> tempStack = new Stack<>();

        while(!stack.isEmpty()) {
            int temp=stack.pop();

            while(!tempStack.isEmpty() && tempStack.peek()>temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        return tempStack;
    }
}
