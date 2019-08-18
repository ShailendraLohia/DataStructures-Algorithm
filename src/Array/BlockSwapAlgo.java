package Array;

public class BlockSwapAlgo {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
         //(arr, 2, 7);
        for (int i : arr) {
            System.out.println(1);
        }
        System.out.println(arr);
    }

    static void swap(int arr[], int fi, int si, int d) {
        int i, temp;
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    static void leftRotate(int arr[], int d, int n) {
  /* Return If number of elements to be rotated is
    zero or equal to array size */
        if (d == 0 || d == n)
            return;

  /*If number of elements to be rotated is exactly
    half of array size */
        if (n - d == d) {
            swap(arr, 0, n - d, d);
            return;
        }

        /* If A is shorter*/
        if (d < n - d) {
            swap(arr, 0, n - d, d);
            leftRotate(arr, d, n - d);
        } else /* If B is shorter*/ {
            swap(arr, 0, d, n - d);
            leftRotate(arr, 2 * d - n, d); /*This is tricky*/  //TODO this concept is not correct
        }
    }

}
