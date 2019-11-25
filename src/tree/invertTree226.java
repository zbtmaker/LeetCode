package tree;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class invertTree226 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node4;
        node1.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;

        System.out.println(new invertTree226().invertTreeII(root));
    }

    /**
     * 这里使用**层次遍历**的方式实现二叉树的翻转，但是这样需要浪费2^N（其中N表示二叉树的层次）。
     * 相当于需要使用2*M的时间（M）表示二叉树中M个节点，因为这M个节点需要入栈和出栈。
     * @param root
     * @return
     */
    public TreeNode invertTreeI(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curNode= root;


        stack1.push(curNode);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(stack1.isEmpty()){
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }

            while(!stack1.isEmpty()){
                curNode = stack1.pop();
                TreeNode tmpNode = curNode.left;
                curNode.left = curNode.right;
                curNode.right = tmpNode;
                if(curNode.left != null){
                    stack2.push(curNode.left);
                }
                if(curNode.right != null){
                    stack2.push(curNode.right);
                }

            }
        }
        return root;
    }

    /**
     * 对于一个二叉树的翻转，每一个节点可以看做是以该节点的为根的一个子树，那么翻转当前节点和子节点
     * 的操作是一样的。其实这个问题和动态规划的自顶向下的思想一样，对于每一个节点都有一个范式：那就是
     * 首先将当前节点的两个子节点进行交换，然后调用recurInvertTree(node.right)和recurInvertTree(node.left)。
     * @param root
     * @return
     */
    public TreeNode invertTreeII(TreeNode root) {
        if(root == null){
            return root;
        }
        recurInvertTree(root);
        return root;
    }
    public void recurInvertTree(TreeNode curNode){
        if(curNode == null){
            return;
        }
        TreeNode tmpNode = curNode.left;
        curNode.left = curNode.right;
        curNode.right = tmpNode;

        recurInvertTree(curNode.left);
        recurInvertTree(curNode.right);
    }
}
