package BinaryTree;

/**
 * Created by Shailendra on 1/3/2017.
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode = new BinaryTreeNode(-5);
        node.rightNode = new BinaryTreeNode(30);
        node.leftNode.leftNode = new BinaryTreeNode(-10);
        node.leftNode.rightNode = new BinaryTreeNode(0);
        node.leftNode.rightNode.rightNode = new BinaryTreeNode(5);
        //node.rightNode.leftNode = new BinaryTreeNode(21);
        node.rightNode.rightNode = new BinaryTreeNode(36);

        boolean result = binearySearchTree(node, 360);
        System.out.println(result);
    }

    public static boolean binearySearchTree(BinaryTreeNode rootNode, int givenData) {

        if(rootNode ==null)
            return false;

        while(rootNode !=null) {
            if(givenData == rootNode.data) {
                return true;
            }
            else if(givenData < rootNode.data ) {
                rootNode = rootNode.leftNode;
            }
            else {
                rootNode = rootNode.rightNode;
            }

        }
        return false;
    }
}
