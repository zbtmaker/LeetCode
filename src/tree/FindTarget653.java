package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zoubaitao
 * date 2019\2\24 0024.
 */
public class FindTarget653 {
    /**
     * 使用前序遍历和HashMap实现，这种方式运行时间过长，是否可以运用递归的范式解决这个问题。
     *
     * @param root 二叉树根节点
     * @param k    目标
     * @return true-存在两个节点之和为k, false-不存在
     */
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                if (map.containsKey(curNode.val)) {
                    return true;
                } else {
                    map.put(k - curNode.val, curNode.val);
                }
                curNode = curNode.right;
            }
        }
        return false;
    }

    /**
     * 使用前序实现
     *
     * @return
     */
    public boolean preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
            } else {
                curNode = stack.pop();
                System.out.println(curNode.val);
            }
            curNode = curNode.left;
        }
        return false;
    }
}
