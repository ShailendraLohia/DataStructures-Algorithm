package PluralSightLambda;

/**
 * Created by shailendralohia on 9/3/17.
 */
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> p1=s -> s.length()<20;
        Predicate<String> p2 = s -> s.length() > 5 ;

        boolean result=p1.test("Hello");
        System.out.println(result);

        Predicate<String> p3 = p1.and(p2) ;
        System.out.println("P3 for Yes: " + p3.test("Yes"));

        //Predicate<String> p4=Predicate.antoherExample("Hello");
    }
}
