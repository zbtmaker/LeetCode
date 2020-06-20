package tree;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class DiameterOfBinaryTree543 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 这个题目和树的最大深度是一类题，其实就是动态规划的题，当前树的diameter等于左子树的maxDepth和右子树的
     * diameter(root)= F{maxDepth(root.left),root.left != null} + F{maxDepth(root.right),root.right!=null}
     * 其实这个题目的最大子树不一定包含根节点，这是因为如果我们的左子树或者右子树就已经是最大值，那么我们不需要
     * 其实堆于每一个节点，我们需要计算三个值，一个值是左边树的的直径，另一个是右边树的直径，然后是比较左边树的直径和右边树的直径
     * 其实我们就是要确定我们的递归范式，因为对于每一个子树，我们需要的就是比较右边子树的节点数量和左边子树节点数量之和。因为对于父节点来说
     * 子节点只能是包含其子节点的左子树或者右子树的一部分。
     *
     * @param root 二叉树的根节点
     * @return 最长直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{0};

        maxDepth(root, max);
        return max[0] == 0 ? 0 : max[0] - 1;
    }

    private int maxDepth(TreeNode curNode, int[] max) {
        if (curNode == null) {
            return 0;
        }
        int left = maxDepth(curNode.left, max);
        int right = maxDepth(curNode.right, max);
        max[0] = Math.max(left + right + 1, max[0]);
        return Math.max(left, right) + 1;
    }
}
