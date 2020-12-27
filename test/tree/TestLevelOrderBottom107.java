package tree;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2020/12/10
 */
public class TestLevelOrderBottom107 extends TestCase {

    private LevelOrderBottom107 levelOrder = new LevelOrderBottom107();

    public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node3.left = node5;
        node3.right = node6;

        List<List<Integer>> lists = levelOrder.levelOrderBottom(root);
        print(lists);
    }

    private void print(List<List<Integer>> result) {
        for (List<Integer> cur : result) {
            System.out.println(cur.toString());
        }
    }
}
