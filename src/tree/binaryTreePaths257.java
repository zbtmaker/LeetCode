package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class binaryTreePaths257 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        /*TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node4;
        node1.right = node5;

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;*/
        TreeNode root = new TreeNode(37);
        TreeNode node1 = new TreeNode(-34);
        TreeNode node2 = new TreeNode(-48);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(-100);
        node1.right = node3;

        TreeNode node4 = new TreeNode(-100);
        TreeNode node5 = new TreeNode(48);;

        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(-54);
        node5.right = node6;

        TreeNode node7 = new TreeNode(-71);
        TreeNode node8 = new TreeNode(-22);
        node6.left = node7;
        node6.right = node8;

        TreeNode node9 = new TreeNode(8);
        node8.right = node9;

        System.out.println(new binaryTreePaths257().binaryTreePaths(root));
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return result;
        }
        list.add(root.val);
        recurBinaryTreePaths(root,list,result);
        return result;
    }
    private void recurBinaryTreePaths(TreeNode curNode,List<Integer> list,List<String> result){
        if(curNode.left == null && curNode.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<list.size();i++){
                if(i == list.size()-1){
                    sb.append(list.get(i));
                }else{
                    sb.append(list.get(i)).append("->");
                }
            }
            result.add(sb.toString());
            return;
        }

        if(curNode.left != null) {
            list.add(curNode.left.val);
            recurBinaryTreePaths(curNode.left, list, result);
            list.remove(list.size() - 1);
        }
        if(curNode.right != null){
            list.add(curNode.right.val);
            recurBinaryTreePaths(curNode.right,list,result);
            list.remove(list.size() - 1);
        }
    }
}
