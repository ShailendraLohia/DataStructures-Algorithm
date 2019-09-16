package GeeksForGeeksPractice.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MajorityElement {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int totalTestCases = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i=0;i<totalTestCases;i++) {
            int sizeOfArray= Integer.parseInt(bufferedReader.readLine().trim());
            int[] arr= new int[sizeOfArray];
            String[] str= bufferedReader.readLine().split(" ");

            Map<Integer,Integer> map = new HashMap<>();

            int maxCountOfElement=1;
            int element=arr[0];

            for(int j=0;j<sizeOfArray;j++) {
                arr[j]= Integer.parseInt(str[j]);

                if(map.containsKey(arr[j])) {
                    int value= map.get(arr[j]);
                    map.put(arr[j],value+1);

                    if(value+1>maxCountOfElement) {
                        maxCountOfElement=value+1;
                        element=arr[j];
                    }
                }
                else
                    map.put(arr[j],1);
            }

            if(maxCountOfElement>maxCountOfElement/2) {
                System.out.println(element);
            }
            else
                System.out.println(-1);

        }














    }



}










//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter number of test cases");
//
//        int totalTestCase=scanner.nextInt();
//
//        while(totalTestCase>0){
//            totalTestCase--;
//            int n = scanner.nextInt();
//            int[] arr=new int[n];
//            for(int i=0;i<n-1;i++)
//                arr[i]=scanner.nextInt();
//
//            System.out.println(arr.length);
//        }

