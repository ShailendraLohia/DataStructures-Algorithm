package Stack;

import java.util.Stack;

public class DeleteMiddleElement {
    public static void main(String[] args) {
        Stack<Character> st =
                new Stack<Character>();

        // push elements into the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');

        deleteMidElement(st, st.size(), 0);
        //deleteMidElement(st, st.size(), st.size());
        //System.out.println(7%2 + 7/2);
        while (!st.empty())
        {
            char p=st.pop();
            System.out.print(p + " ");
        }

    }

    public static void deleteMidElement(Stack<Character> stack,
                                                    int size, int currentCount) {
        if(stack.isEmpty() || size==currentCount)
            return;
//        if(stack.isEmpty() || currentCount==0)
//            return;

        char tempData=stack.pop();
        //TODO: why current++ is not being incremented here
        deleteMidElement(stack,size,currentCount+1);
        if(currentCount!=size/2)
            stack.push(tempData);

        //return stack;

    }
}
