package tree;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class RecoverTree99Test extends TestCase {

    public void test1() {
        RecoverTree99 recover = new RecoverTree99();
        RecoverTree99.TreeNode node1 = new RecoverTree99.TreeNode(1);
        RecoverTree99.TreeNode node2 = new RecoverTree99.TreeNode(3);
        RecoverTree99.TreeNode node3 = new RecoverTree99.TreeNode(2);
        node1.left = node2;
        node2.right = node3;
        recover.recoverTree(node1);
    }
}
