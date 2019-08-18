package HackerRank;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(countRepeatedChar(10,"b"));

    }

    public static long countRepeatedChar(int n,String str) {
        if(n==0 && str.length()==0) {
            return 0L;
        }
        if(n == 1 && str.toCharArray()[0]=='a') {
            return 1L;
        }
        if(str.length()==1 && str.toCharArray()[0]=='a') {
            return n;
        }
        if(str.length()==1 && str.toCharArray()[0]!='a') {
            return 0L;
        }
        long count_=0;
        for(char k:str.toCharArray()) {
            if(k=='a') {
                count_++;
            }
        }
        if(count_==0) {
            return 0L;
        }

        long div_= n/str.length();
        long modulus_ = n%str.length();

        count_= count_*div_;

        for(int i=0;i<modulus_;i++) {
            if(str.toCharArray()[i] == 'a') {
                count_++;
            }
        }
        return count_;
    }
}
