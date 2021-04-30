package tree;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2021/04/30
 */
public class TrimBST669Test extends TestCase {

    private TrimBST669 trim = new TrimBST669();

    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);

        trim.trimBST(root, 1, 2);
    }
}
