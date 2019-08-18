package Array;

/**
 * Created by shailendralohia on 10/23/18.
 */
public class MinimumElementInSortedAndRotatedArray {
    public static void main(String[] args) {
        int arr1[] = {5,6,1,2,3,4};
        int n1=arr1.length;
        System.out.println(findMinimum(arr1,0,n1-1));

        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMinimum(arr2, 0, n2-1));
                                                      
        int arr3[] =  {1};
        int n3 = arr3.length;                         
        System.out.println("The minimum element is "+ findMinimum(arr3, 0, n3-1));

        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMinimum(arr4, 0, n4-1));

        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMinimum(arr5, 0, n5-1));

        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMinimum(arr6, 0, n6-1));

        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMinimum(arr7, 0, n7-1));

        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMinimum(arr8, 0, n8-1));

        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMinimum(arr9, 0, n9-1));

    }

    public static int findMinimum(int[] arr, int low, int high) {
        if (high < low)
            return arr[0];

        if(high==low) {
            return arr[low];
        }

        int mid= low + (high-low)/2; // find mid element

        if(mid > low && arr[mid] < arr[mid-1]) {
            return arr[mid];  //if minimum element is mid element
        }
        if(mid < high && arr[mid] > arr[mid+1]) {
            return arr[mid+1]; // if minimum element is next of mid element
        }

        /*if(arr[low] < arr[mid]) {
            return findMinimum(arr,mid+1,high);
        }
        return findMinimum(arr,0,mid-1);*/

        if (arr[high] > arr[mid])
            return findMinimum(arr, low, mid-1);
        return findMinimum(arr, mid+1, high);
    }
}
