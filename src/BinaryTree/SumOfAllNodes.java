package BinaryTree;

// https://www.geeksforgeeks.org/sum-nodes-binary-tree/
public class SumOfAllNodes {
    //static int sum=0;
    public static void main(String[] args) {

        BinaryTreeNode node=new BinaryTreeNode(15);
        node.leftNode=new BinaryTreeNode(10);
        node.rightNode=new BinaryTreeNode(20);
        node.leftNode.leftNode=new BinaryTreeNode(8);
        node.leftNode.rightNode=new BinaryTreeNode(12);
        node.rightNode.leftNode=new BinaryTreeNode(16);
        node.rightNode.rightNode=new BinaryTreeNode(25);

        int sum=sumOfNodes(node);
        System.out.println(sum);

    }

    public static int sumOfNodes(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return 0;

//        sum= sum + rootNode.data;
//        sumOfNodes(rootNode.leftNode);
//        sumOfNodes(rootNode.rightNode);

        // Another way as below

        //return rootNode.data + sumOfNodes(rootNode.leftNode) + sumOfNodes(rootNode.rightNode);

        int total=0;
        total=total+rootNode.data;

        total +=sumOfNodes(rootNode.leftNode);
        total +=sumOfNodes(rootNode.rightNode);

        return total;
    }
}
