package Graph;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/KruskalMST.java

//import PluralSightLambda.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMSTAlgo {
    public class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() == edge2.getWeight())
                return -1;
            return edge2.getWeight() - edge1.getWeight();
        }
    }
    public List<Edge<Integer>> getMST(GraphImpl<Integer> graph) {

        List<Edge<Integer>> allEdges = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();

        //sort all edges in non decreasing order
        Collections.sort(allEdges, edgeComparator);
        DisjointSets<Integer> disjointSet = new DisjointSets<>();

        //create as many disjoint sets as the total vertices
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            disjointSet.makeSet(vertex.data);
        }

        List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

        for (Edge<Integer> edge : allEdges) {
            //get the sets of two vertices of the edge
            long root1 = disjointSet.findSet(edge.getVertex1().data);
            long root2 = disjointSet.findSet(edge.getVertex2().data);

            //check if the vertices are in same set or different set
            //if verties are in same set then ignore the edge
            if (root1 == root2) {
                continue;
            } else {
                //if vertices are in different set then add the edge to result and union these two sets into one
                resultEdge.add(edge);
                disjointSet.union(edge.getVertex1().data, edge.getVertex2().data);
            }

        }
        return resultEdge;
    }

    public static void main(String[] args) {
        GraphImpl<Integer> graph = new GraphImpl<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
        KruskalMSTAlgo mst = new KruskalMSTAlgo();
        List<Edge<Integer>> result = mst.getMST(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1().data + " " + edge.getVertex2().data);
        }

    }

}
