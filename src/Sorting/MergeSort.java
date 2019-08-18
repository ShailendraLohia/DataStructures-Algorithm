package Sorting;

import java.util.Arrays;

/**
 * Created by Shailendra on 3/7/2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort ms= new MergeSort();
        ms.mergeSorting(inputArr);
        for(int i: inputArr) {
            System.out.print(i+ " ");
        }
    }

    public static void mergeSorting(int[] arr) {
        if(arr.length < 2) {
            return;
        }
        int mid=(int)Math.floor(arr.length/2);

        int[] leftArray= Arrays.copyOfRange(arr,0,mid);
        int[] rightArray= Arrays.copyOfRange(arr,mid,arr.length);
        mergeSorting(leftArray);
        mergeSorting(rightArray);
        merge(leftArray,rightArray,arr);
    }

    public static void merge(int[] left,int[] right,int[] givenArr) {
        int i=0;
        int j=0;
        int k=0;

        while(i<left.length && j<right.length) {
            if(left[i]<=right[j]) {
                givenArr[k]=left[i];
                i=i+1;
            }
            else {
                givenArr[k]=right[j];
                j=j+1;
            }
            k=k+1;
        }
        while(i<left.length) {
            givenArr[k]=left[i];
            i=i+1;
            k++;
        }
        while(j<right.length) {
            givenArr[k]=right[j];
            j=j+1;
            k++;
        }
    }
}
