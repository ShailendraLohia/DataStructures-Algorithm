package Heaps;

/**
 * Created by Shailendra on 2/22/2017.
 */
public class Heapifying {
    public static void main(String[] args) {
        int[] arr={31,21,10,9,1,12,18,3,2,8,7,23};
        arr=buildHeap(arr);
        for(int i:arr) {
            System.out.print(i + " ");
        }
    }
    public static int[] buildHeap(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int arrayLength= arr.length;
        int nonHeapPositions= (int)Math.floor(arrayLength/2);
        for(int i=0;i<nonHeapPositions;i++) {
            arr=percolateDown(arr,i);
        }
        return arr;

    }

    public static int[] percolateDown(int[] arr, int i) {

        int left=2*i+1, right=2*i+2;
        int max,temp;
        int arrayLength=arr.length;

        if(left<=arrayLength && arr[left]>arr[i]) {
            max=left; //storing array indices
        }else{
            max=i; //storing array indices
        }
        /*if(right==arrayLength) {
            right=right-1;
            if(arr[right]>arr[max]) {
                max=right; //storing array indices
            }
        }
        else*/ if(right<arrayLength && arr[right]>arr[max]) {
            max=right; //storing array indices
        }
        if(max!=i) {
            temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            percolateDown(arr,--i);
        }
        return arr;

    }
}
