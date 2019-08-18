package HackerRank;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countValley("UDDDUDUU"));

    }

    public static int countValley(String str) {
        if(str.length()==0)
            return 0;

        int ilevel=0;
        int iValley=0;

        for(char c: str.toCharArray()) {
            if(c=='U') {
                iValley++;
            }
            if(c=='D') {
                iValley--;
            }

            if(iValley==0 && c=='U') {
                 ilevel++;
            }
        }
        return ilevel;
    }
}
