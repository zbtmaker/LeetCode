package tree;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2020/12/29
 */
public class TestPathSum113 extends TestCase {

    private PathSum113 pathSum = new PathSum113();

    public void test1() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;
        node7.right = new TreeNode(5);

        List<List<Integer>> lists = new PathSum113().pathSum(root, 22);
        print(lists);
        Assert.assertEquals(lists.size(), 2);
    }

    private void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(lists.toString());
        }
    }
}
