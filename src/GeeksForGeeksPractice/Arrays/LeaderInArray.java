package GeeksForGeeksPractice.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeaderInArray {
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{

        int totalTestCases = Integer.parseInt(bf.readLine().trim());
        while (totalTestCases>0) {
            totalTestCases--;
            int sizeOfArray = Integer.parseInt(bf.readLine().trim());
            String[] str = bf.readLine().split(" ");

            int element = Integer.parseInt(str[sizeOfArray - 1]);
            System.out.println(element); // Last Element is always leader

            for (int i = sizeOfArray - 2; i >= 0; i--) {

                int previousLastElement = Integer.parseInt(str[i]);

                if (previousLastElement > element) {
                    element = previousLastElement;
                    System.out.println(element);
                }

            }
        }

    }
}
