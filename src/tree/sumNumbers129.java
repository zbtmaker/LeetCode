package tree;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class sumNumbers129 {
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
        //root.right = node2;

        System.out.println(new sumNumbers129().sumNumbers(root));
    }
    /**
     * 这个题目和路径总和(hasPathSum、pathSum等)一样的，使用的是回溯法实现。
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        return recurPathSum(root,0,sb);
    }
    private int recurPathSum(TreeNode curNode, int sum,StringBuilder sb){
        if(curNode.left == null && curNode.right == null){
            sum += Integer.parseInt(sb.toString());
            return sum;
        }else{
            if(curNode.left != null){
                sb.append(curNode.left.val);
                sum = recurPathSum(curNode.left,sum,sb);
                sb.deleteCharAt(sb.length() -1);
            }
            if(curNode.right != null){
                sb.append(curNode.right.val);
                sum = recurPathSum(curNode.right,sum,sb);
                sb.deleteCharAt(sb.length() -1);
            }
        }
        return sum;
    }
}
