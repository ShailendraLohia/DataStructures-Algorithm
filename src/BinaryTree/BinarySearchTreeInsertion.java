package BinaryTree;

/**
 * Created by Shailendra on 1/7/2017.
 */
public class BinarySearchTreeInsertion {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode = new BinaryTreeNode(-5);
        node.rightNode = new BinaryTreeNode(16);
        node.leftNode.leftNode = new BinaryTreeNode(-8);
        node.leftNode.rightNode = new BinaryTreeNode(7);
        node.rightNode.rightNode = new BinaryTreeNode(18);

        insertNode(node,6);
        IterativeBinarySearch ibs = new IterativeBinarySearch();
        //ibs.iterativeBinarySearch(node,6);
        BinaryTreeNode result = ibs.iterativeBinarySearch(node, 6);
        if(result !=null)
            System.out.println(true);
        else{
            System.out.println(false);
        }
    }

    public static void insertNode(BinaryTreeNode node, int givenData) {
        BinaryTreeNode givenNode = new BinaryTreeNode(givenData);

        if(node == null) {
            return;
        }
        BinaryTreeNode parentNode=null;
        while(node != null) {
            parentNode=node;
            if( givenData < node.data) {
                node=node.leftNode;
            }
            else{
                node=node.rightNode;
            }
        }
        System.out.println(parentNode.data);
        if(parentNode.data>=givenData) {
            parentNode.leftNode=givenNode;
        }
        else{
            parentNode.rightNode=givenNode;
        }

    }
}
