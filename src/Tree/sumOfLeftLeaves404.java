package Tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class sumOfLeftLeaves404 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;



        System.out.println(new sumOfLeftLeaves404().sumOfLeftLeaves(root));

    }

    /**
     * 此方法返回所有左子叶子节点的和，对于一个叶子节点leafNode，器左子节点leftNode.left ==null，
     * 而且右子节点leftNode.right == null。我们用sum表示所有左叶子节点的和，初始值sum = 0，
     * 同时只有这个节点是其parentNode的left节点时，那么这个时候我们才执行sum += leafNode.val;
     * 因此根据上面的描述就可以确定一个递归算法的halting condition。对于任意一个节点我们都可以
     * 看成是一个颗树，如果存在左节点，那么向左边递归，如果存在右节点，那么向右边递归。另外需要注意的
     * 是sum是一个栈变量，而不是堆变量，因此是将此sum的值传递给递归方法，所以我们每次返回的时候需要将
     * 运算结果返回给sum。
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        return recurSumOfLeftLeaves(root,0,0);
    }

    public int recurSumOfLeftLeaves(TreeNode curNode,int sum,int flag){
        if(curNode.left == null && curNode.right == null && flag == -1){
            sum += curNode.val;
            return sum;
        }

        if(curNode.left != null){

            sum = recurSumOfLeftLeaves(curNode.left,sum,-1);
        }

        if(curNode.right != null){
            sum = recurSumOfLeftLeaves(curNode.right,sum,1);
        }

        return sum;
    }

    /**
     * 此方法返回的树中所有左节点之和。并不是左叶子节点之和
     * @param root
     * @return
     */
    public int sumOfLeftLeavesII(TreeNode root) {

        return recurSumOfLeftLeavesII(root,0);
    }

    /**
     * 此方法返回的最节点之和。并不是左叶子节点之和
     * @param curNode
     * @param sum
     * @return
     */
    public int recurSumOfLeftLeavesII(TreeNode curNode,int sum){
        if(curNode == null){
            return sum;
        }

        if(curNode.left != null){
            sum += curNode.left.val;

            sum = recurSumOfLeftLeavesII(curNode.left,sum);
        }

        if(curNode.right != null){
            sum = recurSumOfLeftLeavesII(curNode.right,sum);
        }

        return sum;
    }
}
