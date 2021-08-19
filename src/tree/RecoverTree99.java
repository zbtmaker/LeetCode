package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class RecoverTree99 {

    /**
     * plan1：这个题目一开始想的是采用中序遍历的方式实现二叉树的重建方案，最终需要的是修改二叉树的节点值，所以我们在存储的时候
     * 就需要存储节点，而不是节点的值。
     *
     * @param root 二叉树根节点
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTreeByInOrder(root);
    }

    /**
     * 采用二叉搜索树中序遍历方式实现的方式，我们time complexity O(N^2),space complexity O(N)。此方法的空间复杂度是不可能优化了。
     * 但是我们的空间复杂度还是可以继续优化的。
     *
     * @param root 二叉搜索树
     */
    private void recoverTreeByInOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                TreeNode node2 = list.get(j);
                if (node1.val > node2.val) {
                    node1.val = node1.val ^ node2.val;
                    node2.val = node1.val ^ node2.val;
                    node1.val = node1.val ^ node2.val;
                }
            }
        }

    }

    /**
     * 中序遍历将二叉搜索树有序的保存到集合中
     *
     * @param root 二叉搜索树根节点
     * @param list 集合
     */
    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
