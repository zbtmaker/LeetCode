package tree;

/**
 * LeetCode1457
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 *
 * @author baitao zou
 * date 2020/05/25
 */
public class PseudoPalindromicPaths1457 {
    private static final int ARR_SIZE = 10;


    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] countArr = new int[ARR_SIZE];
        int[] paths = new int[]{0};
        countArr[root.val]++;
        recurPseudoPalindromicPaths(root, countArr, paths);
        return paths[0];
    }

    /**
     * 采用向左和向右递归的方式就可以实现该题目，如果如何判断是伪回文数，如果一个回文中我们对数字进行统计，统计结果如果只有0个或者一个数出现的次数为奇数
     * 那么这个路径就是一个伪回文路径，这个是这道题目的关键所在。递归代码待优化
     *
     * @param root
     * @param countArr
     * @param paths
     */
    private void recurPseudoPalindromicPaths(TreeNode root, int[] countArr, int[] paths) {
        if (root.left == null && root.right == null) {
            paths[0] += isPseudoPalindrome(countArr);
            return;
        }
        if (root.left != null) {
            countArr[root.left.val]++;
            recurPseudoPalindromicPaths(root.left, countArr, paths);
            countArr[root.left.val]--;
        }
        if (root.right != null) {
            countArr[root.right.val]++;
            recurPseudoPalindromicPaths(root.right, countArr, paths);
            countArr[root.right.val]--;
        }
    }

    private int isPseudoPalindrome(int[] countArr) {
        int odd = 0;
        for (int i = 1; i < ARR_SIZE; i++) {
            if ((countArr[i] & 1) == 1) {
                odd++;
            }
            if (odd > 1) {
                return 0;
            }
        }
        return 1;
    }
}
