package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shailendra on 12/26/2016.
 */
public class PredicateLambdaExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Thomas","Carlyle", 51),
                new Person("Charlotte","Bronte", 45),
                new Person("Matthew","Arnold", 39)
        );

        Predicate<Person> drinkingAge = (person) -> person.getAge() >=50;
        Predicate<Person>  name = (it) -> it.getFirstName().startsWith("C");

        people.stream().filter(drinkingAge.or(name)).
                forEach(person -> System.out.println(person.getFirstName()));

        System.out.println("\n");


// Map and reduce Function example
        //IntStream ages = people.stream().mapToInt(Person::getAge); //map example
        IntStream ages = people.stream().mapToInt(person -> person.getAge());


        System.out.println("\n");
        // Others reduce function are COUNT(), MIN(), MAX() and SUM()
        int sum = people.stream().mapToInt(Person::getAge).sum();// reduce function example.

        System.out.println(sum);

        //String str= people.stream().filter(i->i.getLastName().startsWith("C"));
    }
}
