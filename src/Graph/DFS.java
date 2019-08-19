package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shailendralohia on 1/21/18.
 */
public class DFS { // Pre-order in Binary tree
    private int vertex;
    //private LinkedList<Integer> adj[]; // adjency List
    private List<Integer> adj[];

    public DFS(int v) {
        vertex = v;
        //adj = new LinkedList[v];
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            //adj[i] = new LinkedList<>();
            adj[i] = new ArrayList<>();
        }
    }
        void addEdge(int v, int e) {
            adj[v].add(e);
    }

    public static void main(String[] args) {
        DFS dfs=new DFS(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        dfs.makeDFS(2);
    }

    public void makeDFS(int v) {
        boolean visited[] = new boolean[vertex];
        DFSUtil(v,visited);
    }

    public void DFSUtil(int v,boolean visited[]) {
        visited[v]=true;
        System.out.println(v+ " ");
        Iterator<Integer> iterator=adj[v].listIterator();

        while(iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

}
