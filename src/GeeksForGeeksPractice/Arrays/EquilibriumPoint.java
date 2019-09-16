package GeeksForGeeksPractice.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class EquilibriumPoint {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int totalTestCases= Integer.parseInt(bf.readLine().trim());
        while (totalTestCases>0) {
            totalTestCases--;

            int sizeOfArray= Integer.parseInt(bf.readLine().trim());
            int[] arr = new int[sizeOfArray];
            String[] str = bf.readLine().split(" ");

            if(str.length==1) // If Size of array is one
                System.out.println(Integer.parseInt(str[0]));

            int sum=0;
            int leftSum=0;

            // Sum of all array elements
            for(int i=0;i<sizeOfArray;i++) {
                sum=sum+Integer.parseInt(str[i]);
            }

            for(int i=0;i<sizeOfArray;i++) {
                sum=sum-Integer.parseInt(str[i]);

                if(sum==leftSum)
                    System.out.println(i);

                leftSum+=Integer.parseInt(str[i]);
            }




        }



    }


}
