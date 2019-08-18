package BinaryTree;

public class SumOfLeftLeafNode {
    public static void main(String[] args) {
        BinaryTreeNode node=new BinaryTreeNode(9);
        node.leftNode=new BinaryTreeNode(8);
        node.rightNode=new BinaryTreeNode(6);
        node.leftNode.leftNode=new BinaryTreeNode(5);
        node.leftNode.rightNode=new BinaryTreeNode(2);
        node.rightNode.leftNode=new BinaryTreeNode(1);

        int sum=sumOfLeftLeafNode(node);
        System.out.println(sum);

    }

    public static int sumOfLeftLeafNode(BinaryTreeNode rootNode) {

        int result=0;

        if(rootNode!=null) {
            if(isLeaf(rootNode.leftNode)) {
                result+=rootNode.leftNode.data;
            } else {
                result += sumOfLeftLeafNode(rootNode.leftNode);
            }

            result+=sumOfLeftLeafNode(rootNode.rightNode);
        }

        return result;

    }

    public static boolean isLeaf(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return false;

        if(rootNode.leftNode==null && rootNode.rightNode==null)
            return true;

        return false;
    }

}
