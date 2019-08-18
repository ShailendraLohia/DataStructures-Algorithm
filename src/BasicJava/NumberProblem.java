package BasicJava;

/**
 * Created by Shailendra on 5/25/2017.
 */
public class NumberProblem {
    public static void main(String[] args) {
        //int n=returnGivenNumber(1000);
        System.out.println(reverseGivenNumber(1234));
    }

    public static int returnGivenNumber(int n) {
        int sum=0;
        int num=1;
        while(n!=0) {
            System.out.println("value of n is" + n%10);
            int i=n%10;
            sum=(i*num) + sum;
            num=num*10;
            n=n/10;
        }
        return sum;
    }

    public static int reverseGivenNumber(int n) {

        int sum=0;
        while(n!=0) {
            int digit=n%10;
            sum=sum*10 + digit;
            n=n/10;
        }

        return sum;


    }
}
