package Miscellaneous.BinaryTree;

import BinaryTree.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by shailendralohia on 10/28/18.
 */
public class LevelOrderTraversalUsingDeque {
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
        if(rootNode==null)
            return;

        Deque<BinaryTreeNode> deque=new LinkedList<>();
        deque.offerFirst(rootNode);

        while(!deque.isEmpty()) {

            //rootNode=deque.pollLast();
            while(deque.peekFirst()!=null) {
                rootNode=deque.pollFirst();
                System.out.print(rootNode.data+ ",");

                if(rootNode.leftNode!=null) {
                    deque.offerLast(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    deque.offerLast(rootNode.rightNode);
                }

            }

            System.out.println(); // go to next line


            while(deque.peekLast()!=null) {
                rootNode=deque.pollLast();
                System.out.print(rootNode.data+ ",");

                if(rootNode.leftNode!=null) {
                    deque.offerFirst(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    deque.offerFirst(rootNode.rightNode);
                }
                rootNode=deque.pollLast();
            }
        }
    }
}
