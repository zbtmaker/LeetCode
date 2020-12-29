package tree;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2020/12/29
 */
public class TestBuildTree105 extends TestCase {
    private BuildTree105 build = new BuildTree105();

    public void test1() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = build.buildTree(preorder, inorder);
        TreeCommonUtils.inOrderTraverseByRecursive(root);
    }
}
