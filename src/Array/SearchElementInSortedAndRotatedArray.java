package Array;

/**
 * Created by shailendralohia on 10/21/18.
 */
public class SearchElementInSortedAndRotatedArray {
    public static void main(String[] args) {
        int arr[] = {8,9,1,2,3,4,5,6,7};
        int n = arr.length;
        int key = 5;
        int i = search(arr, 0, n-1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid])
        {
            /* As this sub array is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);

            return search(arr, mid+1, h, key);
        }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }
}
