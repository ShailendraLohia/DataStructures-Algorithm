package Lambda;

import java.util.function.BiConsumer;

/**
 * Created by Shailendra on 11/27/2016.
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someOfNumbers = {1,2,3,4};
        int key = 2;

       // BiConsumer<Integer, Integer> consumer = (v,k) -> System.out.println(v+k);
        process(someOfNumbers,key,wrapperLambda((v,k) -> System.out.println(v+k)));
        //process(someOfNumbers,key,wrapperLambda(consumer));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for(int i: someNumbers) {
            consumer.accept(i,key);
            //(v,k) -> System.out.println(i+key);
        }
    }

    private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer) {
        return (k,v) -> {
            try {
                consumer.accept(k,v);
            }catch(ArithmeticException e) {
                System.out.println("ArithmeticException caught in wrapper Lambda");
            }
        };
    }
}
