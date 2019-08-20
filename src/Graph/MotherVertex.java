package Graph;

//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MotherVertex {
    private int V;
    private List<Integer> adj[];

    public MotherVertex(int vertex) {
        V=vertex;
        adj=new ArrayList[V];

        for(int i=0;i<V;i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void DFSUtil(int v,boolean visited[]) {
        visited[v]=true;
        //System.out.println(v+ " ");
        Iterator<Integer> iterator=adj[v].listIterator();

        while(iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public int findMotherVertex() {
        boolean visited[] = new boolean[V];
        int v=0;

        for (int i = 0; i < V; i++)
        {
            if (visited[i] == false)
            {
                DFSUtil(i, visited);
                v = i;
            }
        }

        for(int i=0;i<V;i++) {
            visited[i]=false;
        }
        DFSUtil(v, visited);

        for (int i=0; i<V; i++) {
            if (visited[i] == false)
                return -1;
        }
        return v;
    }

    public static void main(String[] args) {
        MotherVertex g = new MotherVertex(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println(g.findMotherVertex());
    }
}
