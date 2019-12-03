package GeeksForGeeksPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStock {
    public static void main(String[] args) {
// stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;
        stockAndBuy(price,n);
    }

    public static void stockAndBuy(int[]arr, int n) {
        if(n==1)
            return;

        int count=0;

        List<Interval> list=new ArrayList<>();

        int i=0;
        while(i<n-1) {
            while(i<n-1 && arr[i]>=arr[i+1])
                i++;

            if(i==n-1)
                break;
            Interval interval=new Interval();
            interval.buy=i;
            i++;

            while(i<n && arr[i]>=arr[i-1])
                i++;

            interval.sell=i;
            i--;
            list.add(interval);
            count++;
        }
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + list.get(j).buy
                        + "        "
                        + "Sell on day : " + list.get(j).sell);

        return;
    }
}
class Interval{
    int buy,sell;
}
