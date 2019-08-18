package MultiThreadProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shailendra on 12/4/2016.
 */
public class Sequence {

    private static List<Integer> addList = new ArrayList<Integer>();

    public static List<Integer> Create(int LowerBound, int UpperBound) {
        for(int i =LowerBound; i< UpperBound ; i++) {
            addList.add(i);
        }
        return addList;
    }
}
