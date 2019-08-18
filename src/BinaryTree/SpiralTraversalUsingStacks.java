package BinaryTree;

import java.util.Stack;

/**
 * Created by Shailendra on 1/22/2017.
 */
public class SpiralTraversalUsingStacks {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode= new BinaryTreeNode(4);
        node.leftNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(7);
        node.leftNode.leftNode.leftNode= new BinaryTreeNode(8);
        node.leftNode.rightNode.leftNode = new BinaryTreeNode(9);
        node.rightNode.rightNode.rightNode= new BinaryTreeNode(10);

        spiralTraversal(node);
        //System.out.print(result);
    }

    public static void spiralTraversal(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Stack<BinaryTreeNode> s1= new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        s1.push(rootNode);

        while(!s1.isEmpty() || !s2.isEmpty()) {

            while(!s1.isEmpty()) {
                rootNode= s1.pop();
                System.out.print(rootNode.data + ",");
                if(rootNode.leftNode!=null) {
                    s2.push(rootNode.leftNode);
                }
                if(rootNode.rightNode!=null) {
                    s2.push(rootNode.rightNode);
                }
            }

            while(!s2.isEmpty()) {
                rootNode= s2.pop();
                System.out.print(rootNode.data + ",");
                if(rootNode.rightNode!=null) {
                    s1.push(rootNode.rightNode);
                }
                if(rootNode.leftNode!=null) {
                    s1.push(rootNode.leftNode);
                }

            }
        }
    }
}
