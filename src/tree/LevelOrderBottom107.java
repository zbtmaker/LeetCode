package tree;

import java.util.*;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class LevelOrderBottom107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return levelOrderBottomByRecur(root);
    }

    /**
     * 采用Stack方式实现Queue的方式
     *
     * @param root 二叉树根节点
     * @return 二叉树自底向上遍历后的结果
     */
    private List<List<Integer>> levelOrderBottomByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> list = new LinkedList<>();
        Stack<TreeNode> enqueue = new Stack<>();
        Stack<TreeNode> dequeue = new Stack<>();
        dequeue.push(root);

        List<Integer> curList;
        while (!dequeue.isEmpty() || !enqueue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
            curList = new LinkedList<>();
            while (!dequeue.isEmpty()) {
                TreeNode curNode = dequeue.pop();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    enqueue.add(curNode.left);
                }
                if (curNode.right != null) {
                    enqueue.add(curNode.right);
                }
            }
            list.addFirst(curList);
        }
        return list;
    }

    /**
     * 自底向上遍历
     *
     * @param root 二叉树根节点
     * @return 自底向上遍历
     */
    private List<List<Integer>> levelOrderBottomByRecur(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        recur(Collections.singletonList(root), result);
        return result;
    }

    /**
     * 递归方式解决，利用程序自身递归调用栈方式
     *
     * @param treeNodes 二叉树当前层节点
     * @param result    遍历结果
     */
    private void recur(List<TreeNode> treeNodes, List<List<Integer>> result) {
        if (treeNodes == null || treeNodes.size() == 0) {
            return;
        }
        List<TreeNode> nextTreeNodes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.left != null) {
                nextTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextTreeNodes.add(treeNode.right);
            }
            values.add(treeNode.val);
        }
        recur(nextTreeNodes, result);
        result.add(values);
    }
}
