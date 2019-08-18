package Array;

/**
 * Created by shailendralohia on 10/20/18.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr= new int[] {1,2,3,4,5,6,7};
        leftRotate(arr,2);
        for(int i:arr) {
            System.out.println(i);
        }
    }

    public static void leftRotate(int[] arr, int rotate) {
        if(arr.length==0 || arr.length==1) {
            return;
        }
        for(int i=0;i<rotate;i++) {
            rotateByOne(arr);
        }

    }

    public static void rotateByOne(int[] arr) {
        int i,temp;
        temp=arr[0];
        for(i=0;i<arr.length-1;i++) {
            arr[i]=arr[i+1];
        }
        arr[i]=temp;
    }
}
