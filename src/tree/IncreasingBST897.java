package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class IncreasingBST897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        root = list.get(0);

        TreeNode curNode = root;
        for (int i = 1; i < list.size(); i++) {
            curNode.right = list.get(i);
            curNode.left = null;
            curNode = curNode.right;
            if (i == list.size() - 1) {
                curNode.left = null;
                curNode.right = null;
            }

        }
        return root;
    }

    private void inorder(TreeNode curNode, List<TreeNode> list) {
        if (curNode == null) {
            return;
        }
        inorder(curNode.left, list);
        list.add(curNode);
        inorder(curNode.right, list);
    }
}
