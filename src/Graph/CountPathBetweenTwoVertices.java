package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CountPathBetweenTwoVertices {
    private int vertex;
    private List<Integer>[] adj;

    public CountPathBetweenTwoVertices(int v) {
        vertex=v;
        adj=new ArrayList[vertex];
        for(int i=0;i<vertex;i++) {
            adj[i]=new ArrayList<>();
        }
    }

    public void addEdge(int v, int e) { // v is vertex and each vertex is list
        adj[v].add(e);
    }

    public static void main(String[] args) {
        CountPathBetweenTwoVertices nodes = new CountPathBetweenTwoVertices(5);

        nodes.addEdge(0,1);
        nodes.addEdge(0,2);
        nodes.addEdge(0,4);
        nodes.addEdge(1,3);
        nodes.addEdge(1,4);
        nodes.addEdge(2,4);
        nodes.addEdge(3,2);

        int result= nodes.countPaths(0,4);
        System.out.println("Total count: " + result);
    }
    public int countPaths(int src, int dest) {
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited,false);

        int pathCount=0;
        pathCount = countPathsUtil(src, dest,
                visited,
                pathCount);
        return pathCount;
    }

    public int countPathsUtil(int src, int dest, boolean[] visited, int pathCount) {
        visited[src]=true;

        if(src==dest)
            pathCount++;
        else {
            Iterator<Integer> i = adj[src].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    pathCount = countPathsUtil(n, dest, visited, pathCount);
                }
            }
        }

        visited[src]=false;
        return pathCount;
    }
}
