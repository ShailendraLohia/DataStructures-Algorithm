package Sorting;

/**
 * Created by Shailendra on 3/6/2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={2,7,4,1,5,3};
        arr=bubbleSorting(arr);

        for(int i: arr) {
            System.out.print(i+ " ");
        }
    }

    public static int[] bubbleSorting(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int temp;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-1;j++) {
                if(arr[j] > arr[j+1]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
