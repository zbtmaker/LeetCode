package Tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class trimBST669 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        //int nums[] = null;
        trimBST669 newTree = new trimBST669();
        TreeNode root = newTree.sortedArrayToBST(nums);
        root = newTree.trimBST(root,14,14);
        newTree.inorder(root);
    }

    /**
     * 这个题目最好的方式是使用递归的方法，对于一个搜索二叉树，每一个节点curNode.left.val<curNode.val<curNode.right.val
     * 满足这个条件，因此如果一个节点curNode.val<L，那么当前节点curNode的所有左边节点都要删除(curNode.left == null)，同时
     * 我们将当前节点的curNode的right节点置为当前节点(curNode = curNode.right)，这样操作了之后还需要判断当前修改的curNode是否
     * 需要删除，因此应该将当前节点进一步递归并将递归结果置为当前节点。同理，如果curNode.val>R，那么当前节点curNode的所有右边节点
     * 都要删除；如果L<=curNode<=R，那么就进一步左右两边递归，然后将递归结果返回作为当前节点的左右节点。
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return recurTrimBST(root,L,R);
    }
    private TreeNode recurTrimBST(TreeNode curNode,
                                  int L,int R){
        if(curNode == null){
            return null;
        }
        if(curNode.val<L){
            curNode.left = null;
            curNode = curNode.right;
            curNode = recurTrimBST(curNode,L,R);
        }else if(curNode.val>R){
            curNode.right = null;
            curNode = curNode.left;
            curNode = recurTrimBST(curNode,L,R);
        }else{
            curNode.left = recurTrimBST(curNode.left,L,R);
            curNode.right = recurTrimBST(curNode.right,L,R);
        }
        return curNode;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return recurSortedArrayToBST(nums,0,nums.length-1);
    }

    /**
     * 这是递归程序。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode recurSortedArrayToBST(int[] nums,int left,int right){
        //halting rule
        if(left > right){
            return null;
        }
        int middle = (left + right)>>1;
        TreeNode node = new TreeNode(nums[middle]);

        node.left = recurSortedArrayToBST(nums,left,middle - 1);
        node.right = recurSortedArrayToBST(nums,middle + 1,right);

        return node;
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
