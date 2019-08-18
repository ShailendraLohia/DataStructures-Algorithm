package Lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shailendralohia on 8/27/17.
 */

public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("For Each demo");
        //System::println("For each demo");

        List<String> list=new ArrayList<String>();
        list.add("BBB");
        list.add("DDD");
        list.add("AAA");
        list.add("CCC");

        list.stream().forEach(s->System.out.println(s));

        System.out.println("For EachOrder demo");

        List<String> list1=new ArrayList<String>();
        list1.add("BBB");
        list1.add("DDD");
        list1.add("AAA");
        list1.add("CCC");

        list1.stream().forEachOrdered((s)->System.out.println(s));

    }
}
