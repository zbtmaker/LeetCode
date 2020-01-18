package tree;

import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树公共工具类
 *
 * @author baitao zou
 * date 2020/01/18
 */
public class TreeCommonUtilsTest {
    private TreeCommonUtils commonUtils = new TreeCommonUtils();

    private TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(1);
    private TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(2);
    private TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(5);
    private TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(3);
    private TreeCommonUtils.TreeNode node5 = new TreeCommonUtils.TreeNode(4);
    private TreeCommonUtils.TreeNode node6 = new TreeCommonUtils.TreeNode(6);

    @Before
    public void before() {
        node1.left = node2;
        node2.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
    }

    @Test
    public void testPostOrderTraverseByStack() {
        commonUtils.postOrderTraverseByStack(node1);
    }
}
