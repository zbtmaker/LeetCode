package tree;

/**
 * @author Baitao zou
 * date 2019/3/22 0022
 */
public class BstFromPreorder1008 {

    /**
     * 这个题目的主要思想就是使用前序遍历来构造一个二叉搜索树，那么对于
     * 一个二叉搜索树，我们知道以根节点为比较基准点，小于root.val的都是
     * 左子树，而大于root.val的都是右子树。因此我们就可以按照这样一种方式进行递归
     * 最终得到我们的二叉搜索树
     *
     * @param preorder 二叉树前序遍历数组
     * @return 二叉树
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        return recurConstructTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode recurConstructTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int i = left;
        for (; i <= right; i++) {
            if (preorder[i] > preorder[left]) {
                break;
            }
        }
        root.left = recurConstructTree(preorder, left + 1, i - 1);
        root.right = recurConstructTree(preorder, i, right);
        return root;
    }
}
