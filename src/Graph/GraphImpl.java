package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphImpl<T> {
    public static void main(String[] args) {
        GraphImpl<Integer> graph = new GraphImpl<Integer>(false);

        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(4, 2, 0);


        Vertex<Integer> v = graph.getAllVertices().get(0);

        System.out.println(v.data);

        for(Edge<Integer> edge: v.getEdges()) {
            System.out.println(edge.source.data + " " + edge.destination.data);
        }
    }

    HashMap<T, Vertex> hm = new HashMap<T, Vertex>();
    ArrayList<Edge> EdgesList = new ArrayList<Edge>();
    boolean directed;

    GraphImpl(boolean dir) {
        directed = dir;
    }

    void addEdge(T i, T j, int wt) {
        Vertex v1;//
        Vertex v2;//=new Vertex(j);
        if (hm.containsKey(i))
            v1 = hm.get(i);
        else {
            v1 = new Vertex(i);
            hm.put(i, v1);
        }
        if (hm.containsKey(j))
            v2 = hm.get(j);
        else {
            v2 = new Vertex(j);
            hm.put(j, v2);
        }
        Edge e = new Edge(v1, v2, directed, wt);
        EdgesList.add(e);
        v1.addVertex(v2);
        v1.addEdge(e);
        if (!directed) {
            v2.addVertex(v1);
            v2.addEdge(e);
        }
    }

    ArrayList<Vertex<T>> getconnected_Vertices(T x) {
        Vertex v = hm.get(x);
        return v.getConnected_Vertices();
    }

    ArrayList<Vertex> getAllVertices() {
        ArrayList<Vertex> res = new ArrayList<Vertex>();// hm.values();
        for (Vertex v : hm.values())
            res.add(v);
        return res;
    }

    public List<Edge> getAllEdges() {
        return EdgesList;
    }


}

class Vertex<T> {
    T data;
    ArrayList<Edge<T>> adjacent_Edges = new ArrayList<Edge<T>>();
    ArrayList<Vertex<T>> connected_Vertices = new ArrayList<Vertex<T>>();

    Vertex(T data) {
        this.data = data;
    }

    void addEdge(Edge<T> e) {
        adjacent_Edges.add(e);
    }

    ArrayList<Edge<T>> getEdges() {
        return adjacent_Edges;
    }

    void addVertex(Vertex<T> v) {
        //adjacent_Edges.add(e);
        connected_Vertices.add(v);
    }

    ArrayList<Vertex<T>> getConnected_Vertices() {
        return connected_Vertices;
    }

    public int getDegree() {
        return adjacent_Edges.size();
    }



    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        Vertex<T> other = (Vertex) o;
        if (this != other)
            return false;
        return true;
    }

}
class Edge<T> {
    Vertex<T> source;
    Vertex<T> destination;
    boolean isDirected;
    int weight;

    Edge(Vertex<T> source, Vertex<T> destination) {
        this.source = source;
        this.destination = destination;
    }

    Edge(Vertex<T> source, Vertex<T> destination, boolean isDirected, int weight) {
        this.source = source;
        this.destination = destination;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    Edge(Vertex<T> source, Vertex<T> destination, boolean isDirected) {
        this.source = source;
        this.destination = destination;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1(){
        return source;
    }

    Vertex<T> getVertex2(){
        return destination;
    }

    int getWeight(){
        return weight;
    }

    public boolean isDirected(){
        return isDirected;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        Edge other = (Edge) o;
        if (!source.equals(other) || !destination.equals(other.destination))
            return false;
        return true;
    }

}






