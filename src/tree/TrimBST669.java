package tree;

/**
 * @author Baitao zou
 * date 2019\2\23 0023.
 */
public class TrimBST669 {

    /**
     * 这个题目最好的方式是使用递归的方法，对于一个搜索二叉树，每一个节点curNode.left.val<curNode.val<curNode.right.val
     * 满足这个条件，因此如果一个节点curNode.val<L，那么当前节点curNode的所有左边节点都要删除(curNode.left == null)，同时
     * 我们将当前节点的curNode的right节点置为当前节点(curNode = curNode.right)，这样操作了之后还需要判断当前修改的curNode是否
     * 需要删除，因此应该将当前节点进一步递归并将递归结果置为当前节点。同理，如果curNode.val>R，那么当前节点curNode的所有右边节点
     * 都要删除；如果L<=curNode<=R，那么就进一步左右两边递归，然后将递归结果返回作为当前节点的左右节点。
     *
     * @param root 二叉树根节点
     * @param low  左边范围
     * @param high 右边范围
     * @return 裁剪后的二叉树
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            root.left = null;
            root = root.right;
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            root.right = null;
            root = root.left;
            root = trimBST(root, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
