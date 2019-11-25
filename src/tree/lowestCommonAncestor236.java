package tree;

import org.junit.Test;

public class lowestCommonAncestor236 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    @Test
    public void test1(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(4);
        node4.left = node5;
        node4.right = node6;

        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node2.left = node7;
        node2.right = node8;

        TreeNode c = new lowestCommonAncestor236().lowestCommonAncestor(root,node6,node1);
        System.out.println(c.val);
    }
    @Test
    public void test2(){
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(-4);
        node1.left = node3;
        node1.right = node4;


        TreeNode node6 = new TreeNode(8);
        node3.left = node6;


        TreeNode c = new lowestCommonAncestor236().lowestCommonAncestor(root,node6,node2);
        System.out.println(c.val);
    }
    /**
     * 解题思路：递归大法好，如果一个节点的左子树返回true，
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] c = new TreeNode[1];
        recurCommonAncestor(root,p,q,c);
        return c[0];
    }
    public boolean recurCommonAncestor(TreeNode root,TreeNode p,TreeNode q,TreeNode[] c){
        if(root == null){
            return false;
        }
        if(c[0] != null){
            return true;
        }
        boolean rootFlag = false;
        if(root.val == p.val || root.val == q.val){
            rootFlag = true;
        }

        boolean leftFlag = false;
        if(recurCommonAncestor(root.left,p,q,c)){
            leftFlag = true;
            if(rootFlag && null == c[0]){
                c[0] = root;
                return true;
            }

        }

        boolean rightFlag = false;
        if(recurCommonAncestor(root.right,p,q,c)){
            rightFlag = true;
            if(rootFlag && null == c[0]){
                c[0] = root;
                return true;
            }

        }

        if(rightFlag && leftFlag){
            if(c[0] == null){
                c[0] = root;
                return true;
            }

        }
        if(rootFlag || rightFlag ||leftFlag){
            return true;
        }
        return false;
    }

}
