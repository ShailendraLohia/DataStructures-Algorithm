package BinaryTree;

/*
    A tree should be complete when -
    a) Nodes are being added in top-down manner
    b) Left node needs to be added first than right node.

 */
public class ValidateCompleteBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = new BinaryTreeNode(1);
        rootNode.leftNode=new BinaryTreeNode(2);
        rootNode.rightNode=new BinaryTreeNode(3);
        rootNode.leftNode.leftNode=new BinaryTreeNode(4);
        rootNode.leftNode.rightNode= new BinaryTreeNode(5);
        rootNode.rightNode.rightNode=new BinaryTreeNode(6);

        int countNodes= countNumberOfNodes(rootNode);
        boolean result = validateCompleteBinaryTree(rootNode,0,countNodes);


        System.out.println(result);

    }

    public static boolean validateCompleteBinaryTree(BinaryTreeNode rootNode, int index, int countOfNodes) {

        if(rootNode==null)
            return true;

        if(index>=countOfNodes)
            return false;


        return validateCompleteBinaryTree(rootNode.leftNode,2*index+1,countOfNodes)
                && validateCompleteBinaryTree(rootNode.rightNode,2*index+2,countOfNodes);
    }

    public static int countNumberOfNodes(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return 0;

        return (1 + countNumberOfNodes(rootNode.leftNode) + countNumberOfNodes(rootNode.rightNode));
    }
}
