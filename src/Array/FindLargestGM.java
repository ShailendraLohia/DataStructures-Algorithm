package Array;

/**
 * Created by Shailendra on 2/18/2017.
 * Find a subset with greatest geometric mean
 Given an array of positive integers, the task is that we find a subset of
 size greater than one with maximum product.

 Input  : arr[] = {1, 5, 7, 2, 0};
 Output : 5 7
 The subset containing 5 and 7 produces maximum
 geometric mean

 Input  : arr[] = { 4, 3 , 5 , 9 , 8 };
 Output : 8 9
 */
public class FindLargestGM {
    public static void main(String[] args) {
        int[] arr= {4, 3 , 5 , 9 , 8};
        findLargestGM(arr);
    }


    public static void findLargestGM(int[] arr) {
        if(arr.length < 2) {
            System.out.println("Invalid Input");
            return;
        }
        int first=Integer.MIN_VALUE, second=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > first) {
                second=first;
                first=arr[i];
            }
            else if(arr[i] > second) {
                second=arr[i];
            }
        }
        System.out.println(first+ " " + second);
    }
}
