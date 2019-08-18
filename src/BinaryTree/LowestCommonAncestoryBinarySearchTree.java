package BinaryTree;

import static java.lang.Integer.max;

/**
 * Created by Shailendra on 1/22/2017.
 */
public class LowestCommonAncestoryBinarySearchTree {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode= new BinaryTreeNode(-10);
        node.rightNode=new BinaryTreeNode(30);
        //node.leftNode.leftNode= new BinaryTreeNode(4);
        node.leftNode.rightNode=new BinaryTreeNode(8);
        node.leftNode.rightNode.leftNode = new BinaryTreeNode(6);
        node.leftNode.rightNode.rightNode = new BinaryTreeNode(9);

        node.rightNode.leftNode=new BinaryTreeNode(25);
        node.rightNode.rightNode=new BinaryTreeNode(60);
        node.rightNode.leftNode.rightNode = new BinaryTreeNode(28);

        node.rightNode.rightNode.rightNode= new BinaryTreeNode(78);

        BinaryTreeNode result = lowestCommonAncestor(node,9,28);
        System.out.print(result.data);
    }

    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, int p, int q) {
        if (root.data > Math.max(p, q)) {
            return lowestCommonAncestor(root.leftNode, p, q);
        } else if (root.data < Math.min(p, q)) {
            return lowestCommonAncestor(root.rightNode, p, q);
        } else {
            return root;
        }
    }
}
