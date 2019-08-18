package BinaryTree;

import java.util.List;

/**
 * Created by Shailendra on 1/14/2017.
 */
public class RootToLeafSum {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode= new BinaryTreeNode(16);
        node.rightNode=new BinaryTreeNode(5);
        node.leftNode.rightNode=new BinaryTreeNode(-3);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(11);

        //int result = iterativeHeightOfTree(node);
        //System.out.print(result);
    }

    public static boolean rootToLeafSum(BinaryTreeNode rootNode, int givenNumber,List<Integer> result) {
        if(rootNode==null) {
            return false;
        }
        if(rootNode.leftNode==null && rootNode.rightNode==null) {// leaf node condition
            if(rootNode.data==givenNumber) {
                result.add(rootNode.data);
                return true;
            }
            else
                return false;
        }

        int data=givenNumber-rootNode.data;
        if(rootToLeafSum(rootNode.leftNode,data,result)) {
            result.add(rootNode.data);
            return true;

        }
        if(rootToLeafSum(rootNode.rightNode,data,result)) {
            result.add(rootNode.data);
            return true;
        }

        return false;
    }
}
