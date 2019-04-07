package Tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class findTilt563 {
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
        /*TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        /*node1.left = node4;
        node1.right = node5;

        /*TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;*/


        System.out.println(new findTilt563().findTilt(root));
    }

    /**
     * 这个题目的难点一直在我执着于题目需要我们返回坡度和，所以我就一直要返回一个坡度和。但是我们
     * 需要求每一个节点并以该节点为根的子树的和，然后将左子树和与右子树和差的绝对值作为这个节点的坡度
     * 所以我将坡度和定义为一个堆变量（随着主函数的结束而结束，而不是main函数），这样就可以作为一个
     * 全局变量。我们每次返回的都是当前节点的子树和，这样就可以使用子树和来实现坡度和的方案。可以借助
     * 这个题目好好理解一下Java中的虚拟机栈以及Java虚拟机的内存。
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        int[] sumTilt = new int[]{0};
        recurTilt(root,sumTilt,0);
        return sumTilt[0];
    }

    /**
     * 这个其实就是子树和的递归方案，只不过多了一个sumTilt全局变量（相对于调用函数的主函数而言）。
     * @param curNode
     * @param sumTilt
     * @param sum
     * @return
     */
    public int recurTilt(TreeNode curNode,int[] sumTilt,int sum){
        if(curNode == null){
            return 0;
        }

        int leftSum = recurTilt(curNode.left,sumTilt,sum);
        int rightSum = recurTilt(curNode.right,sumTilt,sum);

        sumTilt[0] += Math.abs(leftSum - rightSum);

        sum = leftSum + rightSum + curNode.val;
        return sum;
    }




}
