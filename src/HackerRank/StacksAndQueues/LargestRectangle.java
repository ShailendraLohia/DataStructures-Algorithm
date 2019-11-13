package HackerRank.StacksAndQueues;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int input[] ={6, 2, 5, 4, 5, 1, 6};
        System.out.println(maximumArea(input));

    }

    public static int maximumArea(int input[]) {
        if(input.length==0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea=0;
        int area=0;
        int i;
        for(i=0;i<input.length;) {
            if(stack.isEmpty() || input[stack.peek()]<=input[i]) { //stack.peek() gives height of previous bar.
                // if previous bar is smaller, push index.
                stack.push(i++); // push array index not array element
            }else {
                int top=stack.pop();
                if(stack.isEmpty()) {
                    area=input[top]*i;
                }else {
                    area=input[top] *(i- stack.peek() -1); // stack.peek() gives an index from where breadth will be calculated.
                    }
                if(area>maxArea) {
                    maxArea=area;
                }
            }

        }
        while(!stack.isEmpty()) {
            int top=stack.pop();
            if(stack.isEmpty()) {
                area=input[top]*i;
            }else {
                area=input[top] *(i- stack.peek() -1);
            }
            if(area>maxArea) {
                maxArea=area;
            }
        }
        return maxArea;
    }
}
