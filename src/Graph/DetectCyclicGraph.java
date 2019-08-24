package Graph;

import java.util.*;

/**
 * Created by shailendralohia on 2/11/18.
 */
public class DetectCyclicGraph {
    private static int vertex;
    private static LinkedList<Integer> adj[]; // adjency List

    public DetectCyclicGraph(int v) {
        vertex = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public static void main(String[] args) {
        DetectCyclicGraph dfs=new DetectCyclicGraph(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        boolean result= dfs.isCyclic();
        System.out.println("Given Graph is cyclic: " + result);
    }

    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[vertex];
        boolean[] recStack = new boolean[vertex];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < vertex; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
    {
        if (recStack[i])
            return true;

//        if (visited[i])
//            return false;
//
//        visited[i] = true;

        recStack[i] = true;

        List<Integer> children = adj[i];

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

//    public static boolean isCyclic() {
//        Stack stack=new Stack();
//        boolean visited[]=new boolean[vertex];
//        for(int i=0;i<vertex;i++) {
//            visited[i]=false;
//        }
//        for(int j=0;j<vertex;j++) {
//            if(visited[j]==false) {
//                cyclicUtils(visited,stack,j);
//            }
//        }
//        return false;
//    }

//    public  static boolean cyclicUtils(boolean[] visited, Stack stack,int vertexData) {
//        visited[vertexData]=true;
//        if(!stack.contains(vertexData)) {
//            stack.push(vertexData);
//        }else {
//            return true;
//        }
//        adj[vertexData].size();
//
//        Iterator<Integer> iterator=adj[vertexData].listIterator();
//        while(iterator.hasNext()) {
//            int nextData=iterator.next();
//
//            if(!visited[nextData]) {
//                cyclicUtils(visited,stack,nextData);
//            }
//            /*if(stack.contains(nextData)) {
//                return true;
//            }*/
//        }
//
//        while(!stack.isEmpty()) {
//
//        }
//        return false;
//
//    }
}
