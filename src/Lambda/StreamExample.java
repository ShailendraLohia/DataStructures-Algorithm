package Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shailendra on 11/27/2016.
 */
public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Thomas","Carlyle", 51),
                new Person("Charlotte","Bronte", 45),
                new Person("Matthew","Arnold", 39)
        );

        people.stream().filter(person -> person.getLastName().startsWith("C")).
                forEach(person -> System.out.println(person.getFirstName()));

        
    }


}
