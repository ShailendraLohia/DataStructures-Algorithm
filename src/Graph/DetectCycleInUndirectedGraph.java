package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DetectCycleInUndirectedGraph {
    private int vertex;
    private List<Integer>[] adj;

    public DetectCycleInUndirectedGraph(int v) {
        vertex=v;
        adj=new ArrayList[vertex];

        for(int i=0;i<adj.length;i++) {
            adj[i]= new ArrayList<>();
        }
    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph dfg = new DetectCycleInUndirectedGraph(5);
        dfg.addEdge(1, 0);
        dfg.addEdge(0, 2);
        dfg.addEdge(2, 0);
        dfg.addEdge(0, 3);
        dfg.addEdge(3, 4);

        System.out.println(dfg.isCyclic());

    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[vertex];

        Arrays.fill(visited,false);

        for (int u = 0; u < vertex; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;

    }

    public boolean isCyclicUtil(int u, boolean[] visited, int parent) {
        visited[u]=true;
        int i;

        Iterator<Integer> iterator= adj[u].listIterator();
        while(iterator.hasNext()) {
            i=iterator.next();

            if(!visited[i]) {
                isCyclicUtil(i,visited,u);
                return true;
            }
            else if(i!=parent) {
                return true;
            }
        }
        return false;
    }
}
