package Graph;

import java.util.*;

public class IterativeDFS {
    private int vertex;
    private List<Integer>[] adj;

    public IterativeDFS(int v) {
        vertex=v;
        adj=new ArrayList[vertex];

        for(int i=0;i<vertex;i++) {
            adj[i]= new ArrayList<>();
        }
    }

    void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public static void main(String[] args) {
        IterativeDFS dfs = new IterativeDFS(5);

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
        //Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        //queue.add(v);

        while(!stack.isEmpty()) {
            int data=stack.pop();
            System.out.println(data+ " ");

            Iterator<Integer> iterator=adj[data].listIterator();
            while(iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    stack.push(n);
                    visited[data]=true;
                    break;
                }
                    //DFSUtil(n, visited);
            }
        }


    }
}
