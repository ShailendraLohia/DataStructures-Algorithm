package Heaps;

import java.util.Arrays;

/**
 * Created by Shailendra on 2/22/2017.
 */
public class DeleteFromHeap {
    private static int arrayLength;
    public static void main(String[] args) {
        int[] arr={31,10,21,9,1,12,18,3,2,8,7};
        arr=deleteElement(arr,4);
        for(int i:arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] deleteElement(int[] arr, int index) {
        //arr=Heapifying.buildHeap(arr);
        arrayLength=arr.length;
        int lastElement=arr[arrayLength-1];
        arr[index] = lastElement;
        arr=PercolateDown.percolateDown(arr,index);
        arr= Arrays.copyOf(arr,--arrayLength);
        return arr;

    }
}
