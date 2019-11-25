package tree;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class hasPathSum112 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        //TreeNode root = null;
        TreeNode root = new TreeNode(-2);
        //TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(-3);
        //root.left = node1;
        root.right = node2;
        /*TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(1);
        node7.right = node8;*/

        System.out.println(new hasPathSum112().hasPathSum(root,-5));
    }
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null){
            return false;
        }
        return recurHasPathSum(root,target,root.val);
    }

    /**
     *
     * @param curNode
     * @param target
     * @param sum
     * @return
     */
    private boolean recurHasPathSum(TreeNode curNode,int target,int sum){
        if(curNode.left == null && curNode.right == null
                && sum == target){
            return true;
        }/*else if(sum > target){
            return false;
        }*/else{
            if(curNode.left != null){
                sum += curNode.left.val;
                if(recurHasPathSum(curNode.left,target,sum)){
                    return true;
                }
                sum -= curNode.left.val;
            }

            if(curNode.right != null){
                sum += curNode.right.val;
                if(recurHasPathSum(curNode.right,target,sum)){
                    return true;
                }
                sum -= curNode.right.val;
            }
        }
        return false;
    }
}
