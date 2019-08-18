package Sorting;

/**
 * Created by Shailendra on 3/12/2017.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        //QuickSort ms= new QuickSort();
        quickSorting(inputArr,0, inputArr.length-1);
        for(int i: inputArr) {
            System.out.print(i+ " ");
        }
    }

    public static void quickSorting(int[] arr,int start, int end) {
        if(start>end) {
            return;
        }
        int pIndex=partition(arr,start,end);
        quickSorting(arr,start,pIndex-1);
        quickSorting(arr,pIndex+1,end);
    }

    public static int partition(int[] arr,int start,int end) {
        int pivot=arr[end];
        int pIndex=start;

        for(int i=start;i<=end-1;i++) {
            if(arr[i]<=pivot) {
                int temp=arr[i];
                arr[i]=arr[pIndex];
                arr[pIndex]=temp;

                pIndex++;
            }
        }
        int temp=arr[pIndex];
        arr[pIndex]=pivot;
        arr[end]=temp;

        return pIndex;

    }
}
