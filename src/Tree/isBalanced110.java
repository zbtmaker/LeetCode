package Tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class isBalanced110 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node2.left = node3;
        node2.right = node4;

        TreeNode node5 = new TreeNode(6);
        node3.left = node5;

        System.out.println(new isBalanced110().isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {

        boolean[] flag = new boolean[]{true};
        recurIsBalanced(root,flag,0);
        return flag[0];
    }

    /**
     * 思路：之前我将问题看成是一个动态规划，确实也可以用动态规划的思想去做这个题，
     * 也就是说，如果一棵树的左子树或者右子树返回false，那么当前节点就应该为false。
     * 这个题目可以说是maxDepth的改善题。因此和<>isBalanced110</>那个题目是一样的，
     * 虽然我们需要返回这个题目是否平衡，但是我们递归的返回值不一定就是这颗树是否
     * 是平衡的（也就是true/false)。所以我需要递归的求解每一个节点的深度，然后就
     * 判断这个节点是否是平衡的，我使用了一个boolean[] flag = new boolean[]{true};
     * 一旦某一个节点不平衡，那么我们将flag的值赋值为false，如果节点平衡，那么flag
     * 的值不需要改变。
     * @param curNode
     * @return
     */
    private int recurIsBalanced(TreeNode curNode,boolean[] flag,int depth){
        if(curNode == null){
            return 0;
        }

        int leftDepth = recurIsBalanced(curNode.left,flag,depth);
        int rightDepth = recurIsBalanced(curNode.right,flag,depth);

        if(Math.abs(leftDepth - rightDepth)>1){
            flag[0] = false;
        }
        depth = Math.max(leftDepth,rightDepth)+1;
        return depth;
    }
}
