package Miscellaneous.Heap;

//https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
public class ValidateArrayAsMaxHeap {
    public static void main(String[] args) {
        int[] arr= {90, 15, 10, 7, 12, 2};
        boolean result = validateArrayAsMaxHeap(arr);

        System.out.println(result);

    }

    public static boolean validateArrayAsMaxHeap(int[] arr) {
        if(arr.length==0)
            return true;
        int countOfLeafNodes=0;
        int maxIteration=0;
        boolean isOddArrayLength=false;

        if(arr.length%2==0) {
            maxIteration = (int)Math.ceil((arr.length-1)/2);
            isOddArrayLength=true;
        }
        else {
            maxIteration = (int)Math.ceil((arr.length-1)/2);
            countOfLeafNodes= maxIteration+1;
        }

        System.out.println("maxIteration: " + maxIteration);
        for(int i=0;i<maxIteration;i++) {
            if(arr[i]> arr[(2*1)+1] && arr[i]>arr[(2*i)+2]) {
                continue;
            }
            else
                return false;
        }

        if(isOddArrayLength) {
            if(arr[maxIteration] > arr[2*maxIteration+1]) {
                return true;
            }
            else return false;
        }
        return true;
    }
}
