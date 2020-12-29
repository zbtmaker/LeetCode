package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class BuildTree105 {
    /**
     * 递归大法好，首先写出root向下递归的，
     * 第一步：由前序数组中的第一个元素找到二叉树的root节点，
     * 第二步：根据前序数组中找到的root节点值，在中序遍历中找到其位置index，那么0-index-1就是二叉树的左子树，而index + 1～inorder.length-1
     * 就是二叉树的左子树
     * 第三步，上面的每一步操作可以作为递归的范式，每次都是这么操作的
     * 第四步：递归结束条件
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 二叉树
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueMapIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMapIndex.put(inorder[i], i);
        }
        return recurBuildTree(preorder, 0, 0, inorder.length - 1, valueMapIndex);
    }

    private TreeNode recurBuildTree(int[] preorder, int preLeft, int inLeft, int inRight, Map<Integer, Integer> valueIndexMap) {
        if (inLeft > inRight) {
            return null;
        }

        int inRootIndex = valueIndexMap.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);

        int leftSize = inRootIndex - inLeft;

        root.left = recurBuildTree(preorder, preLeft + 1, inLeft, inRootIndex - 1, valueIndexMap);

        root.right = recurBuildTree(preorder, preLeft + leftSize + 1, inRootIndex + 1, inRight, valueIndexMap);
        return root;
    }
}
