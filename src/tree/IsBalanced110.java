package tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class IsBalanced110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        recurIsBalanced(root, 0);
        return flag;
    }

    /**
     * 思路：之前我将问题看成是一个动态规划，确实也可以用动态规划的思想去做这个题，
     * 也就是说，如果一棵树的左子树或者右子树返回false，那么当前节点就应该为false。
     * 这个题目可以说是maxDepth的改善题。因此和<>isBalanced110</>那个题目是一样的，
     * 虽然我们需要返回这个题目是否平衡，但是我们递归的返回值不一定就是这颗树是否
     * 是平衡的（也就是true/false)。所以我需要递归的求解每一个节点的深度，然后就
     * 判断这个节点是否是平衡的，我使用了flag = true表示默认是平衡参数，一旦某一个节
     * 点不平衡，那么我们将flag的值赋值为false，如果节点平衡，那么flag的值不需要改变。
     *
     * @param curNode
     * @return
     */
    private int recurIsBalanced(TreeNode curNode, int depth) {
        if (curNode == null) {
            return 0;
        }
        int leftDepth = recurIsBalanced(curNode.left, depth);
        int rightDepth = recurIsBalanced(curNode.right, depth);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            flag = false;
        }
        depth = Math.max(leftDepth, rightDepth) + 1;
        return depth;
    }
}
