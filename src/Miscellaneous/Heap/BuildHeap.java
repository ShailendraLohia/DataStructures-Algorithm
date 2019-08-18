package Miscellaneous.Heap;

/**
 * Created by shailendralohia on 1/1/18.
 */
public class BuildHeap {

    public static void main(String[] args) {
        int[] arr={31,21,10,9,1,12,18,3,2,8,7,23};
        int index=(int)Math.ceil((arr.length-1)/2);
        int[] result=buildMaxHeap(arr,index);
        for(int data: result) {
            System.out.print(data + ",");
        }
    }


    public static int[] buildMaxHeap(int[] arr, int index) {
        if(arr.length<0 || index<0) {
            return arr;
        }
        /*if(index<0) {
            return arr;
        }*/

        int temp,max;
        int left=2*index +1, right=2*index + 2;

        if(arr.length>left && arr[index] < arr[left]) {
            max=left;
        }else {
            max=index;
        }

        if(arr.length>right && arr[index] < arr[right] && arr[left] < arr[right]) {
            max=right;
        }

        if(max!=index) {//swap
            temp=arr[index];
            arr[index]= arr[max];
            arr[max]=temp;
            //index=index-1;
            buildMaxHeap(arr, max);
        }
        buildMaxHeap(arr, --index);
        return arr;
    }
}

