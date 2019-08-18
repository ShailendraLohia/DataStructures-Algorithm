package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNodeInLevelOrder {
    public static void main(String[] args) {
        BinaryTreeNode node=new BinaryTreeNode(10);
        node.leftNode=new BinaryTreeNode(11);
        node.rightNode=new BinaryTreeNode(9);
        node.leftNode.leftNode=new BinaryTreeNode(7);
        node.rightNode.leftNode=new BinaryTreeNode(15);
        node.rightNode.rightNode=new BinaryTreeNode(8);

        insertNodeAtLevelOrder(node,12);
        //Pro-Order traversal
        IterativePreOrder.iteratePreOrder(node);
    }

    public static void insertNodeAtLevelOrder(BinaryTreeNode rootNode, int data) {
        if(rootNode==null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);

        while(rootNode!=null) {
            rootNode=queue.poll();

            if(rootNode.leftNode==null) {
                rootNode.leftNode=new BinaryTreeNode(data);
                break;
            } else {
                queue.add(rootNode.leftNode);
            }

            if(rootNode.rightNode==null) {
                rootNode.rightNode=new BinaryTreeNode(12);
                break;
            } else {
                queue.add(rootNode.rightNode);
            }

        }

    }
}
