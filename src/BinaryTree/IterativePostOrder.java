package BinaryTree;

import java.util.Stack;

/**
 * Created by Shailendra on 1/2/2017.
 */
public class IterativePostOrder { //L,R,V
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(-1);
        node.rightNode=new BinaryTreeNode(11);
        node.leftNode.leftNode=new BinaryTreeNode(-2);
        node.leftNode.rightNode= new BinaryTreeNode(-3);
        node.leftNode.rightNode.rightNode=new BinaryTreeNode(5);
        node.rightNode.leftNode=new BinaryTreeNode(21);
        node.rightNode.rightNode=new BinaryTreeNode(6);

        iteratePostOrder(node);
        System.out.println();
        iteratePostOrderUsingOneStack(node);
    }

    public static void iteratePostOrder(BinaryTreeNode rootNode){

        if(rootNode == null){
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(rootNode);

        while(!stack1.empty()) {
            rootNode = stack1.pop();
            stack2.push(rootNode);

            if(rootNode.leftNode !=null) {
                stack1.push(rootNode.leftNode);
            }
            if(rootNode.rightNode !=null) {
                stack1.push(rootNode.rightNode);
            }
        }

        while(!stack2.empty()) {
            rootNode=stack2.pop();
            System.out.print(rootNode.data+ ",");
        }




    }

    public static void iteratePostOrderUsingOneStack(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return;

        BinaryTreeNode current = rootNode;
        Stack<BinaryTreeNode> s1 = new Stack<>();
        //s1.push(rootNode);

        while(current!=null || !s1.isEmpty()) {
            if(current!=null) {
                s1.push(current);
                current=current.leftNode;
            }
            else{
                BinaryTreeNode temp= s1.peek().rightNode;

                if(temp==null) {
                    temp=s1.pop();
                    System.out.print(temp.data + " ");
                    while(!s1.isEmpty() && temp==s1.peek().rightNode) {
                        temp=s1.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else{
                    current=temp;
                }
            }
        }
    }
}
