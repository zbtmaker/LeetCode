package tree;

import org.junit.Test;

public class LowestCommonAncestor236 {


    /**
     * 解题思路：递归大法好，如果一个节点的左子树返回true，
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] c = new TreeNode[1];
        recurCommonAncestor(root, p, q, c);
        return c[0];
    }

    public boolean recurCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode[] c) {
        if (root == null) {
            return false;
        }
        if (c[0] != null) {
            return true;
        }
        boolean rootFlag = false;
        if (root.val == p.val || root.val == q.val) {
            rootFlag = true;
        }

        boolean leftFlag = false;
        if (recurCommonAncestor(root.left, p, q, c)) {
            leftFlag = true;
            if (rootFlag && null == c[0]) {
                c[0] = root;
                return true;
            }

        }

        boolean rightFlag = false;
        if (recurCommonAncestor(root.right, p, q, c)) {
            rightFlag = true;
            if (rootFlag && null == c[0]) {
                c[0] = root;
                return true;
            }

        }

        if (rightFlag && leftFlag) {
            if (c[0] == null) {
                c[0] = root;
                return true;
            }

        }
        if (rootFlag || rightFlag || leftFlag) {
            return true;
        }
        return false;
    }

}
