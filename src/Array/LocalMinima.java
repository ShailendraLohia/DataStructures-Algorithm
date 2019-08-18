package Array;

/**
 * Created by Shailendra on 2/12/2017.
 * From GeeksforGeeks
 * Find a local minima in an array
 Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minima in it.
 We say that an element arr[x] is a local minimum if it is less than or equal to both its neighbors.

 For corner elements, we need to consider only one neighbor for comparison.
 There can be more than one local minima in an array, we need to find any one of them.
Example
 Input: arr[] = {23, 8, 15, 2, 3};
 Output: Index of local minima is 1
 */
public class LocalMinima {
    public static void main(String[] args) {
        int[] first={1, 2, 3};
        int result= findLocalMinima(first);

        System.out.println(result);
    }

    public static int findLocalMinima(int[] first) {
        int count=0;
        //For first element
        if(first[0] < first[1]) {
            count++;
        }
        //For Last element
        if(first[first.length-1] < first[first.length -2]) {
            count++;
        }
        for(int i=1; i<=first.length -2;i++) {
            if(first[i] < first[i-1] && first[i] < first[i+1]) {
                count++;
            }
        }

        return count;
    }
}
