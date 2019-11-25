package tree;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class searchBST700 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curNode = root;
        while(curNode != null){
            if(curNode.val > val){
                curNode = curNode.left;
            }else if(curNode.val <val){
                curNode = curNode.right;
            }else{
                return curNode;
            }
        }
        return null;
    }
}
