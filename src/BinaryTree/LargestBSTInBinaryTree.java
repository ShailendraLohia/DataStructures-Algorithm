package BinaryTree;

/**
 * Created by Shailendra on 2/4/2017.
 */
public class LargestBSTInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.leftNode = new BinaryTreeNode(-5);
        node.rightNode = new BinaryTreeNode(30);
        node.leftNode.leftNode = new BinaryTreeNode(-10);
        node.leftNode.rightNode = new BinaryTreeNode(0);
        node.leftNode.rightNode.rightNode = new BinaryTreeNode(5);
        //node.rightNode.leftNode = new BinaryTreeNode(21);
        node.rightNode.rightNode = new BinaryTreeNode(36);

        MinMax result=largestBST(node);
        System.out.println(result.size);

    }

    public static MinMax largestBST(BinaryTreeNode rootNode) {
        if(rootNode==null)
            return new MinMax();


        MinMax left=largestBST(rootNode.leftNode);
        MinMax right=largestBST(rootNode.rightNode);

        MinMax mm=new MinMax();

        if(left.isBST==false || right.isBST==false || (left.max>rootNode.data || right.min <= rootNode.data)) {
            mm.isBST=false;
            mm.size=Math.max(left.size,right.size);
            return mm;
        }
        mm.isBST=true;
        mm.size= 1+left.size+right.size;
        mm.min=rootNode.leftNode!=null?left.min:rootNode.data;
        mm.max=rootNode.rightNode!=null?right.max:rootNode.data;

        return mm;

    }
}

class MinMax {
    boolean isBST;
    int size;
    int min;
    int max;

    MinMax() {
        isBST=true;
        size=0;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;

    }
}
