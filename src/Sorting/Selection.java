package Sorting;

/**
 * Created by Shailendra on 3/6/2017.
 */
public class Selection {
    public static void main(String[] args) {
      int[] arr={2,7,4,1,5,3};
      arr=selectionSort(arr);

      for(int i: arr) {
          System.out.print(i+ " ");
      }
    }

    public static int[] selectionSort(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int temp;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i] > arr[j]) {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
