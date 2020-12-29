package tree;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组
 *
 * @author Baitao zou
 * date 2019/2/22 0022
 */
public class AverageOfLevels637 {

    public List<Double> averageOfLevels(TreeNode root) {
        return averageOfLevelsByRecur(root);
    }

    /**
     * 使用Stack实现Queue
     *
     * @param root 二叉树根节点
     * @return 每层的节点
     */
    public List<Double> averageOfLevelsByStack(TreeNode root) {
        List<Double> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> dequeue = new Stack<>();
        Stack<TreeNode> enqueue = new Stack<>();

        TreeNode curNode = root;

        dequeue.push(curNode);

        while (!dequeue.isEmpty() || !enqueue.isEmpty()) {
            if (dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
            }
            double sum = 0;
            int count = 0;
            while (!dequeue.isEmpty()) {
                curNode = dequeue.pop();
                count++;
                sum += curNode.val;
                if (curNode.left != null) {
                    enqueue.push(curNode.left);
                }
                if (curNode.right != null) {
                    enqueue.push(curNode.right);
                }
            }
            lists.add(sum / count);
        }
        return lists;
    }

    /**
     * 递归求解，借用系统递归栈，不使用额外的空间
     *
     * @param root 二叉树根节点
     * @return 每层节点平均值
     */
    private List<Double> averageOfLevelsByRecur(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> result = new LinkedList<>();
        recur(Collections.singletonList(root), result);
        return result;
    }

    /**
     * 递归求解
     *
     * @param curNodes 当前层节点
     * @param result   每一层节点平均值
     */
    private void recur(List<TreeNode> curNodes, List<Double> result) {
        if (curNodes == null || curNodes.size() == 0) {
            return;
        }
        List<TreeNode> nextNodes = new LinkedList<>();
        long sum = 0;
        for (TreeNode treeNode : curNodes) {
            if (treeNode.left != null) {
                nextNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextNodes.add(treeNode.right);
            }
            sum += treeNode.val;
        }
        result.add((double) sum / curNodes.size());
        recur(nextNodes, result);
    }
}
