package Array;

/**
 * Created by Shailendra on 2/18/2017.
 */
public class ThreeWayPartition {
    public static void main(String[] args) {
        int[] arr={1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowVal=14,highVal=20;
        threeWayPartition(arr,lowVal,highVal);

        for (int i=0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");

        }

    }

    public static void threeWayPartition(int[] arr, int lowVal,int highVal) {
        int start=0;
        int end= arr.length-1;
        int arrLength=arr.length;

        for(int i=0;i<end;) {
            if(arr[i]<lowVal) {
                int temp=arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
                i++;
            }
            else if(arr[i] > highVal) {
                int temp=arr[end];
                arr[end]=arr[i];
                arr[i]=temp;
                end--;
            }
            else {
                i++;
            }
        }
    }
}
