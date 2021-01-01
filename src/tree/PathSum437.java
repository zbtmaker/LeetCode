package tree;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class PathSum437 {
    private int count = 0;

    /**
     * 方式一：采用前序遍历+以每个节点作为根节点进行遍历
     *
     * @param root   二叉树根节点
     * @param target 目标和
     * @return 路径数
     */
    public int pathSum(TreeNode root, int target) {
        preorder(root, target);
        return this.count;
    }

    /**
     * 前序遍历
     *
     * @param root   二叉树根节点
     * @param target 目标和
     */
    private void preorder(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        recurPathSum(root, target, 0);
        preorder(root.left, target);
        preorder(root.right, target);
    }

    /**
     * @param root   二叉树根节点
     * @param target 目标和
     * @param sum    路径和
     */
    private void recurPathSum(TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }
        if (sum == target) {
            count++;
        }
        sum += root.val;
        recurPathSum(root.left, target, sum);
        recurPathSum(root.right, target, sum);
    }
}
