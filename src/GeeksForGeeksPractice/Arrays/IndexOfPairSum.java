package GeeksForGeeksPractice.Arrays;

import java.util.HashMap;

public class IndexOfPairSum {
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int n = 16;
        findIndexOfPairSum(A, n);
    }

    public static void findIndexOfPairSum(int[]arr, int sum) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int temp= sum-arr[i];

            if(map.containsKey(temp)) {
                System.out.println(map.get(temp)+ "," + i);
            }
            map.put(arr[i],i);
        }

    }
}
