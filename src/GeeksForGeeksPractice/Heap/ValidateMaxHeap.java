package GeeksForGeeksPractice.Heap;

//https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
public class ValidateMaxHeap {
    public static void main(String[] args) {
        int[] arr= {90, 15, 10, 7, 12, 2};
        int index=0;

        // Find last non-leaf node
        if(arr.length%2==0) {
            index=(int)Math.ceil((arr.length-1)/2);
        }
        else
            index=(int)Math.ceil((arr.length-2)/2);

        System.out.println(isMaxHeap(arr,index));
    }

    public static boolean isMaxHeap(int[] arr, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(index> -1) {
            return true;
        }

        if(arr.length>left && arr[index]<arr[left])
            return false;
        if(arr.length>right && arr[index]<arr[right])
            return false;

        return isMaxHeap(arr,--index);
    }
}
