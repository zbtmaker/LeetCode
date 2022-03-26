package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/26
 */
public class FindTarget653Test extends TestCase {

    private final FindTarget653 find = new FindTarget653();

    public void test1() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        node2.right = new TreeNode(7);

        Assert.assertFalse(find.findTarget(root, 28));
    }
}
