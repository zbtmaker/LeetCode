package tree;

import java.util.*;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class LevelOrder102 {
    /**
     * 方法一：层次遍历就是使用一个队列来实现，但是在Java中没有线程不安全的Queue，所以我使用了两个Stack来实现
     * 我们的队列，一个Stack为enqueue用来入栈队列中的元素，另一个Stack为inqueue用来出栈元素。
     * 方法二：借助递归调用机制，JVM自身程序的递归就是栈的思想
     *
     * @param root 二叉树根节点
     * @return 层次遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderByRecur(root);
    }

    private List<List<Integer>> levelOrderByStack(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> dequeue = new Stack<>();
        Stack<TreeNode> enqueue = new Stack<>();

        TreeNode curNode = root;

        dequeue.push(curNode);

        while (!dequeue.isEmpty() || !enqueue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }

            List<Integer> list = new ArrayList<>();

            while (!dequeue.isEmpty()) {
                curNode = dequeue.pop();
                list.add(curNode.val);
                if (curNode.left != null) {
                    enqueue.push(curNode.left);
                }
                if (curNode.right != null) {
                    enqueue.push(curNode.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 采用递归方式取代队列方式
     *
     * @param root 根节点
     */
    private List<List<Integer>> levelOrderByRecur(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        recur(Collections.singletonList(root), result);
        return result;
    }

    /**
     * 递归调用
     *
     * @param treeNodes 二叉树当前行节点
     * @param result    最终结果
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
        result.add(values);
        recur(nextTreeNodes, result);
    }
}
