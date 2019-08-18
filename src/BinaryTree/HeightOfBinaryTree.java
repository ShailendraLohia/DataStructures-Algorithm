package BinaryTree;

import static java.lang.Integer.max;

/**
 * Created by Shailendra on 1/11/2017.
 */
public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode= new BinaryTreeNode(20);
        node.rightNode=new BinaryTreeNode(30);
        node.leftNode.leftNode=new BinaryTreeNode(40);
        node.leftNode.leftNode.rightNode= new BinaryTreeNode(70);
        node.rightNode.leftNode=new BinaryTreeNode(50);
        node.rightNode.rightNode=new BinaryTreeNode(60);

        int result = iterativeHeightOfTree(node);
        System.out.print(result);
    }

    public static int heightOfTree(BinaryTreeNode rootNode) {
        if(rootNode==null) {
            return 0;
        }
        int leftHeight=heightOfTree(rootNode.leftNode);
        int rightHeight=heightOfTree(rootNode.rightNode);

        return 1 + max(leftHeight,rightHeight);
    }

    public static int iterativeHeightOfTree(BinaryTreeNode rootNode) {

        int leftHeight=0;
        int rightHeight=0;
        BinaryTreeNode firstNode = rootNode;

        while(rootNode!=null) {
            if(rootNode.leftNode!=null) {
                leftHeight +=1;
                rootNode=rootNode.leftNode;
            }else if (rootNode.rightNode!=null){
                    leftHeight +=1;
                    rootNode=rootNode.leftNode;
                }
                else{
                rootNode=null;
            }
        }
        while(firstNode!=null) {
            if(firstNode.rightNode!=null) {
                rightHeight +=1;
                firstNode=firstNode.rightNode;
            }
            else if(firstNode.leftNode!=null) {
                rightHeight +=1;
                firstNode=firstNode.rightNode;
            }
            else {
                firstNode=null;

            }
        }
        return 1 + max(leftHeight,rightHeight);
    }
}
