package Stack;

/**
 * Created by Shailendra on 10/18/2016.
 */
public class FixedSizeStack {
    public int capacity;
    public static final int CAPACITY = 10;
    public int[] stack;
    public int top = -1;

    public FixedSizeStack() {
        //this(CAPACITY);
    }

    public FixedSizeStack(int cap) {
        capacity= cap;
        stack = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        if(top < 0) {
            return true;
        }
        return false;
    }

    public void push(int data) throws Exception{
        int stackSize = size();
        if(stackSize == capacity) {
            throw new Exception("Stack is full");
        }
        stack[stackSize] = data;
        top++;
    }

    public int top() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty Stack");
        }
        return stack[top];
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty Stack");
        }
        int data = stack[top];
        //stack[top] = Integer.MIN_VALUE;
        top = top -1;
        return data;
    }
}
