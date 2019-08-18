package HackerRank.StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "[]()[(})]";
        System.out.println(isBalancedBracket(str));

    }

    /*public static String isBalanced(String str) {
        if(str.length()==0 || str==null )
            return "NO";

        if(str.length()%2 !=0) {
            return "NO";
        }

        Map<Character,Character> map = new HashMap<>();

        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        int midLength=str.length()/2 -1;
        for(int i=midLength;i>=0;i--) {
            if(map.containsKey(str.charAt(i))) {
                char value= map.get(str.charAt(i));
                if(str.charAt(++midLength) != value) {
                    return "NO";
                }

            } else {
                return "NO";
            }
        }
        return "YES";
    }*/

    public static String isBalancedBracket(String s) {
        if(s.length()==0 || s==null )
            return "NO";

        if(s.length()%2 !=0) {
            return "NO";
        }

        Map<Character,Character> map = new HashMap<>();

        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++) {
            char value = s.charAt(i);
            if(map.containsKey(value)) {
                stack.push(value);
            }
            else if (!stack.isEmpty()) {
                    char closeParenthesis = map.get(stack.peek());
                    if (closeParenthesis == value) {
                        stack.pop();
                    }
            } else return "NO";

        }
        if(stack.isEmpty()) {
            return "YES";
        }
        return "NO";

    }


}
