package GeeksForGeeksPractice.Arrays;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
//        int[] arr= {1,2,3,5};
//
//        int result = findMissingNumber(arr,5);
//        System.out.println(result);

        Scanner in = new Scanner(System.in);
        int totalTestCases= in.nextInt();
        for(int i=0;i<totalTestCases;i++) {
            int size=in.nextInt();
            int[] arr=new int[size];

            for (int z = 0; z < size-1; z++) {
                int data = Integer.parseInt(in.next());
                arr[i] = data;
            }
            int result = findMissingNumber(arr,5);
            System.out.println(result);

        }

    }

    public static int findMissingNumber(int[] arr,int size) {
        if (arr.length==0 || arr.length==1 || arr.length==2)
            return 0;


        for(int i=1;i<size;i++) {
            if(arr[i]-arr[i-1]!=1){
                int missingNumber=(arr[i]+arr[i-1])/2;
                return missingNumber;
            }
        }

        return Integer.MIN_VALUE;
    }
}
