package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class PathSum113 {
    /**
     * 这就是一个回溯法能够解决的题，其中的难点就在于递归的范式中的halting rule，对于一个从根节点到叶子节点
     * 总和，那么只有当当前节点curNode.left==null且curNode.right == null 且径路之和sum == target的时候
     * 此时我们将list当中的元素添加到lists当中。我们在决定了halting rule之后，那么我们需要对每一个节点的下
     * 一步递归进行判断。因为停止halting rule是curNode.left 和 curNode.right都要等于零，那么这个时候我们
     * 在对curNode的left和right进行递归的时候，就需要首先判断curNode的left和right是否为null，如果不为null
     * 那么就进行下一步递归调用。
     *
     * @param root   二叉树根节点
     * @param target 目标和
     * @return 路径数组
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return lists;
        }

        list.add(root.val);
        recurPathSum(root, target, root.val, lists, list);
        return lists;
    }

    private void recurPathSum(TreeNode curNode, int target, int sum,
                              List<List<Integer>> lists, LinkedList<Integer> list) {
        if (curNode.left == null && curNode.right == null && sum == target) {
            lists.add(new LinkedList<>(list));
            return;
        }
        if (curNode.left != null) {
            sum += curNode.left.val;
            list.add(curNode.left.val);
            recurPathSum(curNode.left, target, sum, lists, list);
            sum -= curNode.left.val;
            list.removeLast();
        }

        if (curNode.right != null) {
            sum += curNode.right.val;
            list.add(curNode.right.val);
            recurPathSum(curNode.right, target, sum, lists, list);
            list.removeLast();
        }
    }
}
