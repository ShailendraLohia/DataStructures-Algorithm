package Miscellaneous.BinaryTree;

import BinaryTree.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalUsingDirectionChange {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode= new BinaryTreeNode(7);
        node.leftNode.rightNode=new BinaryTreeNode(6);
        node.rightNode.leftNode=new BinaryTreeNode(5);
        node.rightNode.rightNode=new BinaryTreeNode(4);

        levelOrderTraversalTwoLevelDirectionChange(node);
    }

    public static void levelOrderTraversalTwoLevelDirectionChange(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Queue<BinaryTreeNode> queue=new LinkedList<>();
        Stack<BinaryTreeNode> stack= new Stack<>();

        queue.add(rootNode);
        int count=0; // count to change direction
        boolean changeDirection=false;
        int size=0;

        while(!queue.isEmpty()) {
            count++;
            size=queue.size();

            for(int i=0;i<size;i++) {
                rootNode = queue.poll();

                if(changeDirection==false) {
                    System.out.print(rootNode.data + " ");
                } else {
                    stack.push(rootNode);
                }

                if (rootNode.leftNode != null) {
                    queue.add(rootNode.leftNode);
                }
                if (rootNode.rightNode != null) {
                    queue.add(rootNode.rightNode);
                }
            }
            if(changeDirection==true) {
                while(!stack.isEmpty()) {
                    rootNode=stack.pop();
                    System.out.print(rootNode.data + " ");
                }
            }
            if(count==2) {
                changeDirection=!changeDirection;
                count=0;
            }

        }

    }
}
