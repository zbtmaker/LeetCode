package Tree;

import java.util.List;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class insertIntoBST701 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;

        new insertIntoBST701().insertIntoBSTI(root,5);

    }
    /**
     * 这是递归的改进版本
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBSTI(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left =  insertIntoBSTI(root.left,val);
        }
        if(root.val < val){
            root.right =  insertIntoBSTI(root.right,val);
        }
        return root;
    }

    /**
     * 这是递归的第一版
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBSTII(TreeNode root, int val) {
        return recurInsertIntoBST(root,val);
    }
    private TreeNode recurInsertIntoBST(TreeNode curNode,int val){
        if(curNode == null){
            return new TreeNode(val);
        }
        if(curNode.val > val){
            curNode.left = recurInsertIntoBST(curNode.left,val);
        }
        if(curNode.val < val){
            curNode.right = recurInsertIntoBST(curNode.right,val);
        }
        return curNode;
    }

    /**
     * 这是循环的版本
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBSTIII(TreeNode root, int val) {
        return root;
    }

}
