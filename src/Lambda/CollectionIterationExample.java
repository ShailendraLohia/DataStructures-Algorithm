package Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shailendra on 11/27/2016.
 */
public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Thomas","Carlyle", 51),
                new Person("Charlotte","Bronte", 45),
                new Person("Matthew","Arnold", 39)
        );

        people.forEach(p ->System.out.println(p));
        people.forEach(System.out:: println); // another example of lambda.
    }
}
