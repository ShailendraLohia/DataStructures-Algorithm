package BinaryTree;
//import BinaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shailendra on 12/26/2016.
 */
public class BinaryTreeNodeImpl {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode= new BinaryTreeNode(20);
        node.rightNode=new BinaryTreeNode(30);
        node.leftNode.leftNode=new BinaryTreeNode(40);
        node.rightNode.leftNode=new BinaryTreeNode(50);
        node.rightNode.rightNode=new BinaryTreeNode(60);

        //boolean result = findData(node,50);
        //.out.println("Result: " + result);
        System.out.println("-----InOrder");
        inOrder(node);
        System.out.println();
        System.out.println("-----PostOrder");
        postOrder(node);
    }

    public static boolean findData(BinaryTreeNode node, int searchData) {
        list.clear();
        List<Integer> listData = preOrder(node);
        if(listData.contains(searchData))
            return true;

        return false;
    }
    public static List<Integer> preOrder(BinaryTreeNode node) { // Pre-Order: V,L,R

        if(node != null) {
            System.out.print(node.data + ",");
            list.add(node.data);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
        return list;
    }

    public static void inOrder(BinaryTreeNode node) { // Pre-Order: L,V,R

        if(node != null) {
            inOrder(node.leftNode);
            System.out.print(node.data + ",");
            inOrder(node.rightNode);
        }
        //System.out.println();
    }

    public static void postOrder(BinaryTreeNode node) { // Pre-Order: L,R,V

        if(node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.data + ",");
        }
        //System.out.println();
    }




}
