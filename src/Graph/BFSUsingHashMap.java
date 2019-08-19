package Graph;

import java.util.*;

public class BFSUsingHashMap {
    private static int vertex;
    private static Map<Integer, List<Integer>> map;
    private static List<Integer> list;

    public BFSUsingHashMap(int v) {
        vertex = v;
        map = new HashMap<>(v);

        for (int i = 0; i < vertex; i++) {
            map.put(i, new ArrayList<>());
        }
    }


    public static void main(String[] args) {

        BFSUsingHashMap bfs = new BFSUsingHashMap(5);


        
        if(map.get(0).size()==0) {
            list = new ArrayList<>();
            list.add(1);
            list.add(4);
            map.put(0,list);
        }
        if(map.get(1).size()==0) {
            list = new ArrayList<>();
            list.add(2);
            list.add(4);
            list.add(0);
            map.put(1,list);
        }
        if(map.get(2).size()==0) {
            list = new ArrayList<>();
            list.add(1);
            list.add(3);
            map.put(2,list);
        }

        if(map.get(3).size()==0) {
            list = new ArrayList<>();
            list.add(2);
            list.add(4);
            map.put(3,list);
        }

        if(map.get(4).size()==0) {
            list = new ArrayList<>();
            list.add(3);
            list.add(1);
            list.add(0);
            map.put(4,list);
        }
        

        makeBFS(0);

    }

    public static void makeBFS(int v) {
        boolean visited[] = new boolean[vertex];
        BFSUtil(v, visited);
    }

    public static void BFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int data = queue.poll();
            System.out.println(data + " ");
            list=map.get(data);
            Iterator<Integer> iterator=list.listIterator();

            while(iterator.hasNext()) {
                int element=iterator.next();
                if(!visited[element]) {
                    queue.add(element);
                    visited[element] = true;
                }
            }
        }
    }
}
