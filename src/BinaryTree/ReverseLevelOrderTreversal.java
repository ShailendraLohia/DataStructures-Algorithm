package BinaryTree;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Shailendra on 1/15/2017.
 */
public class ReverseLevelOrderTreversal {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(-1);
        node.rightNode=new BinaryTreeNode(11);
        node.leftNode.leftNode=new BinaryTreeNode(-2);
        node.leftNode.rightNode= new BinaryTreeNode(-3);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(21);
        node.rightNode.rightNode=new BinaryTreeNode(6);

        reverseLevelOrderTreversal(node);

    }

    public static void reverseLevelOrderTreversal(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Queue<BinaryTreeNode> q1= new LinkedList<>();
        Stack<BinaryTreeNode> s1 = new Stack<>();
        q1.offer(rootNode);

        while(!q1.isEmpty()) {
            rootNode=q1.poll();
            rootNode=s1.push(rootNode);
            if(rootNode.rightNode!=null) {
                q1.offer(rootNode.rightNode);
            }
            if(rootNode.leftNode!=null) {
                q1.offer(rootNode.leftNode);
            }
        }
        while(!s1.isEmpty()) {
            rootNode=s1.pop();
            System.out.print(rootNode.data + " ");
        }
    }
}
