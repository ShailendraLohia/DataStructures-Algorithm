package Sorting;

/**
 * Created by Shailendra on 3/6/2017.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={2,7,4,1,5,3};
        arr=insertionSorting(arr);

        for(int i: arr) {
            System.out.print(i+ " ");
        }
    }

    public static int[] insertionSorting(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int temp,value;
        for(int i=1;i<arr.length;i++) {
            temp=arr[i];
            value=i;

            while(value>0 && arr[value-1] > temp  ) {
                arr[value]=arr[value-1];
                value=value-1;
            }
            arr[value]=temp;
        }

        return arr;

    }
}
