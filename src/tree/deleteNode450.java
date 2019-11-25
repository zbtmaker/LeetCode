package tree;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class deleteNode450{
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
        deleteNode450 newTree = new deleteNode450();
        TreeNode root = newTree.sortedArrayToBST(nums);
        root = newTree.deleteNode(root,0);
        newTree.inorder(root);
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        root = recurFind(root,key);
        return root;
    }

    /**
     * 删除一个节点的第一步是找到这个节点，第二步才是删除
     * @param curNode
     * @param key
     * @return
     */
    private TreeNode recurFind(TreeNode curNode,int key){
        if(curNode == null){
            return null;
        }
        if(curNode.val > key){
            curNode.left = recurFind(curNode.left,key);
        }else if(curNode.val < key){
            curNode.right = recurFind(curNode.right,key);
        }else{
            curNode = delete(curNode);
        }
        return curNode;
    }

    /**
     * 找到这个节点之后就可以将这个节点删除，但是删除一个节点，需要分三种情况来讨论。
     * 第一种情况是左子树为null，第二种情况是右子树为null，第三种情况是左子树和右子树
     * 都不为null。其中第三种情况是最复杂的。
     * @param root
     * @return
     */
    private TreeNode delete(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            TreeNode preNode = null;
            TreeNode curNode = root.right;
            while(curNode.left != null){
                preNode = curNode;
                curNode = curNode.left;
            }
            if(preNode == null){
                curNode.left = root.left;
                root = curNode;
            }else{
                preNode.left = curNode.right;
                curNode.left = root.left;
                curNode.right = root.right;
                root = curNode;
            }
            return root;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return recurSortedArrayToBST(nums,0,nums.length-1);
    }
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
