package tree;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class SearchBST700 {
    /**
     * @param root 二叉树根节点
     * @param val  搜索值
     * @return 值对应的子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.val > val) {
                curNode = curNode.left;
            } else if (curNode.val < val) {
                curNode = curNode.right;
            } else {
                return curNode;
            }
        }
        return null;
    }
}
