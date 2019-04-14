package BackTracking;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
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
    @Test
    public void test2(){
        generateTrees95 gen = new generateTrees95();
        List<TreeNode> result = gen.generateTreesII(3);
        for(TreeNode root : result){
            inorder(root);
            System.out.println("");
        }


    }
    /**
     * 采用回溯的方式来解决问题，之前一直没有想好怎么解决这个问题，主要是受上一个题目中的
     * 动态规划思想的影响，这一题其实也涉及到了一些重复计算，像哪些呢，只有一些一些节点的
     * 1,2,3,4,5,这个题目中，整个算法中，我们重复计算了一些节点的左子树和右子树。
     * 当1为左子树的时候，我们发现此时2的右子树会计算一次，当2为root的时候，此时又会递归的
     * 计算一次2的右子树，同时，对于3来说，我们在计算3的时候，会发现，在计算以1,2位root的时候，
     * 3的右子树会重复的递归两次，而在以4,5为root的时候，3的左子树又会重复的递归多次，因此我们的
     * 每一个节点的左子树和右子树会重复的被计算。
     * 既然找到了这个源头，那么应该如何解决这个重复计算问题
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

    public List<TreeNode> generateTreesII(int n) {
        if(n < 1){
            return new LinkedList<TreeNode>();
        }
        List<List<TreeNode>> leftTrees = new ArrayList<>();
        List<List<TreeNode>> rightTrees = new ArrayList<>();
        initial(leftTrees,n);
        initial(rightTrees,n);
        return recurGenerateTreesII(1,n,leftTrees,rightTrees);
    }


    private List<TreeNode> recurGenerateTreesII(int left,int right,List<List<TreeNode>> leftTrees,
                                              List<List<TreeNode>> rightTrees){
        if(left > right){
            return null;
        }
        int constLeft = 1;
        int constRight = leftTrees.size();
        List<TreeNode> result = new LinkedList<>();
        for(int i = left;i <= right;i++){
            List<TreeNode> leftTreeList = null;
            List<TreeNode> rightTreeList = null;
            if(left == constLeft){
                if(leftTrees.get(i-1).size() == 0){
                    leftTreeList = recurGenerateTreesII(left, i - 1,leftTrees,rightTrees);
                    if(leftTreeList != null){
                        leftTrees.set(i - 1,leftTreeList);
                    }

                }else{
                    leftTreeList = leftTrees.get(i - 1);
                }
            }else{
                leftTreeList = recurGenerateTreesII(left, i - 1,leftTrees,rightTrees);
            }

            if(right == constRight){
                if(rightTrees.get(i - 1).size() == 0){
                    rightTreeList = recurGenerateTreesII(i + 1,right,leftTrees,rightTrees);
                    if(rightTreeList != null){
                        rightTrees.set(i - 1,rightTreeList);
                    }

                }else{
                    rightTreeList = rightTrees.get(i - 1);
                }
            }else{
                rightTreeList = recurGenerateTreesII(i + 1,right,leftTrees,rightTrees);
            }

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

    private void initial(List<List<TreeNode>> treeList,int n){
        for(int i = 0;i < n;i++){
            treeList.add(new ArrayList<>());
        }
    }


}
