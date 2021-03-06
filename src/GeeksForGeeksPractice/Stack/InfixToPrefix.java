package GeeksForGeeksPractice.Stack;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("(A+B)*C-D"));

    }
    public static String infixToPrefix(String expression) {
        String result="";
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<expression.length();i++) {
            char c=expression.charAt(i);
            if(Character.isLetterOrDigit(c))
                result+=c;

            else if(c=='(')
                stack.push(c);

            else if(c==')') {
                while(!stack.isEmpty() && stack.peek()!='(')
                    result=stack.pop()+result;
                if(!stack.isEmpty() && stack.peek()!='(')
                    System.out.println("invalid String");
                else
                    stack.pop();
            }

            else {
                while(!stack.isEmpty()&& Prec(c) <= Prec(stack.peek())) {
                    result=stack.pop()+result;
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result = stack.pop() + result;
        }
        return result;
    }
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
