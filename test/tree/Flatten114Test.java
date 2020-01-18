package tree;

import org.junit.Test;

public class Flatten114Test {
    private Flatten114 flatten114 = new Flatten114();
    @Test
    public void test1(){
        Flatten114.TreeNode node1 = new Flatten114.TreeNode(1);
        Flatten114.TreeNode node2 = new Flatten114.TreeNode(2);
        Flatten114.TreeNode node3 = new Flatten114.TreeNode(5);
        Flatten114.TreeNode node4 = new Flatten114.TreeNode(3);
        Flatten114.TreeNode node5 = new Flatten114.TreeNode(4);
        Flatten114.TreeNode node6 = new Flatten114.TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }

    @Test
    public void test2(){
        Flatten114.TreeNode node1 = new Flatten114.TreeNode(1);
        Flatten114.TreeNode node2 = new Flatten114.TreeNode(2);

        node1.left = node2;

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }

    @Test
    public void test3(){
        Flatten114.TreeNode node1 = new Flatten114.TreeNode(1);

        flatten114.flatten(node1);
        flatten114.preOrderTraverseByRecursive(node1);
    }
}
