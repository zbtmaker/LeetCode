package Tree;

import javax.swing.tree.TreeNode;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class buildTree106 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        int[] preorder= new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,15,7,20,3};
        buildTree106 build= new buildTree106();
        TreeNode root = build.buildTree(preorder,inorder);
        build.postorder(root) ;

    }
    /**
     * build105和build106两个问题主要是递归区间的划分的不同，首先需要理解
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null
                || postorder.length == 0 || inorder.length == 0){
            return null;
        }
        return recurBuildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode recurBuildTree(int[] postorder,int postLeft,int postRight,
                                   int[] inorder,int inLeft,int inRight){
        if(inLeft > inRight){
            return null;
        }
        int postRootIndex = postRight;
        int inRootIndex = -1;
        for(int i = inLeft;i<inorder.length;i++){
            if(inorder[i] == postorder[postRootIndex]){
                inRootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postRootIndex]);

        int postLeftLeft = postLeft;
        int postLeftRight = postLeftLeft + inRootIndex-1 -inLeft;

        int postRightLeft = postLeftRight +1;
        int postRightRight = postRight -1;

        root.left = recurBuildTree(postorder,postLeftLeft,postLeftRight,inorder,inLeft,inRootIndex-1);

        root.right = recurBuildTree(postorder,postRightLeft,postRightRight,inorder,inRootIndex+1,inRight);
        return root;
    }
    private void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);

        postorder(root.right);

        System.out.print(root.val+"->");
    }
}
