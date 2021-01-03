package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class RightSideView199 {

    private List<Integer> rightViews = new LinkedList<>();

    private int level = -1;

    /**
     * 层次遍历方法，采用程序中的栈和JVM的调用栈实现
     *
     * @param root 二叉树根节点
     * @return 右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideViewByRecur(root);
    }

    /**
     * @param root 二叉树根节点
     * @return 右视图
     */
    private List<Integer> rightSideByStack(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        int levelNum = 1;
        TreeNode curNode = root;
        queue.add(curNode);

        while (!queue.isEmpty()) {
            int tmpLevelNum = 0;
            for (int i = 0; i < levelNum; i++) {
                curNode = queue.removeFirst();
                if (i == levelNum - 1) {
                    list.add(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    tmpLevelNum++;
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    tmpLevelNum++;
                }
            }

            levelNum = tmpLevelNum;
        }
        return list;
    }

    /**
     * @param root 二叉树根节点
     * @return 右视图
     */
    private List<Integer> rightSideViewByRecur(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recur(Collections.singletonList(root), result);
        return result;
    }

    private void recur(List<TreeNode> treeNodes, List<Integer> result) {
        if (treeNodes == null || treeNodes.size() == 0) {
            return;
        }
        int i = 0;
        List<TreeNode> nextNodes = new LinkedList<>();
        for (TreeNode treeNode : treeNodes) {
            if (i == treeNodes.size() - 1) {
                result.add(treeNode.val);
            }
            if (treeNode.left != null) {
                nextNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextNodes.add(treeNode.right);
            }
            i++;
        }
        recur(nextNodes, result);
    }

    /**
     * 时间复杂度O(N)，空间复杂度O(1)
     *
     * @param root 二叉树根节点
     * @return 右视图数组
     */
    public List<Integer> rightSideViewByRecurII(TreeNode root) {
        inorder(root, 0);
        return this.rightViews;
    }

    /**
     * 中序遍历，root，right，left顺序，如果是当前行的第一个元素，那么就添加到数组中，直接遍历
     *
     * @param root     子树根节点
     * @param curLevel 当前行数
     */
    private void inorder(TreeNode root, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel > level) {
            this.level = curLevel;
            rightViews.add(root.val);
        }

        inorder(root.right, curLevel + 1);
        inorder(root.left, curLevel + 1);
    }
}
