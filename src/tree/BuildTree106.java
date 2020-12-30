package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class BuildTree106 {

    /**
     * 这个题目和BuildTree105这个题目很像的一点就是都用到了中序遍历数组，中序遍历数组的用处在于一旦
     * 确定了二叉树的根节点的位置，那么就确定了左子树和右子树的大小，从而能够确定下一步递归的范式。
     * 假如我们inorder的左边为inLeft = 0, inRight = inorder.length - 1; postorder的
     * 左边为postLeft = 0, postRight = postorder.length - 1。在inorder数组中找到
     * postorder[postRight]的位置inRootIndex就是二叉树的根节点的值。那么这是时候对于inorder来说，
     * 左子树的范围就是inLeft ~ inRootIndex - 1, 右子树的范围就是 inRootIndex + 1 ~ inRight.
     * 对于postorder的左子树范围就是postLeft ~ postRight - (inRight - inRootIndex) - 1,
     * 右子树的范围就是 postRight - (inRight - inRootIndex) ~ postRight - 1
     *
     * @param inorder   中序遍历数组
     * @param postorder 后续遍历数组
     * @return 二叉树根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null
                || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueMapIndex = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            valueMapIndex.put(inorder[i], i);
        }
        return recurBuildTree(postorder, postorder.length - 1, 0, inorder.length - 1, valueMapIndex);
    }

    private TreeNode recurBuildTree(int[] postorder, int postRight, int inLeft, int inRight, Map<Integer, Integer> valueMapIndex) {
        if (inLeft > inRight) {
            return null;
        }
        int inRootIndex = valueMapIndex.get(postorder[postRight]);
        TreeNode root = new TreeNode(postorder[postRight]);

        int rightSize = inRight - inRootIndex;
        root.left = recurBuildTree(postorder, postRight - rightSize - 1, inLeft, inRootIndex - 1, valueMapIndex);

        root.right = recurBuildTree(postorder, postRight - 1, inRootIndex + 1, inRight, valueMapIndex);
        return root;
    }
}
