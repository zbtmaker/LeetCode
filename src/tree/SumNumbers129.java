package tree;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class SumNumbers129 {

    private int sum = 0;

    /**
     * 这个题目和路径总和(hasPathSum、pathSum等)一样的，使用的是回溯法实现。
     *
     * @param root 二叉树根节点
     * @return 二叉树目标和
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recur(root, root.val);
        return this.sum;
    }

    /**
     * @param curNode 当前二叉树根节点
     * @param i       当前目标和
     */
    private void recur(TreeNode curNode, int i) {
        if (curNode.left == null && curNode.right == null) {
            sum += i;
        }
        i *= 10;
        if (curNode.left != null) {
            i += curNode.left.val;
            recur(curNode.left, i);
            i -= curNode.left.val;
        }
        if (curNode.right != null) {
            i += curNode.right.val;
            recur(curNode.right, i);
        }
    }
}
