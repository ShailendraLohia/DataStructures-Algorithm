package Java8Constructs.LambdaAndStreams;


import Java8Constructs.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by shailendralohia on 11/26/17.
 */
public class PredicateExample {

    public static void main(String[] args) {
        List<User> users= Arrays.asList(
                new User(1,"Shailendra","Chicago","Music"),
                new User(2,"Ritu","NYC","Shopping"),
                new User(3,"Bikky","Madhuban","Cricket"),
                new User(4,"Amit","Raxul","Business")
        );

        Predicate<User> city= (it) ->it.getCity().startsWith("C");
        Predicate<User> hobby=(it) -> it.getHobby().equals("Music");

        users.stream().filter(city.or(hobby))
                .forEach(it->System.out.println(it.getName()));

        //MaptoInt example
        List<String> mapInt= Arrays.asList("1","2","3");
        int sum= mapInt.stream().mapToInt(it->Integer.parseInt(it)).sum(); //reduce Example using sum operator
        System.out.println("Total sum" + " " + sum);

        // reduce example using max() operator.
        System.out.println("Max value" + " " + mapInt.stream().mapToInt(it->Integer.parseInt(it)).max());
    }

}
