package tree;

/**
 * @author Baitao Zou
 * date 2021/01/12
 */
public class MaxPathSum124 {

    private int max = Integer.MIN_VALUE;

    /**
     * 这个题目就是一个postOrder的应用，为什么这么说呢？对于很多二叉树问题都可以采用递归问题解决。
     * 那么从二叉树顶看下去，从下面的子树找出一条最大的路径，那么子树的最大路径有什么规律呢？其实就是下面
     * 三中情况
     * case1：除了子树的根节点，不包含其他节点，那说明子树的根节点的值是大于零的，这个想法的来源于最大子数组和
     * case2：除了子树的根节点外，还有子树的子树的左子树贡献的一条路径，那么子树的左子树的这条路径一定是子树的
     * 值+子树左子树的值一定是大于零的。
     * case3：除了子树的根节点外，还有子树的右子树贡献的一条路径，子树右子树路径值一定是大于零的，而且子树右子树路径值
     * +子树根节点值一定大于零。
     * 我们的递归是先遍历左子树，然后遍历右子树，最终回到根节点，所以这个问题其实就是一个后序遍历+最大子数组和的变种问题
     *
     * @param root 二叉树根节点
     * @return 最大路径
     */
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftSum = postOrder(root.left);
        max = Math.max(leftSum, max);
        int rightSum = postOrder(root.right);
        max = Math.max(rightSum, max);

        int curMax = root.val;
        max = Math.max(curMax, max);
        //左子树+根节点
        if (leftSum > 0) {
            curMax = Math.max(curMax, leftSum + root.val);
        }
        //右子树+根节点
        if (rightSum > 0) {
            curMax = Math.max(curMax, rightSum + root.val);
        }
        max = Math.max(curMax, max);

        //当前子树
        if (leftSum > 0 && rightSum > 0) {
            max = Math.max(max, leftSum + rightSum + root.val);
        }

        return curMax > 0 ? curMax : Integer.MIN_VALUE;
    }
}
