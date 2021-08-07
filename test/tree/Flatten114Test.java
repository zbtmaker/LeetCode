package tree;

import org.junit.Test;

public class Flatten114Test {
    private Flatten114 flatten114 = new Flatten114();

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }

    @Test
    public void test3() {
        TreeNode node1 = new TreeNode(1);

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }
}
