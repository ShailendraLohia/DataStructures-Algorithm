package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shailendralohia on 10/23/18.
 */
public class PairInArray {
    public static void main(String[] args) {
        int[] arr= new int[] {11, 15, 6, 8, 9, 10};
        boolean result= findSumPair(arr,arr.length,23);
        System.out.println(result);
    }

    public static boolean findSumPair(int[] arr, int arrLength, int sum) {
       // List<Integer> list= new ArrayList<>();
        if(arr.length<=0)
            return false;

        int i;
        for(i=0;i<arrLength;i++) {
            if(arr[i] > arr[i+1])
                break;
        }
        int minimumElementIndex=(i+1) % arrLength;
        int maximumElementIndex=i;

        while(minimumElementIndex != maximumElementIndex) {

            if(arr[minimumElementIndex] + arr[maximumElementIndex] == sum) {
                return true;
            }

            if(arr[minimumElementIndex] + arr[maximumElementIndex] < sum) {
                minimumElementIndex=(minimumElementIndex + 1 ) % arrLength;
            }
            else {
                maximumElementIndex= (arrLength + maximumElementIndex - 1) % arrLength;
            }
        }
        return false;
    }
}
