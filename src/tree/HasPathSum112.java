package tree;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * link:https://leetcode-cn.com/problems/path-sum/
 *
 * @author Baitao zou
 * date 2019/2/21 0021.
 */
public class HasPathSum112 {
    /**
     * 这个题目需要注意的是必须是到达叶子节点，因此我们的递归的判断应该是curNode.left == null && curNode.right == null
     * && sum == target，这里的sum是root到leaf节点的路径和。
     *
     * @param root   二叉树根节点
     * @param target 目标和
     * @return true-存在和为target的root到leaf节点路径 ｜ false-不存在
     */
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return recurHasPathSum(root, target, root.val);
    }

    /**
     * @param curNode 当前节点
     * @param target  目标和
     * @param sum     路径总和
     * @return true-路径完成目标和 ｜ false-路径完成目标和
     */
    private boolean recurHasPathSum(TreeNode curNode, int target, int sum) {
        if (curNode.left == null && curNode.right == null) {
            return sum == target;
        }

        if (curNode.left != null) {
            sum += curNode.left.val;
            if (recurHasPathSum(curNode.left, target, sum)) {
                return true;
            }
            sum -= curNode.left.val;
        }
        if (curNode.right != null) {
            sum += curNode.right.val;
            return recurHasPathSum(curNode.right, target, sum);
        }
        return false;
    }
}
