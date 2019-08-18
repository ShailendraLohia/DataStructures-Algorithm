package PluralSightLambda;

/**
 * Created by shailendralohia on 9/3/17.
 */

@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T t);

    public default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t) ;
    }

    public default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    public static <U> Predicate<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }

    /*public default  <Z> String anotherExample(Z u) {
        return t -> test(t) && s -> s.;
    }*/
}
