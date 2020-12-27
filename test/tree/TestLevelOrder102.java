package tree;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class TestLevelOrder102 extends TestCase {

    private LevelOrder102 levelOrder = new LevelOrder102();

    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> result = levelOrder.levelOrder(root);
        print(result);
    }

    private void print(List<List<Integer>> result) {
        for (List<Integer> cur : result) {
            System.out.println(cur.toString());
        }
    }
}
