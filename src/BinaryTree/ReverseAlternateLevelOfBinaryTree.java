package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAlternateLevelOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode=new BinaryTreeNode(4);
        node.leftNode.rightNode= new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(6);
        node.rightNode.rightNode=new BinaryTreeNode(7);

        reverseAlternateLevel(node);

    }

    public static void reverseAlternateLevel(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(rootNode);
        int count=1;
        int size;

        while(!queue.isEmpty()) {
            count++;
            size=queue.size();

            for(int i=0;i<size;i++) {
                rootNode=queue.poll();
                System.out.print(rootNode.data + " ");

                if(count==2) { // swap the data
                    if(rootNode.leftNode!=null && rootNode.rightNode!=null) {
                        int temp= rootNode.leftNode.data;
                        rootNode.leftNode.data=rootNode.rightNode.data;
                        rootNode.rightNode.data=temp;

                        //Add nodes to queue
                        queue.add(rootNode.leftNode);
                        queue.add(rootNode.rightNode);

                        //re-initialize count value
                        count=0;
                    }
                }
                else {
                    //Add nodes to queue
                    queue.add(rootNode.leftNode);
                    queue.add(rootNode.rightNode);
                }
            }

        }
    }
}
