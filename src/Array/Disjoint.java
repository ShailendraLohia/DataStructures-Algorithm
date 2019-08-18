package Array;

import java.util.HashMap;

/**
 * Created by Shailendra on 2/12/2017.
 */
public class Disjoint {
    public static void main(String[] args) {
        int[] firstArray = {20, 21, 22};
        int[] secondArray = {22, 23, 24, 25, 20};

        int result = makeDisjoint(firstArray, secondArray);
        System.out.println(result);
    }

    public static int makeDisjoint(int[] first, int[] second) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //for(int i=0;)
        for (int i : first) {
            if (map.containsKey(i)) {
                count++;
            } else {
                map.put(i, 1);
            }
        }

        for (int i : second) {
            if (map.containsKey(i)) {
                count++;
            } else {
                map.put(i, 1);
            }
        }

        return count;
    }
}
