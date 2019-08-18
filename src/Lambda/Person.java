package Lambda;

import java.util.Comparator;

/**
 * Created by Shailendra on 11/25/2016.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public static final Comparator<Person> BY_FIRST= (lhs,rhs) ->lhs.firstName.compareTo(rhs.firstName);
    public static final Comparator<Person> BY_LAST= (lhs,rhs) ->lhs.lastName.compareTo(rhs.lastName);
    public static final Comparator<Person> BY_AGE= (lhs,rhs) ->lhs.age-(rhs.age);

    public static final Comparator<Person> BY_FIRSTNAME= Comparator.comparing(Person::getFirstName);
    public static final Comparator<Person> BY_LASTNAME= Comparator.comparing(Person::getLastName);
    public static final Comparator<Person> BY_AGERULE= Comparator.comparing(Person::getAge);


    public Person(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person[firstName =" + firstName + ",lastName =" + lastName + ",age=" + age + "]";

    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


}
