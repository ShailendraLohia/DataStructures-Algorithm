package BinaryTree;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shailendra on 1/15/2017.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(-1);
        node.rightNode=new BinaryTreeNode(11);
        node.leftNode.leftNode=new BinaryTreeNode(-2);
        node.leftNode.rightNode= new BinaryTreeNode(-3);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(21);
        node.rightNode.rightNode=new BinaryTreeNode(6);

       leverOrderTraversal(node);
       System.out.println("Each level will be printed in each line");
       System.out.println();
        printLevelOnEachLine(node);
    }

    public static void leverOrderTraversal(BinaryTreeNode rootNode) {
        if (rootNode == null)
            return;

        Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
        q1.add(rootNode);

        while(!q1.isEmpty()) {
            rootNode= q1.poll();
            System.out.print(rootNode.data+ ",");

            if(rootNode.leftNode!=null) {
                q1.add(rootNode.leftNode);
            }
            if(rootNode.rightNode!=null) {
                q1.add(rootNode.rightNode);
            }

        }
        System.out.println();
    }

    public static void printLevelOnEachLine(BinaryTreeNode rootNode) {

        if (rootNode == null)
            return;

        Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
        Queue<BinaryTreeNode> q2 = new LinkedList<BinaryTreeNode>();
        q1.add(rootNode);

        while(!q1.isEmpty() || !q2.isEmpty()) {
            while(!q1.isEmpty()) {
                rootNode=q1.poll();
                System.out.print(rootNode.data + ",");
                if(rootNode.leftNode!=null) {
                    q2.add(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    q2.add(rootNode.rightNode);
                }
            }
            System.out.println();

            while(!q2.isEmpty()) {
                rootNode=q2.poll();
                System.out.print(rootNode.data+ ",");
                if(rootNode.leftNode!=null) {
                    q1.add(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    q1.add(rootNode.rightNode);
                }
            }
            System.out.println();
        }

    }


}
