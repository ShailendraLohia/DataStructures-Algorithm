package Graph;

import java.util.*;

/**
 * Created by shailendralohia on 1/21/18.
 */
public class BFS {
    private int vertex;
    //private LinkedList<Integer> adj[];
    private List<Integer> adj[];    // adjency List
    //private static Map<Integer,List<Integer>> map;

    public BFS(int v) {
        vertex = v;
        //adj = new LinkedList[v];
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            //adj[i] = new LinkedList<>();
            adj[i] = new ArrayList<>();
        }
       // map=new HashMap<>(v);
    }
    void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public static void main(String[] args) {
        BFS bfs=new BFS(4);

        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(3,3);

        //map.put(0,);
        bfs.makeBFS(2);
    }

    public void makeBFS(int v) {
        boolean visited[] = new boolean[vertex];
        BFSUtil(v,visited);
    }

    public void BFSUtil(int v, boolean visited[]) {
        visited[v]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()) {
            int data =queue.poll();
            System.out.println(data+ " ");
            Iterator<Integer> iterator=adj[data].listIterator();

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
