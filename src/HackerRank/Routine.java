package HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Routine {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{

        String[] str= bufferedReader.readLine().split(" ");

//        for(int i:str) {
//
//        }

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hat");
        map.put(2,"pants");
        map.put(3,"shirt");
        map.put(4,"shoes");
        map.put(5,"socks");

        List<Integer> shoes=new ArrayList<>(2);
        List<Integer> hat=new ArrayList<>(1);

        if(str[0].equals(4) || str[0].equals(1)) { //
            System.out.println(map.get(Integer.parseInt(str[0]))+ "," + "fail");
            return;
        }


        for(int i=0;i<str.length;i++) {
            if(str[i].equals(5) || str[i].equals(2)){
                shoes.add(Integer.parseInt(str[i]));
                System.out.print(map.get(Integer.parseInt(str[i]))+ ",");
            }
            if(str[i].equals(4) && shoes.size()!=2) {
                System.out.print(map.get(Integer.parseInt(str[i]))+ "," + "fail");
                return;
            }
            else {
                System.out.print(map.get(Integer.parseInt(str[i]))+ ",");
            }
            if(str[i].equals(1) && hat.size()!=1) {
                System.out.print(map.get(Integer.parseInt(str[i]))+ "," + "fail");
                return;
            }
            else {
                System.out.print(map.get(Integer.parseInt(str[i]))+ ",");
            }
            if(str[i].equals(3)) {
                hat.add(Integer.parseInt(str[i]));
                System.out.print(map.get(Integer.parseInt(str[i]))+ ",");
            }

        }

        System.out.println(str.length);
    }
}
