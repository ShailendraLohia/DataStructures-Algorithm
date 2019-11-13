package GeeksForGeeksPractice.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.stream.IntStream;

public class IndexOfPairSum {
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int n = 16;
        findIndexOfPairSum(A, n);
    }

    public static void findIndexOfPairSum(int[]arr, int sum) {
        HashMap<Integer,Integer> map=new HashMap<>();

        IntStream.range(0, arr.length).forEach(i -> {
            int temp = sum - arr[i];
            if (map.containsKey(temp)) {
                System.out.println(map.get(temp) + "," + i);
            }
            map.put(arr[i], i);
        });
    }
}
