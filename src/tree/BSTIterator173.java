package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/26
 */
public class BSTIterator173 {
    private LinkedList<Integer> list;

    /**
     * 这个题目要求每次调用next方法时，都输出二叉树中最小的元素。这个
     * 就是中序遍历的表述，而且每次调用next和hasNext方法的时间复杂度
     * 为O(1)。那么我们就需要在构造方法时采用中序遍历的方式遍历二叉树。
     * <p>
     * 根据这个描述就是
     *
     * @param root
     */
    public BSTIterator173(TreeNode root) {
        list = new LinkedList<>();
        if (root == null) {
            return;
        }
        inOrderRecursive(root, list);
    }

    private void inOrderStack(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }
    }

    /**
     * 中序遍历：递归版本
     *
     * @param root
     * @param list
     */
    private void inOrderRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left, list);
        list.add(root.val);
        inOrderRecursive(root.right, list);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.removeFirst();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
