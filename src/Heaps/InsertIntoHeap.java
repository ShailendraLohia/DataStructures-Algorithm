package Heaps;

import java.util.Arrays;

/**
 * Created by Shailendra on 3/20/2017.
 */
public class InsertIntoHeap {
    public static void main(String[] args) {
        int[] arr={31,10,21,9,1,12,18,3,2,8,7};
        arr=insertIntoHeap(arr,23);
        for(int i:arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] insertIntoHeap(int[] arr,int data) {
        if(arr.length==0)
            return arr;
        //int index=(int)Math.floor(arr.length/2);
        arr=Heapifying.buildHeap(arr);
        int[] newArray=new int[arr.length+1];
        newArray= Arrays.copyOfRange(arr,0,arr.length+1);
        newArray[newArray.length-1]=data;
        newArray=Heapifying.buildHeap(newArray);
        arr=null;

        return newArray;
    }
}
