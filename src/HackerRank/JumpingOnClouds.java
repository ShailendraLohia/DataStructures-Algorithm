package HackerRank;

public class JumpingOnClouds {
    public static void main(String[] args) {
        //int[] arr= new int[] {0,0,1,0,0,1,0};
        int[] arr= new int[] {0,0,0,0,1,0};
        System.out.println(countJumps(arr));
    }

    public static int countJumps(int[] c) {
        if(c.length==0) {
            return 0;
        }

        int count=-1;
        for(int i=0;i<c.length;i++, count++) {
            if(c[i]==1) {
                i=i+1;
                //count++;
            }
            if(i+2 < c.length) {
                if(c[i+1]==0 && c[i+2]==0) {
                    i=i+1;
                    //count++;
                }
                //else count++;
            }
           //count++;
        }
        return count;
    }
}
