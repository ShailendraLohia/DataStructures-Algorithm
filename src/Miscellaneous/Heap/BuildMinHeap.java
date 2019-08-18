package Miscellaneous.Heap;

public class BuildMinHeap {
    public static void main(String[] args) {
        int[] arr={13,16,41,41,51,100,31};
        int index=(int)Math.ceil((arr.length-1)/2);
        if(arr.length%2!=0) {
            index= index-1;
        }
        int[] result=buildMinHeap(arr,index);
        for(int data: result) {
            System.out.print(data + ",");
        }
    }

    public static int[] buildMinHeap(int[] arr, int index) {
        if(arr.length==0)
            return arr;

        int min, temp;

        int left = 2*index +1;
        int right = 2*index + 2;

        if(arr.length>left && arr[index] > arr[left]) {
            min=left;
        }
        else {
            min=index;
        }

        if(arr.length>right && arr[index] > arr[right] && arr[left] > arr[right]) {
            min=right;
        }


        if(min!=index) {
            temp=arr[index];
            arr[index]= arr[min];
            arr[min]=temp;
            //index=index-1;
            buildMinHeap(arr, min);
        }
        index--;
        if(index>=0)
         buildMinHeap(arr,index);
        return arr;
    }

}
