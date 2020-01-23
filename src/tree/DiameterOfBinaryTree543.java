package tree;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class DiameterOfBinaryTree543 {


    /**
     * 这个题目和树的最大深度是一类题，其实就是动态规划的题，当前树的diameter等于左子树的maxDepth和右子树的
     * diameter(root)= F{maxDepth(root.left),root.left != null} + F{maxDepth(root.right),root.right!=null}
     *
     * 。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeCommonUtils.TreeNode root) {
        int sum = 0;
        if(root == null){
            return sum;
        }

        if(root.left != null){
            sum += maxDepth(root.left);
        }

        if(root.right != null){
            sum += maxDepth(root.right);
        }
        return sum;
    }

    private int maxDepth(TreeCommonUtils.TreeNode curNode) {
        if(curNode == null){
            return 0;
        }
        return Math.max(maxDepth(curNode.left),maxDepth(curNode.right))+1;
    }
}
