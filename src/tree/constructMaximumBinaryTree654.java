package tree;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class constructMaximumBinaryTree654 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        int[] nums = null;//new int[]{3,2,1,6,0,5};
        TreeNode root = new constructMaximumBinaryTree654().constructMaximumBinaryTree(nums);

    }

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return recurConstruct(nums,0,nums.length-1);
    }
    public TreeNode recurConstruct(int[] nums,int left,int right){
        //halting rule
        if(left>right){
            return null;
        }
        int root_val = Integer.MIN_VALUE;
        int root_index = -1;
        int i = left;
        for(;i<=right;i++){
            if(root_val<nums[i]){
                root_val = nums[i];
                root_index = i;
            }
        }
        TreeNode root = new TreeNode(root_val);
        root.left = recurConstruct(nums,left,root_index - 1);
        root.right = recurConstruct(nums,root_index + 1,right);
        return root;
    }
}
