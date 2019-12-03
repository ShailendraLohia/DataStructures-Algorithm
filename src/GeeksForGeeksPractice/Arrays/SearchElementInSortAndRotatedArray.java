package GeeksForGeeksPractice.Arrays;

import java.util.Arrays;

public class SearchElementInSortAndRotatedArray {
    public static void main(String[] args) {
        int[] arr={5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(findElement(arr,5));

    }

    public static boolean findElement(int[] arr, int key) {
        if(arr.length==0)
            return false;
        int position=-1;
        int result=-1;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>arr[i+1]) {
                position = i + 1;
                break;
            }
        }

        if(key==arr[position])
            return true;
        if(key<arr[0]) {
            //search in right
            int[] newArray= Arrays.copyOfRange(arr,position,arr.length);
            result=performBinarySearch(newArray,key);
        }
        else{
            //search in left
            int[] newArray= Arrays.copyOfRange(arr,0,position);
            result=performBinarySearch(newArray,key);
        }

        if(result==-1)
            return false;

        return true;
    }

    public static int performBinarySearch(int[] arr,int key) {
        int low=0;
        int high=arr.length-1;

        int mid;
        while(low<=high) {
            mid=low+(high-low)/2;

            if(arr[mid]==key)
                return mid;
            else if(arr[mid]<key)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

}
