package Array;

/**
 * Created by Shailendra on 2/18/2017.
 *
 * Sum of the products of all possible Subsets
 Given an array of n non-negative integers. The task is to find the sum of the product of elements of all
 the possible subsets. It may
 be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

 Input : arr[] = {1, 2, 3}
 Output : 23
 Possible Subset are: 1, 2, 3, {1, 2}, {1, 3},
 {2, 3}, {1, 2, 3}
 Products of elements in above subsets :
 1, 2, 3, 2, 3, 6, 6
 Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6
 = 23
 */
public class productOfSubsetSums {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(ProductOfSubsetSums(arr));
    }

    public static int ProductOfSubsetSums(int[] arr) {
        int ans=1;
        for(int i=0;i<arr.length;i++) {
            ans=ans+(arr[i] +1);
        }
        return ans-1;
    }



}
