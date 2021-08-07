package tree;

/**
 * Created by Administrator on 2019\2\23 0023.
 * 运行时间1ms，内存消耗为29.5MB，超过97%的提交。
 */
public class SortedArrayToBST108 {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        //int nums[] = null;
        SortedArrayToBST108 newTree = new SortedArrayToBST108();
        TreeNode root = newTree.sortedArrayToBST(nums);
        newTree.inorder(root);
    }

    /**
     * 主要思想每次都是找到一个区间的中点middle，然后向左区间[left,middle]<-new TreeNode(nums[middle])->[middle+1,right]右区间
     * 然后不断的进行递归。首先需要确定halting rule：当一个区间的left>right的时候这个时候就应该停止了。
     * 如果想不明白就写一个例子，然后按上面这种方式构造一个Tree.
     * 这是主程序。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return recurSortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 这是递归程序。
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode recurSortedArrayToBST(int[] nums, int left, int right) {
        //halting rule
        if (left > right) {
            return null;
        }
        int middle = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[middle]);

        node.left = recurSortedArrayToBST(nums, left, middle - 1);
        node.right = recurSortedArrayToBST(nums, middle + 1, right);

        return node;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + "->");
        inorder(root.right);
    }
}
