package backtracking;

import org.junit.Test;

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
        List<TreeNode> result = gen.generateTreesII(5);
        for(TreeNode root : result){
            inorder(root);
            System.out.println("");
        }
    }
    /**
     * 采用回溯的方式来解决问题，之前一直没有想好怎么解决这个问题。我们在实现这个问题时，
     * 对于例子1,2,3,4,5,这个问题来说，当1为整个tree的root时，此时就会出现2,3,4,5作为
     * 子树，因此我们需要返回2,3,4,5这几个数字组成的所有的子树排列，因此这里就可以确定
     * 我们的递归的方法返回的是一个List<TreeNode>，然后需要确定2作为root的List<TreeNode>
     * 以及3、4、5作为root的一个List<TreeNode>，这样一来我们将这些链表组合在一块就得到了
     * 1作为root的下面所有子树的可能性，然后可以通过遍历的方式实现了。这里还有一个问题上面
     * 以1为root的树只有右子树，不存在左子树。而以5为root的树只有左子树，不存在右子树
     * 因此我们需要判断一下条件再进行遍历和组合操作
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

    /**
     * 这里我将问题进一步分析后将上面的代码进行了改进，就是我的代码中出现了重复
     * 递归的问题，那么为了解决这个问题。想到了由回溯->动态规划的方案，将每个节点
     * 的左子树和右子树进行记录，这样一来，就不用计算多次。具体改进代码如下：
     * @param n
     * @return
     */
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
