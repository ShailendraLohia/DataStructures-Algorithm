package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shailendra on 1/15/2017.
 */
public class LevelOrderTraversalUsingDelimiter {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(-1);
        node.rightNode=new BinaryTreeNode(11);
        node.leftNode.leftNode=new BinaryTreeNode(-2);
        node.leftNode.rightNode= new BinaryTreeNode(-3);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(21);
        node.rightNode.rightNode=new BinaryTreeNode(6);

        levelOrderTraversal(node);

    }

    public static void levelOrderTraversal(BinaryTreeNode rootNode) {

        if(rootNode==null) {
            return;
        }
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        q1.add(rootNode);
        q1.add(null);

        while(!q1.isEmpty()) {
            rootNode=q1.poll();
            if(rootNode!=null) {
                System.out.print(rootNode.data + " ");

                if(rootNode.leftNode!=null) {
                    q1.add(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    q1.add(rootNode.rightNode);
                }
            }
            else {
                if(!q1.isEmpty()) {
                    q1.add(null);
                    System.out.println();
                }
            }
        }
    }
}
