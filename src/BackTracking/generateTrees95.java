package BackTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\4\7 0007.
 */
public class generateTrees95 {
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
        generateTrees95 gen = new generateTrees95();
        List<TreeNode> result = gen.generateTrees(3);
        for(TreeNode root : result){
            inorder(root);
            System.out.println("");
        }
    }
    /**
     * 采用回溯的方式来解决问题，之前一直没有想好怎么解决这个问题，主要是受
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new LinkedList<TreeNode>();
        }
        return recurGenerateTrees(1,n);
    }

    private List<TreeNode> recurGenerateTrees(int left,int right){
        if(left > right){
            return null;
        }
        List<TreeNode> result = new LinkedList<>();
        for(int i = left;i <= right;i++){
            List<TreeNode> leftTreeList = recurGenerateTrees(left, i - 1);
            List<TreeNode> rightTreeList = recurGenerateTrees(i + 1,right);
            if(null == leftTreeList && null == rightTreeList){
                result.add(new TreeNode(i));
            }else if(null == leftTreeList){
                for(int j = 0;j<rightTreeList.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.right = rightTreeList.get(j);
                    result.add(root);
                }
            }else if(null == rightTreeList){
                for(int j = 0;j < leftTreeList.size();j ++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeList.get(j);
                    result.add(root);
                }
            }else{
                for(int j = 0;j < leftTreeList.size();j++){
                    for(int k = 0;k < rightTreeList.size();k ++){
                        TreeNode root = new TreeNode(i);
                        root.left = leftTreeList.get(j);
                        root.right = rightTreeList.get(k);
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + "->");
        inorder(root.right);
    }
}
