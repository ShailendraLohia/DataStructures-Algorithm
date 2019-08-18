package Miscellaneous.Heap;

import java.util.Arrays;

/**
 * Created by shailendralohia on 1/6/18.
 */
public class InsertElement {
    public static void main(String[] args) {
        int[] arr={31,21,10,9,1,12,18,3,2,8,7,23};
        int[] newArr=insertElement(arr,28);
        for(int element:newArr) {
            System.out.print(element + ",");
        }
    }

    public static int[] insertElement(int[] arr, int data) {
        if(arr.length==0) {
            return arr;
        }

        int[] newArr=new int[arr.length+1];
        newArr= Arrays.copyOfRange(arr,0,newArr.length);
        newArr[newArr.length-1]=data;
        arr=null;
        int index=(int)Math.ceil((newArr.length-1)/2);
        return BuildHeap.buildMaxHeap(newArr,index);
    }
}
