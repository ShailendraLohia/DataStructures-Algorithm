package Heaps;

/**
 * Created by Shailendra on 2/19/2017.
 */
public class PercolateDown {
    public static void main(String[] args) {
        int[] arr={31,10,21,9,1,12,18,3,2,8,7};
    }

    public static int[] percolateDown(int[] arr, int i) {
        if(arr.length==0) {
            return arr;
        }
        int left=2*i+1, right=2*i+2;
        int max,temp;
        int arrayLength=arr.length;

        if(left<=arrayLength && arr[left]>arr[i]) {
            max=left; //storing array indices
        }else{
            max=i; //storing array indices
        }

        if(right<=arrayLength && arr[right]>arr[max]) {
            max=right; //storing array indices
        }
        if(max!=i) {
            temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            percolateDown(arr,max);
        }
        return arr;

    }
}
