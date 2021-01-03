package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/26
 */
public class InorderTraversal94 {
    /**
     * @param root 二叉树根节点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
