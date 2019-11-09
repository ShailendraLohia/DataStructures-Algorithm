package GeeksForGeeksPractice.Arrays;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/?track=md-arrays&batchId=144

import PluralSightLambda.Predicate;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr= {15, 2, 4, 8, 9, 5, 10, 23};
        int targetSum=23;

        subArrayWithGivenSum(arr,targetSum);

//        Predicate<Integer> predicate= (i)->i>targetSum;
//        IntStream.range(1,arr.length)
//                .filter(predicate)
//                .
//                .
    }

    public static void subArrayWithGivenSum(int[] arr, int targetSum) {
        int curr_sum=arr[0]; //initialize curr_sum as first element
        int start=0;

        for(int i=1;i<=arr.length;i++) {
            while(curr_sum>targetSum && start<i) { //curr_sum is greater than target sum
                curr_sum=curr_sum-arr[start]; // subtract curr_sum with element whose position is at start index.
                start++;
            }
            if(curr_sum==targetSum) {
                int p=i-1; // by this time i increment by one.
                System.out.println(start + " " + p);
                break;
            }
            //if(i<arr.length)
            else
                curr_sum=curr_sum+arr[i];
        }

    }

}
