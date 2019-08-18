package BinaryTree;

/**
 * Created by Shailendra on 1/3/2017.
 */
public class IterativeBinarySearch {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode = new BinaryTreeNode(-5);
        node.rightNode = new BinaryTreeNode(30);
        node.leftNode.leftNode = new BinaryTreeNode(-10);
        node.leftNode.rightNode = new BinaryTreeNode(0);
        node.leftNode.rightNode.rightNode = new BinaryTreeNode(5);
        //node.rightNode.leftNode = new BinaryTreeNode(21);
        node.rightNode.rightNode = new BinaryTreeNode(36);

        BinaryTreeNode result = iterativeBinarySearch(node, 36);
        if(result !=null)
        System.out.println(true);
        else{
            System.out.println(false);
        }
    }

    public static BinaryTreeNode iterativeBinarySearch(BinaryTreeNode rootNode, int givenData) {
        if(rootNode == null) {
            return null;
        }
        if(givenData==rootNode.data){
            return rootNode;
        }else if(givenData < rootNode.data) {
            return iterativeBinarySearch(rootNode.leftNode,givenData);
        }else{
            return iterativeBinarySearch(rootNode.rightNode,givenData);
        }
    }
}
