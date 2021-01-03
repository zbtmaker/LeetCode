package tree;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class InvertTree226 {
    /**
     * 借助中序遍历思想解决问题
     * 对于一个二叉树的翻转，每一个节点可以看做是以该节点的为根的一个子树，那么翻转当前节点和子节点
     * 的操作是一样的。其实这个问题和动态规划的自顶向下的思想一样，对于每一个节点都有一个范式：那就是
     * 首先将当前节点的两个子节点进行交换，然后调用recurInvertTree(node.right)和recurInvertTree(node.left)。
     * 我们可以将每一个节点的左右子树看成是一个节点，然后每次遍历到下一个子树的根节点的时候就需要将这个子树进行翻转。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        recurInvertTree(root);
        return root;
    }

    private void recurInvertTree(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        TreeNode tmpNode = curNode.left;
        curNode.left = curNode.right;
        curNode.right = tmpNode;

        recurInvertTree(curNode.left);
        recurInvertTree(curNode.right);
    }
}
