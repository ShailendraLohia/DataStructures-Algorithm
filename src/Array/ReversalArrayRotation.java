package Array;

/**
 * Created by shailendralohia on 10/20/18.
 */
public class ReversalArrayRotation {
    public static void main(String[] args) {
        int[] arr=new int[] {1,2,3,4,5,6,7};
        reversalRotate(arr,2);
        for (int i:arr) {
            System.out.println(i);
        }

    }
    public static void reversalRotate(int[] arr, int rotate) {
        int arrLength=arr.length;
        reverseArray(arr,0,rotate-1);
        reverseArray(arr,rotate,arrLength-1);
        reverseArray(arr,0, arrLength-1);

    }

    public static void reverseArray(int[] arr,int start, int end) {
        if(start>end) {
            return;
        }
        int temp;
        while(true) {
            if (!(start < end)) break;
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
