package tree;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class IsUnivalTree965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recurIsUnivalTree(root, root.val);
    }

    /**
     * 现在写的这个就是递归的范式。经典的一句话，二叉树中的递归算法和动态规划的自顶向下是差不多的。
     *
     * @param node
     * @param target
     * @return
     */
    private boolean recurIsUnivalTree(TreeNode node, int target) {
        if (node == null) {
            return true;
        }

        if (node.val != target) {
            return false;
        }

        if (!recurIsUnivalTree(node.left, target)) {
            return false;
        }

        return recurIsUnivalTree(node.right, target);
    }
}
