package BinaryTree;
//https://www.geeksforgeeks.org/sum-parent-nodes-child-node-x/

public class SumOfAllParentNode_Child_X {
    static int sum=0;
    public static void main(String[] args) {
        BinaryTreeNode node=new BinaryTreeNode(4);
        node.leftNode=new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(5);
        node.leftNode.leftNode=new BinaryTreeNode(7);
        node.leftNode.rightNode=new BinaryTreeNode(2);
        node.rightNode.leftNode=new BinaryTreeNode(2);
        node.rightNode.rightNode=new BinaryTreeNode(3);

        sumOfAllNodes(node,2);

        System.out.println(sum);


    }

    public static void sumOfAllNodes(BinaryTreeNode rootNode, int x) {
        if(rootNode==null)
            return;

        if((rootNode.leftNode!=null && rootNode.leftNode.data==x) ||
                (rootNode.rightNode!=null && rootNode.rightNode.data==x)) {

            sum= sum+rootNode.data;
        }

        sumOfAllNodes(rootNode.leftNode,x);
        sumOfAllNodes(rootNode.rightNode,x);
    }




}
