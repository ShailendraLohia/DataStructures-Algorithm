package Array;

public class MultipleLeftRotation {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,8};
        leftRotate(arr,2);
        leftRotate(arr,4);
    }
    public static int[] preProcess(int[] arr) {
        if(arr.length==0) {
            return arr;
        }
        int arrayLength=arr.length;

        int[] tempArray= new int[2*arrayLength];

        for(int i=0;i<arrayLength;i++) {
            tempArray[i]=tempArray[i+arrayLength]=arr[i];
        }
        return tempArray;
    }

    public static void leftRotate(int[] arr, int k) {
        if(arr.length==0) {
            return;
        }

        int arrLength = arr.length;
        int[] tempArray= preProcess(arr);

        int startRotationIndex= k%arrLength;

        for(int i=startRotationIndex;i<startRotationIndex+arrLength;i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println();
    }

}
