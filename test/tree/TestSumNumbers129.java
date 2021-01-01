package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/01
 */
public class TestSumNumbers129 extends TestCase {

    private SumNumbers129 sumNumbers = new SumNumbers129();

    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = sumNumbers.sumNumbers(root);
        Assert.assertEquals(result, 25);
    }
}
