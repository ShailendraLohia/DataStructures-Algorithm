package BinaryTree;

/**
 * Created by Shailendra on 1/7/2017.
 */
public class ValidateSameTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode = new BinaryTreeNode(-5);
        node.rightNode = new BinaryTreeNode(16);
        node.leftNode.leftNode = new BinaryTreeNode(-8);
        node.leftNode.rightNode = new BinaryTreeNode(7);
        node.rightNode.rightNode = new BinaryTreeNode(18);


        BinaryTreeNode anotherNode = new BinaryTreeNode(10);
        anotherNode.leftNode = new BinaryTreeNode(-5);
        anotherNode.rightNode = new BinaryTreeNode(16);
        anotherNode.leftNode.leftNode = new BinaryTreeNode(-8);
        anotherNode.leftNode.rightNode = new BinaryTreeNode(7);
        anotherNode.rightNode.rightNode = new BinaryTreeNode(18);

        boolean result = checkSameTree(node, anotherNode);
        System.out.print(result);
    }

    public static boolean checkSameTree(BinaryTreeNode firstTreeNode, BinaryTreeNode secondTreeNode) {
        if(firstTreeNode==null && secondTreeNode== null){
            return true;
        }
        if(firstTreeNode== null || secondTreeNode== null){
            return false;
        }
        return firstTreeNode.data==secondTreeNode.data
            &&(checkSameTree(firstTreeNode.leftNode,secondTreeNode.leftNode))
                &&(checkSameTree(firstTreeNode.rightNode,secondTreeNode.rightNode));
    }
}
