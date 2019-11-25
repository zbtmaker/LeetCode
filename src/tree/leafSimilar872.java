package tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 * 运行时间3ms，运行内存25.8MB。
 */
public class leafSimilar872 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        String s1 = "sa";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append("sa");
        sb2.append("sa");
        if(sb1.toString() .equals(sb2.toString())){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        recurGetLeaf(root1,sb1);
        recurGetLeaf(root2,sb2);

        if(sb1.toString() .equals(sb2.toString())){
            return true;
        }else{
            return false;
        }

    }

    /**
     *
     * @param curNode
     * @param sb
     */
    private void recurGetLeaf(TreeNode curNode,StringBuilder sb){
        if(curNode.left == null && curNode.right == null){
            sb.append(curNode.val);
        }

        if(curNode.left != null){
            recurGetLeaf(curNode.left,sb);
        }

        if(curNode.right != null){
            recurGetLeaf(curNode.right,sb);
        }
    }
}
