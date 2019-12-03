package GeeksForGeeksPractice.Arrays;

public class FindPivotElement {
    public static void main(String[] args) {
        int[] arr={5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(findPivot(arr,0,arr.length-1));
    }

    public static int findPivot(int[] arr, int low,int high) {
        if(arr.length==0)
            return -1;

        int mid=low+(high-low)/2;

        if(mid<high && arr[mid]> arr[mid+1]) {
            return mid;
        }
        if(mid>low && arr[mid]<arr[mid-1])
            return mid-1;
        if(arr[low]>=arr[mid]) {
            return findPivot(arr,0,mid-1);
        }
        return findPivot(arr,mid+1,high);

    }
}
