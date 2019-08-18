package Miscellaneous.Heap;

import BinaryTree.BinaryTreeNode;
import BinaryTree.ValidateCompleteBinaryTree;
//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

public class ValidateBinaryTreeAsHeap {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = new BinaryTreeNode(97);
        rootNode.leftNode = new BinaryTreeNode(46);
        rootNode.rightNode = new BinaryTreeNode(37);
        rootNode.leftNode.leftNode= new BinaryTreeNode(12);
        rootNode.leftNode.rightNode=new BinaryTreeNode(3);

        boolean result = isHeap(rootNode);

        System.out.println(result);
    }


    public static boolean isHeap(BinaryTreeNode rootNode) {
        if (rootNode==null)
            return true;


        int countOfNodes= ValidateCompleteBinaryTree.countNumberOfNodes(rootNode);

        if(ValidateCompleteBinaryTree.validateCompleteBinaryTree(rootNode,0,countOfNodes)==true
            && validateBinaryTreeAsHeap(rootNode)== true) {
            return true;
        }
        return false;

    }

    public static boolean validateBinaryTreeAsHeap(BinaryTreeNode rootNode) {
        if(rootNode.leftNode == null && rootNode.rightNode == null)
            return true;

        if(rootNode.data>rootNode.leftNode.data && rootNode.data>rootNode.rightNode.data) {
            return validateBinaryTreeAsHeap(rootNode.leftNode) && validateBinaryTreeAsHeap(rootNode.rightNode);
        }
        else
            return false;

    }


}
