package tree;

import java.util.*;

/**
 * @author Baitao zou
 * date 2021/01/03
 */
public class ZigzagLevelOrder103 {
    private List<List<Integer>> result = new LinkedList<>();

    /**
     * 时间复杂度o(N),空间复杂度其实是O(2^?)
     * 这里我们用层次遍历的方式遍历每一个节点，层次遍历逻辑不变，还是从左至右遍历每一层的节点，
     * 但是将节点的值添加到结果数组中的时候，如果上一层采用的是从左往右，那么这一层就采用从右
     * 往左的方式添加。这里可以借用LinkedList的addFirst和addLast方法。
     *
     * @param root 二叉树的根
     * @return z形遍历结果
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrderByRecur(root);
    }

    private List<List<Integer>> zigzagLevelOrderByRecur(TreeNode root) {
        if (root == null) {
            return this.result;
        }
        recur(Collections.singletonList(root), true);
        return this.result;
    }

    private void recur(List<TreeNode> curTreeNodes, boolean orderLeft) {
        if (curTreeNodes == null || curTreeNodes.size() == 0) {
            return;
        }
        LinkedList<TreeNode> nextTreeNodes = new LinkedList<>();
        LinkedList<Integer> curValues = new LinkedList<>();
        for (TreeNode treeNode : curTreeNodes) {
            if (orderLeft) {
                curValues.addFirst(treeNode.val);
            } else {
                curValues.addLast(treeNode.val);
            }
            if (treeNode.left != null) {
                nextTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextTreeNodes.add(treeNode.right);
            }
        }
        result.add(curValues);
        recur(nextTreeNodes, !orderLeft);
    }
}
