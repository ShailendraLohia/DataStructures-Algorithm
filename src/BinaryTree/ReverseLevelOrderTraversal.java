package BinaryTree;

import java.util.Stack;

/**
 * Created by shailendralohia on 10/29/18.
 */
public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.leftNode= new BinaryTreeNode(2);
        node.rightNode=new BinaryTreeNode(3);
        node.leftNode.leftNode=new BinaryTreeNode(4);
        node.leftNode.rightNode= new BinaryTreeNode(5);

        //reverseLevelOrderTraversal(node);

        Stack<Integer> stack=new Stack<>();
        int height=HeightOfBinaryTree.heightOfTree(node);
        stack=reverseLevelOrderTraversalUsingRecursion(node,height,stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

    }

//    public static void reverseLevelOrderTraversal(BinaryTreeNode rootNode) {
//        if(rootNode==null)
//            return;
//
//        Stack<BinaryTreeNode> stack1= new Stack<>();
//        Stack<BinaryTreeNode> stack2= new Stack<>();
//        Stack<Integer> stack3= new Stack<>();
//
//        stack1.push(rootNode);
//
//        while(!stack1.isEmpty() || !stack2.isEmpty()) {
//
//            while(!stack1.isEmpty()) {
//                rootNode=stack1.pop();
//                stack3.push(rootNode.data);
//
//                if(rootNode.leftNode!=null)
//                    stack2.push(rootNode.leftNode);
//
//                if(rootNode.rightNode!=null)
//                    stack2.push(rootNode.rightNode);
//            }
//
//            while(!stack2.isEmpty()) {
//                rootNode=stack2.pop();
//                stack3.push(rootNode.data);
//
//                if(rootNode.leftNode!=null)
//                    stack1.push(rootNode.leftNode);
//
//                if(rootNode.rightNode!=null)
//                    stack1.push(rootNode.rightNode);
//            }
//        }
//
//        while (!stack3.isEmpty()) {
//            System.out.print(stack3.pop()+ ",");
//        }
//    }

    public static Stack<Integer> reverseLevelOrderTraversalUsingRecursion(BinaryTreeNode rootNode, int level,Stack<Integer> stack) {
            if(rootNode==null)
                return stack;

//            if(level==1)
//                System.out.println(rootNode.data + " ");
        stack.push(rootNode.data);

        reverseLevelOrderTraversalUsingRecursion(rootNode.rightNode,level-1,stack);
        reverseLevelOrderTraversalUsingRecursion(rootNode.leftNode,level-1,stack);


        return stack;
    }
}
