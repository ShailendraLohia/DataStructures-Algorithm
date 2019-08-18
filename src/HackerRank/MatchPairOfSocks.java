package HackerRank;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MatchPairOfSocks {
    public static void main(String[] args) {
        int[] ar = new int[]{10,20,20,10,10,30,50,10,20};
        System.out.println(socksMerchant(9,ar));

    }

    public static int socksMerchant(int n, int[] ar) {
        if(ar.length!=n)
            return 0;

        Map<Integer,Integer> map = new HashMap<>();


        for(int i=0;i< ar.length;i++) {
            if(map.containsKey(ar[i])) {
                map.put(ar[i],map.get(ar[i])+1);
            }
            else map.put(ar[i], 1);
        }
      return map.entrySet().
               stream().
               mapToInt(i-> Math.abs(i.getValue()/2)).sum();



        /*for(int i:map.values()) {
            list.add(Math.abs((i/2)));
        }

        return list.stream().mapToInt(i->i).sum();

        for(int i:list) {
            pairOfSocks=pairOfSocks+i;
        }

        return pairOfSocks;*/
    }



}
