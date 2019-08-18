package Array;

import java.util.stream.IntStream;

/**
 * Created by shailendralohia on 10/21/18.
 * Input:  arr[] = {1, 2, 3, 4, 5}
   Output: arr[] = {5, 1, 2, 3, 4}
 */
public class CyclicallyRotate {
    public static void main(String[] args) {
        int[] arr=new int[] {1,2,3,4,5};
        cyclicRotate(arr,2);
        for(int i:arr) {
            System.out.println(i);
        }
    }

    public static void cyclicRotate(int[] arr, int rotate) {
        /*IntStream.range(0,rotate)
                .map*/
        for(int i=0;i<rotate;i++) {
            rotateCyclicByOne(arr);
        }

    }

    public static void rotateCyclicByOne(int[] arr) {
        if(arr.length==0)
            return;

        int temp;
        temp=arr[arr.length-1]; //assign last element to temp variable
        for(int i=arr.length-2;i>=0;i--) {
            arr[i+1]=arr[i];
        }
       // IntStream.range(arr.length-2, 0)

        arr[0]=temp;
    }
}
