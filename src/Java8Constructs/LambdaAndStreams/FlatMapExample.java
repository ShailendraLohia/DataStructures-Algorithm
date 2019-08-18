package Java8Constructs.LambdaAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
//import static java.util.stream.Collectors.groupingBy;

/**
 * Created by shailendralohia on 11/26/17.
 */
public class FlatMapExample {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java","Magazine","is","good");
        Map<String,Long> letterCount=
                words.map(w->w.split(" "))
                .flatMap(Arrays::stream)
                .collect(groupingBy(identity(),counting()));

        letterCount.forEach((key,value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });
    }
}
