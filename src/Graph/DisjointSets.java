package Graph;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<T> {
    private Map<T,Node> map = new HashMap<>();
    class Node {
        T data;
        Node parent;
        int rank;
    }

    public void makeSet(T data) {
        Node node = new Node();
        node.data=data;
        node.parent=node;
        node.rank=0;

        map.put(data,node);
    }

    public Node findSet(Node node) {
        if(node.parent==node)
            return node;

        node.parent=findSet(node.parent);
        return node.parent;

    }

    public boolean union(T data1, T data2) {
        Node node1=map.get(data1);
        Node node2 = map.get(data2);

        Node parent1=findSet(node1);
        Node parent2=findSet(node2);

        if(parent1.data==parent2.data)
            return false;

        if(parent1.rank>=parent2.rank) {
            parent1.rank=(parent1.rank==parent2.rank) ? parent1.rank+1 : parent1.rank;
            parent2.parent=parent1;
        }else {
            parent1.parent=parent2;
        }

        return true;
    }
    public T findSet(T data) {
        return findSet(map.get(data)).data;
    }

    public static void main(String[] args) {
        DisjointSets<Integer> ds = new DisjointSets();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
