package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalLevelTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node= new BinaryTreeNode(8);
        node.leftNode=new BinaryTreeNode(3);
        node.rightNode=new BinaryTreeNode(10);
        node.leftNode.leftNode=new BinaryTreeNode(1);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(14);
        node.rightNode.leftNode.leftNode=new BinaryTreeNode(4);
        node.rightNode.leftNode.rightNode=new BinaryTreeNode(7);
        node.rightNode.rightNode.leftNode=new BinaryTreeNode(13);

        diagnoalPrint(node);

    }

    public static void diagonalPrintUtil(BinaryTreeNode rootNode, int d,
                                 HashMap<Integer, List<Integer>> map) {


        if(rootNode==null)
            return;

        List<Integer> data=map.get(d);

        if(data==null) {
            data=new ArrayList<>();
            data.add(rootNode.data);
        }else {
            data.add(rootNode.data);
        }

        map.put(d,data);

        diagonalPrintUtil(rootNode.leftNode,d+1,map);
        diagonalPrintUtil(rootNode.rightNode,d,map);


    }

    public static void diagnoalPrint(BinaryTreeNode rootNode) {

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        diagonalPrintUtil(rootNode,0,map);

        System.out.println("Diagonal Traversal");

       for( Map.Entry<Integer,List<Integer>> entry : map.entrySet() ) {
            System.out.println(entry.getValue());
        }
    }
}
