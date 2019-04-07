package Tree;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class diameterOfBinaryTree543 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(-7);
        TreeNode node2 = new TreeNode(-3);
        //root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(-9);
        TreeNode node4 = new TreeNode(-3);
        node2.left = node3;
        node2.right = node4;

        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(-7);
        node3.left = node5;
        node3.right = node6;

        TreeNode node7 = new TreeNode(-4);
        node4.left = node7;

        TreeNode node8 = new TreeNode(6);
        node5.left = node8;

        int num = new diameterOfBinaryTree543().diameterOfBinaryTree(root);

        System.out.println(num);
    }
    /**
     * 这个题目和树的最大深度是一类题，其实就是动态规划的题，当前树的diameter等于左子树的maxDepth和右子树的
     * diameter(root)= F{maxDepth(root.left),root.left != null} + F{maxDepth(root.right),root.right!=null}
     *
     * 。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
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

    private int maxDepth(TreeNode curNode) {
        if(curNode == null){
            return 0;
        }
        return Math.max(maxDepth(curNode.left),maxDepth(curNode.right))+1;
    }
}
