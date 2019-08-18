package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/delete-array-elements-which-are-smaller-than-next-or-become-smaller/
public class DeleteElements {
    public static void main(String[] args) {
        int[] arr={20, 10, 25, 30, 40};
        deleteElements(arr,arr.length,2);

    }

    public static void deleteElements(int[] arr, int size, int k) {
        if(arr.length!=size)
            return;
        Stack<Integer> stack= new Stack<>();
        stack.push(arr[0]);
        int count=0;
        for(int i=1;i<size;i++) {
            while(!stack.isEmpty()&& stack.peek() <arr[i]&&count<k) {
                stack.pop();
                count++;
            }
            stack.push(arr[i]);
        }
        int length=stack.size();
        for(int i=0;i<length;i++) {
            System.out.println(stack.pop());
        }

    }
}
