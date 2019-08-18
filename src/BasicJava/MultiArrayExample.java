package BasicJava;

/**
 * Created by Shailendra on 12/30/2016.
 */
public class MultiArrayExample {
    public static void main(String[] args) {
        int firstArray[][] = {{1,2,3,4},{5,6,7,8}, {9,10,11,12}};

        display(firstArray);
    }

    public static void display(int x[][]) {
        for(int row=0;row<x.length;row++) {
            for(int column=0;column<x[row].length;column++) {
                System.out.print(x[row][column] + " ");
            }
            System.out.println();
        }
    }
}
