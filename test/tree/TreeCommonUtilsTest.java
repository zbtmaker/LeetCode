package tree;

import org.junit.Test;

import java.util.List;

/**
 * 二叉树公共工具类
 *
 * @author baitao zou
 * date 2020/01/18
 */
public class TreeCommonUtilsTest {
    private TreeCommonUtils commonUtils = new TreeCommonUtils();

    @Test
    public void testPostOrderTraverseByStack() {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        commonUtils.postOrderTraverseByStack(node1);
    }

    @Test
    public void testInOrderTraverseByStackOutList() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        List<Integer> result = commonUtils.inOrderTraverseByStackOutList(node1);
        result.forEach(System.out::println);
    }

    @Test
    public void testPreOrderTraverseByStackOutList() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        List<Integer> result = commonUtils.preOrderTraverseByStackOutList(node1);
        result.forEach(System.out::println);
    }

    @Test
    public void testPreOrderTraverseByRecursive() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        commonUtils.preOrderTraverseByRecursive(node1);
    }
}
