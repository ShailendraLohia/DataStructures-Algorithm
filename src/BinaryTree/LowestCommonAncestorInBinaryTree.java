package BinaryTree;

/**
 * Created by Shailendra on 2/2/2017.
 */
public class LowestCommonAncestorInBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(3);
        node.leftNode= new BinaryTreeNode(6);
        node.rightNode=new BinaryTreeNode(8);
        node.leftNode.leftNode= new BinaryTreeNode(2);
        node.leftNode.rightNode=new BinaryTreeNode(11);
        node.leftNode.rightNode.leftNode = new BinaryTreeNode(9);
        node.leftNode.rightNode.rightNode = new BinaryTreeNode(5);

        //node.rightNode.leftNode=new BinaryTreeNode(25);
        node.rightNode.rightNode=new BinaryTreeNode(13);
        //node.rightNode.leftNode.rightNode = new BinaryTreeNode(28);

        node.rightNode.rightNode.leftNode= new BinaryTreeNode(7);

        BinaryTreeNode result = lowestCommonAncestor(node,2,5);
        System.out.print(result.data);
    }

    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode rootNode, int p,int q) {
        if(rootNode==null)
            return null;

        if(rootNode.data== p || rootNode.data== q) {
            return rootNode;
        }

        BinaryTreeNode left= lowestCommonAncestor(rootNode.leftNode,p,q);
        BinaryTreeNode right= lowestCommonAncestor(rootNode.rightNode, p,q);

        if(left != null && right != null){
            return rootNode;
        }
        return left != null ? left : right;

    }
}
