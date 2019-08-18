package BinaryTree;

/**
 * Created by Shailendra on 1/14/2017.
 */
public class validateBinarySearchTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode= new BinaryTreeNode(16);
        node.rightNode=new BinaryTreeNode(5);
        node.leftNode.rightNode=new BinaryTreeNode(-3);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(11);

        boolean result = isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.print(result);
    }

    public static boolean isBST(BinaryTreeNode rootNode, int min, int max) {
        if(rootNode==null) {
            return true;
        }
        if(rootNode.data<= min || rootNode.data >=max) {
            return false;
        }

        return isBST(rootNode.leftNode,min,rootNode.data) && isBST(rootNode.rightNode,rootNode.data,max);
    }
}
