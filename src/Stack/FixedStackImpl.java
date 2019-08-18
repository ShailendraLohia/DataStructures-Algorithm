package Stack;

/**
 * Created by Shailendra on 10/18/2016.
 */
public class FixedStackImpl {
    public static void main(String[] args) throws Exception{
        FixedSizeStack fixSize = new FixedSizeStack(10);

        fixSize.push(10);
        fixSize.push(20);
        fixSize.push(30);
        fixSize.push(40);
        fixSize.push(50);

        int size = fixSize.size();
        System.out.println("Size of stack before POP " + size);
        for(int i=0;i<fixSize.size();i++) {
            System.out.print(fixSize.stack[i] + ",");
        }
        fixSize.pop();
        System.out.print("\n");
        for(int i=0;i<fixSize.size();i++) {
            System.out.print(fixSize.stack[i] + ",");
        }
        System.out.println("Size of stack after POP " + fixSize.size());


    }
}
