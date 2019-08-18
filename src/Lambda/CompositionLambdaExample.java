package Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Shailendra on 12/26/2016.
 */
public class CompositionLambdaExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Thomas","Carlyle", 51),
                new Person("Charlotte","Bronte", 45),
                new Person("Matthew","Arnold", 39)
        );

        Collections.sort(people,Person.BY_FIRST.thenComparing(Person::getAge));
        printAllByFirstName(people);
        Collections.sort(people, Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName));
        System.out.println("\n");
        printAll(people);


    }

    private static void printAll(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }
    private static void printAllByFirstName(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }
}
