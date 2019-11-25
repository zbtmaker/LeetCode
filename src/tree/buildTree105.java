package tree;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class buildTree105 {
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
        int[] inorder = new int[]{9,3,15,20,7};
        buildTree105 build= new buildTree105();
        TreeNode root = build.buildTree(preorder,inorder);
        build.inorder(root) ;

    }

    /**
     * 递归大法好，首先写出root向下递归的，然后就得到了范式
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return recurBuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode recurBuildTree(int[] preorder,int preLeft,int preRight,
                                   int[] inorder,int inLeft,int inRight){
        if(inLeft > inRight){
            return null;
        }

        int preRootIndex = preLeft;
        int inRootIndex = -1;
        for(int i = inLeft;i<inorder.length;i++){
            if(inorder[i] == preorder[preRootIndex]){
                inRootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preRootIndex]);

        int preLeftLeft = preRootIndex+1;
        int preLeftRight = preLeftLeft + inRootIndex-1 -inLeft;

        int preRightLeft = preLeftRight +1;
        int preRightRight = preRight;

        root.left = recurBuildTree(preorder,preLeftLeft,preLeftRight,inorder,inLeft,inRootIndex-1);

        root.right = recurBuildTree(preorder,preRightLeft,preRightRight,inorder,inRootIndex+1,inRight);
        return root;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+"->");
        inorder(root.right);
    }
}
