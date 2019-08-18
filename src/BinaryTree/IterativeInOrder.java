package BinaryTree;

import java.util.Stack;

/**
 * Created by Shailendra on 1/2/2017.
 */
public class IterativeInOrder {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(-1);
        node.rightNode=new BinaryTreeNode(11);
        node.leftNode.leftNode=new BinaryTreeNode(-2);
        node.leftNode.rightNode= new BinaryTreeNode(-3);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(21);
        node.rightNode.rightNode=new BinaryTreeNode(6);

        iterateInOrder(node);
    }

    public static void iterateInOrder(BinaryTreeNode rootNode) {
        if(rootNode == null)
            return;

        Stack<BinaryTreeNode> stack = new Stack<>();

        while(true) {
            if(rootNode !=null) {
                stack.push(rootNode);
                rootNode=rootNode.leftNode;
            }
            else{
                if(stack.empty()) {
                    break;
                }
                rootNode=stack.pop();
                System.out.print(rootNode.data+",");
                rootNode= rootNode.rightNode;
            }
        }

    }
}
