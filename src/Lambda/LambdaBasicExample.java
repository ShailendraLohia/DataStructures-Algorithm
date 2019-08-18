package Lambda;

/**
 * Created by Shailendra on 11/24/2016.
 */
public class LambdaBasicExample {

    public static void main(String[] args) {

        //LambdaBasicExample lbe = new LambdaBasicExample();
        AddNumber addNumber = (int a,int b) ->  a + b;
        //AddNumber addPlay = () -> "hey I am playing";

        int total = addNumber.sum(2,5);
        System.out.println(total);

        printLamda((int a,int b) ->  a + b);
    }

    public static void printLamda(AddNumber nums) {
        System.out.println(nums.sum(5,8));
    }
}

@FunctionalInterface // can be used to those interfaces which are primarily used for lambda.
interface AddNumber {
    public int sum(int a, int b);
   // public String play();
}
