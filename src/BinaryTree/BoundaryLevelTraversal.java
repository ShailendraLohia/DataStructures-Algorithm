package BinaryTree;

public class BoundaryLevelTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node= new BinaryTreeNode(20);
        node.leftNode=new BinaryTreeNode(8);
        node.rightNode= new BinaryTreeNode(22);
        node.leftNode.leftNode=new BinaryTreeNode(4);
        node.leftNode.rightNode=new BinaryTreeNode(12);
        node.leftNode.rightNode.leftNode=new BinaryTreeNode(10);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(14);
        node.rightNode.rightNode=new BinaryTreeNode(25);

        if(node!=null)
            System.out.print(node.data + " ");

        leftTraversal(node.leftNode);
        leafNodeTraversal(node.leftNode);
        leafNodeTraversal(node.rightNode);
        rightTraversal(node.rightNode);


    }

    public static void leftTraversal(BinaryTreeNode rootNode) {
        if(rootNode!=null){
            if(rootNode.leftNode!=null) {
                System.out.print(rootNode.data + " ");
                leftTraversal(rootNode.leftNode);
            }
            else if(rootNode.rightNode!=null) {
                System.out.print(rootNode.data + " ");
                leftTraversal(rootNode.rightNode);
            }
        }
    }

    public static void rightTraversal(BinaryTreeNode rootNode) {
        if(rootNode!=null) {
            if(rootNode.rightNode!=null) {
                rightTraversal(rootNode.rightNode);
                System.out.print(rootNode.data + " ");
            }
            else if(rootNode.leftNode!=null) {
                rightTraversal(rootNode.leftNode);
                System.out.print(rootNode.data + " ");
            }
        }
    }

    public static void leafNodeTraversal(BinaryTreeNode rootNode) {
        if(rootNode!=null) {
            leafNodeTraversal(rootNode.leftNode);

            if (rootNode.leftNode == null && rootNode.rightNode == null)
                System.out.print(rootNode.data + " ");

            leafNodeTraversal(rootNode.rightNode);
        }
    }
}
