package GeeksForGeeksPractice.Stack;

//https://www.geeksforgeeks.org/reduce-the-string-to-minimum-length-with-the-given-operation/

import java.util.Stack;

public class ReduceStringToMinimumLength {
    public static void main(String[] args) {
        String str= "ASbBsD";
        int length=minimumStringSize(str,str.length());

        System.out.println(length);
    }

    public static int minimumStringSize(String str, int length) {
        if(length==0)
            return 0;

        Stack<Character> stack= new Stack<>();

        for(int i=0;i<str.length();i++) {
            if(stack.isEmpty())
                stack.push(str.charAt(i));
            else{
               char c=stack.peek();
               if(c!=str.charAt(i)
                   && Character.toUpperCase(c)== Character.toUpperCase(str.charAt(i))) {

                   stack.pop();
               }
               else {
                   stack.push(str.charAt(i));
               }
            }
        }
        return stack.size();
    }
}
