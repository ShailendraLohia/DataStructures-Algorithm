package Miscellaneous.Heap;

/**
 * Created by shailendralohia on 1/6/18.
 */
public class SearchElement {
    public static void main(String[] args) {
        int[] arr={31,21,28,9,8,23,18,3,2,1,7,10,12};  //Assuming this is maxHeap
        int index=(int)Math.floor((arr.length/2-1));
        boolean result= searchElement(arr,19,index);
        System.out.println(result);

    }
    public static boolean searchElement(int[] arr, int data,int index) {
        if (arr.length == 0 || index<0) {
            return false;
        }
        int left=2*index+1, right=2*index+2;

        if(arr[index]==data) {
            return true;
        }
        if(left<arr.length && arr[left]==data) {
            return true;
        }
        if(right<arr.length && arr[right]==data) {
            return true;
        }
        index=index-1;
        return searchElement(arr,data,index);
    }
}
