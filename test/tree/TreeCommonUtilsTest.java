package tree;

import org.junit.Before;
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
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(7);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(15);
        TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(9);
        TreeCommonUtils.TreeNode node5 = new TreeCommonUtils.TreeNode(20);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        commonUtils.postOrderTraverseByStack(node1);
    }

    @Test
    public void testInOrderTraverseByStackOutList() {
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(4);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(2);
        TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        List<Integer> result = commonUtils.inOrderTraverseByStackOutList(node1);
        result.forEach(System.out::println);
    }

    @Test
    public void testPreOrderTraverseByStackOutList() {
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(4);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(2);
        TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        List<Integer> result = commonUtils.preOrderTraverseByStackOutList(node1);
        result.forEach(System.out::println);
    }

    @Test
    public void testPreOrderTraverseByRecursive() {
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(4);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(2);
        TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        commonUtils.preOrderTraverseByRecursive(node1);
    }
}
