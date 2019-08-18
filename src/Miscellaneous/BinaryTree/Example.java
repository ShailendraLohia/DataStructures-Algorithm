package Miscellaneous.BinaryTree;

import BinaryTree.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Example {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode= new BinaryTreeNode(7);
        node.leftNode.rightNode=new BinaryTreeNode(6);
        node.rightNode.leftNode=new BinaryTreeNode(5);
        node.rightNode.rightNode=new BinaryTreeNode(4);

        spiralTraversal(node);
    }

    public static void spiralTraversal(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Deque<BinaryTreeNode> deque=new LinkedList<>();
        deque.addFirst(rootNode);
        int count=1;
        boolean flip=true;

        while(!deque.isEmpty()) {
            int currentCount=0;

            while (count>0) {

                if(flip) {

                    rootNode=deque.pollLast();
                    System.out.println(rootNode.data + ",");
                    if(rootNode.rightNode!=null) {
                        deque.addFirst(rootNode.rightNode);
                        currentCount++;
                    }

                    if(rootNode.leftNode!=null) {
                        deque.addFirst(rootNode.leftNode);
                        currentCount++;
                    }
                }
                else {
                    rootNode=deque.pollFirst();
                    System.out.println(rootNode.data + ",");

                    if(rootNode.leftNode!=null) {
                        deque.addLast(rootNode.leftNode);
                        currentCount++;
                    }
                    if(rootNode.rightNode!=null) {
                        deque.addLast(rootNode.rightNode);
                        currentCount++;
                    }
                }
                count--;
            }
            count=currentCount;
            flip=!flip;

        }
    }
}
