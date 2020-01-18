package tree;

import java.util.Stack;

public class Flatten114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 从右边看这个问题，其实就是一个前序遍历的方式可以实现，但是借助栈的思想特别
     *
     * @param root 树的根
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> pushStack = new Stack<>();
        pushStack.push(root);
        TreeNode preNode = null;
        while (!pushStack.isEmpty()) {
            TreeNode node = pushStack.pop();
            if (preNode != null) {
                preNode.right = node;
                preNode.left = null;
            }
            preNode = node;
            if (node.right != null) {
                pushStack.push(node.right);
            }
            if (node.left != null) {
                pushStack.push(node.left);
            }
        }
    }

    /**
     * 借助栈的方式实现先序遍历
     *
     * @param root 二叉树的根
     */
    public void preOrderTraverseByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

    }


    /**
     * 递归的方式实现先序遍历
     *
     * @param root 二叉树的根
     */
    public void preOrderTraverseByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraverseByRecursive(root.left);
        preOrderTraverseByRecursive(root.right);
    }
}
