package tree;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2020/12/29
 */
public class TestBuildTree106 extends TestCase {

    private BuildTree106 buildTree = new BuildTree106();

    public void test1() {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        TreeCommonUtils.postOrderTraverseByRecursive(root);
    }
}
