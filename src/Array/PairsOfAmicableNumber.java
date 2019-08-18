package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shailendra on 2/18/2017.
 * Pairs of Amicable Numbers
 Given an array of integers, print the number of pairs in the array that form an amicable pair.
 Two numbers are amicable if the first is equal to the sum of divisors of the second, and if the
 second number is equal to the sum of divisors of the first.

 Input  : arr[] = {220, 284, 1184, 1210, 2 , 5}
 Output : 2
 Explanation : (220, 284) and (1184, 1210)
 form amicable pair
 */
public class PairsOfAmicableNumber {
    public static void main(String[] args) {
        int[] arr={220, 284, 1184, 1210, 2 , 5};
        //System.out.println(Math.sqrt(220));
        int result=countPairs(arr);
        System.out.println(result);
    }

    public static int countPairs(int[] arr) {
        if(arr.length<2) {
            return 0;
        }
        int count=0;

        for(int i=0;i<arr.length;i++) {
            int sum= sumOfDiv(arr[i]);
            if(isAmicable(arr[i],sum)) {
                count++;
            }
        }
        return count/2;
    }

    public static int sumOfDiv(int x) {
        int sum=1;
        for(int i=2;i<Math.sqrt(x);i++) {

            if (x%i == 0)
            {
                sum += i;
                sum += x/i;

                // To handle perfect squares
                /*if (x/i != i)
                    sum += x/i;*/
            }
        }
        return sum;
    }
    // Check if pair is amicable
    public static boolean isAmicable(int a, int b)
    {
        return (sumOfDiv(a) == b && sumOfDiv(b) == a);
    }
}
