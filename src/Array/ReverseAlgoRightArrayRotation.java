package Array;

public class ReverseAlgoRightArrayRotation {
    public static void main(String[] args) {
        int[] arr_= new int[]{1,2,3,4,5,6,7,8,9,10};
        rightRotate(arr_,3);

        for(int i: arr_) {
            System.out.print(i + " ");
        }

    }

    public static void rightRotate(int[] arr_, int rotateBy_) {
        if(arr_.length==0 || rotateBy_ < 1) {
            return;
        }
        reverseArray(arr_,0,arr_.length-1);
        reverseArray(arr_,0,rotateBy_-1);
        reverseArray(arr_, rotateBy_,arr_.length-1);
    }

    public static void reverseArray(int[] arr_, int startIndex_, int endIndex_) {

        while(startIndex_ < endIndex_) {
            int temp=arr_[startIndex_];
            arr_[startIndex_]= arr_[endIndex_];
            arr_[endIndex_]=temp;
            startIndex_++;
            endIndex_--;
        }

    }
}
