package BasicJava;

/**
 * Created by Shailendra on 12/30/2016.
 */
public class VarArgsExample {
    public static void main(String[] args) {
        System.out.println(average(12,12,12,12,30));

    }
    public static int average(int... numbers) {
        int total=0;
        for(int x:numbers) {
            if(x==12) {
                continue;
            }
            total +=x;
        }
        return total/numbers.length;
    }
}
