package Array;

/**
 * Created by shailendralohia on 10/27/18.
 */
public class FindRotationCountInSortedArray {
    public static void main(String[] args) {
        int[] arr=new int[] {15, 18, 2, 3, 6, 12};
        System.out.println(countRotation(arr));
        System.out.println(countRotation_anotherSolution(arr,0,arr.length-1));
    }

    // First solution
    public static int countRotation(int[] arr) {
        if(arr.length==0)
            return 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>arr[i+1])
                return i+1;
        }
        return 0;
    }

    // Second solution
    public static int countRotation_anotherSolution(int[] arr, int low, int high) {
        if(arr.length==0)
            return 0;
        if(high<low)
            return 0;

        if(high==low)
            return low;
        int mid=low + (high-low)/2;

        if(mid >low && arr[mid-1]>arr[mid])
            return mid;

        if(high>mid && arr[mid] >arr[mid+1])
            return mid+1;

        if(arr[low] > arr[mid])
            return countRotation_anotherSolution(arr,low,mid-1);

        return countRotation_anotherSolution(arr,mid+1,high);
    }
}
