package Graph;
// https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/PrimMST.java
import java.util.*;


public class PrimsAlgo {

    public List<Edge<Integer>> primMST(GraphImpl<Integer> graph){

        //binary heap + map data structure
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();

        //map of vertex to edge which gave minimum weight to this vertex.
        Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();

        //stores final result
        List<Edge<Integer>> result = new ArrayList<>();

        for(Vertex<Integer> v:graph.getAllVertices()) {
            minHeap.add(Integer.MAX_VALUE,v);
        }

        //start from any random vertex
        Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();

        //for the start vertex decrease the value in heap + map to 0
        minHeap.decrease(startVertex,0);


        while(!minHeap.empty()) {
            Vertex<Integer> currentVertex = minHeap.extractMin();

            Edge<Integer> spanningTreeEdge = vertexToEdge.get(currentVertex);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }

            //iterate through all the adjacent vertices
            for(Edge<Integer> edge: currentVertex.getEdges()) {
                Vertex<Integer> adjacentVertex= getVertexForEdge(currentVertex,edge);
                //check if adjacent vertex exist in heap + map and weight attached
                // with this vertex is greater than this edge weight
                if(minHeap.containsData(adjacentVertex) && minHeap.getWeight(adjacentVertex) > edge.getWeight()) {
                    //decrease the value of adjacent vertex to this edge weight.
                    minHeap.decrease(adjacentVertex,edge.getWeight());
                    //add vertex->edge mapping in the graph.
                    vertexToEdge.put(adjacentVertex,edge);
                }
            }
        }

        return result;

    }
    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }

    public static void main(String[] args) {
        GraphImpl<Integer> graph = new GraphImpl<>(false);

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimsAlgo primsAlgo = new PrimsAlgo();
        Collection<Edge<Integer>> edges = primsAlgo.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge.source.data + " " + edge.destination.data + " " + edge.weight);
        }
    }
}
