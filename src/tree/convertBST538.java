package tree;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class convertBST538 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
/*
    public static void main(string[] args){
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        convertBST538 newTree = new convertBST538();
        TreeNode root = newTree.sortedArrayToBST(nums);

        newTree.convertBST(root);

        newTree.reverseInorder(root);
    }
    */
    /**
     * 主要思路，利用二叉树的中序遍历，但是之前的中序遍历的方式是左-中-右，现在我们将顺序改为左中右，同时
     * 我们利用递归的方法好像行不通了，那么我们就需要改编中序遍历并借助堆栈实现。
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        int sum = 0;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.right;
            }else{
                curNode = stack.pop();
                curNode.val = curNode.val +sum;
                sum = curNode.val;
                curNode = curNode.left;
            }
        }
        return root;
    }

    /**
     * 这里实现了一个二叉树的翻转的中序遍历，其中遍历的顺序是：右->中->左。这样就可以实现了
     * 输出一个由大大小的逆序的数组，也可以帮助我们实现上面需要的累加的功能。
     * @param root
     */
    private void reverseInorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;

        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.right;
            }else{
                curNode = stack.pop();
                System.out.println(curNode.val);
                curNode = curNode.left;
            }
        }
    }

    /*//这两个方法主要是用于构造一个二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return recurSortedArrayToBST(nums,0,nums.length-1);
    }



    private TreeNode recurSortedArrayToBST(int[] nums,int left,int right){
        //halting rule
        if(left > right){
            return null;
        }
        int middle = (left + right)>>1;
        TreeNode node = new TreeNode(nums[middle]);

        node.left = recurSortedArrayToBST(nums,left,middle - 1);
        node.right = recurSortedArrayToBST(nums,middle + 1,right);

        return node;
    }*/
}
