package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Shailendra on 1/22/2017.
 */
public class SpiralTraversalWithOneDeque {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode= new BinaryTreeNode(7);
        node.leftNode.rightNode=new BinaryTreeNode(6);
        node.rightNode.leftNode=new BinaryTreeNode(5);
        node.rightNode.rightNode=new BinaryTreeNode(4);

//        node.leftNode.leftNode= new BinaryTreeNode(4);
//        node.leftNode.rightNode=new BinaryTreeNode(5);
//        node.rightNode.leftNode=new BinaryTreeNode(6);
//        node.rightNode.rightNode=new BinaryTreeNode(7);
//        node.leftNode.leftNode.leftNode= new BinaryTreeNode(8);
//        node.leftNode.rightNode.leftNode = new BinaryTreeNode(9);
//        node.rightNode.rightNode.rightNode= new BinaryTreeNode(10);

        spiralTraversal(node);
        //System.out.print(result);
    }

    public static void spiralTraversal(BinaryTreeNode rootNode) {
        if(rootNode==null) {
            return;
        }

        Deque<BinaryTreeNode> dq = new LinkedList<>();
        dq.offerFirst(rootNode);
        int count=1;
        boolean flip = true;

        while(!dq.isEmpty()) {
            int currentCount=0;
            while(count>0) {
                if(flip) {
                    rootNode=dq.pollFirst();
                    System.out.print(rootNode.data +",");

                    if(rootNode.leftNode!=null) {
                        dq.offerLast(rootNode.leftNode);
                        currentCount++;
                    }
                    if(rootNode.rightNode!=null) {
                        dq.offerLast(rootNode.rightNode);
                        currentCount++;
                    }
                }
                else {
                    rootNode=dq.pollLast();
                    System.out.print(rootNode.data +",");

                    if(rootNode.rightNode!=null) {
                        dq.offerFirst(rootNode.rightNode);
                        currentCount++;
                    }
                    if(rootNode.leftNode!=null) {
                        dq.offerFirst(rootNode.leftNode);
                        currentCount++;
                    }

                }
                count--;
            }
            flip=!flip;
            count=currentCount;


        }

    }
}
