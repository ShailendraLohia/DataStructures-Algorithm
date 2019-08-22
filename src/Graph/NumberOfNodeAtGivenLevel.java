package Graph;

import java.util.*;

//https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/

public class NumberOfNodeAtGivenLevel {
    private int vertex;
    private List<Integer>[] adj;

    public NumberOfNodeAtGivenLevel(int v) {
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
        NumberOfNodeAtGivenLevel nodes = new NumberOfNodeAtGivenLevel(8);

        nodes.addEdge(0, 1);
        nodes.addEdge(0, 2);
        nodes.addEdge(1, 3);
        nodes.addEdge(2, 4);
        nodes.addEdge(2, 5);
        nodes.addEdge(5,6);
        nodes.addEdge(6,7);

        nodes.findTotalNodesAtGivenLevel(0,3);
    }


    public void findTotalNodesAtGivenLevel(int rootData, int level) {
        boolean[] visited=new boolean[vertex];
        //List<Integer> list=new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootData);
        visited[rootData]= true;
        int level_;
        int count=0;

        if(level-2==rootData)
            level_=0;
        else
            level_=1;

        while(!queue.isEmpty()) {
            int size=queue.size(); // queue size
            while(size>0) {
                int data = queue.poll();
                size--;
                if (level - 2 == level_) {

                    int listSize=adj[data].size();
                    for(int i=0;i<listSize;i++)
                        count=count + adj[adj[data].get(i)].size();
                }else {

                    Iterator<Integer> iterator = adj[data].listIterator();
                    while (iterator.hasNext()) {
                        int element = iterator.next();
                        if (!visited[element]) {
                            queue.add(element);
                            visited[element] = true;
                        }
                    }
                }
            }
            level_++;
        }
        System.out.println("total nodes at given level: " + count);

    }
}
