package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SpecificLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode=new BinaryTreeNode(4);
        node.leftNode.rightNode= new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(7);

        specificLevelOrderTraversal(node);

    }

    public static void specificLevelOrderTraversal(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Queue<BinaryTreeNode> queue=new LinkedList<>();

        queue.add(rootNode);
        System.out.print(rootNode.data + " ");
        rootNode=queue.poll();

        if(rootNode.leftNode!=null && rootNode.rightNode!=null) {
            System.out.print(rootNode.leftNode.data + " " + rootNode.rightNode.data + " ");
            queue.add(rootNode.leftNode);
            queue.add(rootNode.rightNode);

        }

        BinaryTreeNode firstNode;
        BinaryTreeNode secondNode;

        while(!queue.isEmpty()) {

            firstNode=queue.poll();
            secondNode=queue.poll();

            if(firstNode.leftNode!=null && secondNode.rightNode!=null) {

                System.out.print(firstNode.leftNode.data + " " + secondNode.rightNode.data + " ");

                queue.add(firstNode.leftNode);
                queue.add(secondNode.rightNode);
            }
            if(firstNode.rightNode!=null && secondNode.leftNode!=null) {

                System.out.print(firstNode.rightNode.data + " " + secondNode.leftNode.data + " ");

                queue.add(firstNode.rightNode);
                queue.add(secondNode.leftNode);
            }


        }
    }
}
