package GeeksForGeeksPractice.Arrays;

//https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/?track=md-arrays&batchId=144

import java.util.HashMap;

public class LargestSubarray {
    public static void main(String[] args) {
        int[] arr={0,0,1,0,1};
        findLargestSubarray(arr);

    }

    public static void findLargestSubarray(int[] arr) {
        if(arr.length==0 || arr.length==1) {
            System.out.println(0);
            return;
        }
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i:arr){
            if(map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            }
            else
                map.put(i,1);
        }

        if(map.get(0)==map.get(1))
            System.out.println(map.get(0)*2);
        if(map.get(0)< map.get(1))
            System.out.println(map.get(0)*2);
        if(map.get(0)> map.get(1))
            System.out.println(map.get(1)*2);
    }
}
