package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class increasingBST897 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node4;
        node1.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;

        new increasingBST897().increasingBST(root);
        //System.out.println();
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return root;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorder(root,list);

        root = list.get(0);

        TreeNode curNode = root;
        for(int i = 1;i<list.size();i++){
            curNode.right = list.get(i);
            curNode.left = null;
            curNode = curNode.right;
            if(i == list.size()-1){

                curNode.left = null;
                curNode.right = null;
            }

        }

        return root;
    }

    private void inorder(TreeNode curNode,List<TreeNode> list){
        if(curNode == null){
            return;
        }
        inorder(curNode.left,list);
        list.add(curNode);
        inorder(curNode.right,list);
    }
}
