package Tree;

import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class isSameTree100 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root1.left = node11;
        root1.right = node12;

        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        root2.left = node21;
        root2.right = node22;

        System.out.println(new isSameTree100().isSameTree(root1,root2));
    }

    /**
     * 这里我们使用了递归的方法来解决问题，就是递归的判断每一个节点是否相同，一旦有不相同的，那么直接返回false；
     * 对于任意一个节点需要判断的情况有一下几种
     * （1） nodeA和nodeB中只有一个节点为null，（nodeA == null && nodeB ！= null;nodeA != null && nodeB == null）
     *      这两种情况下都要返回false
     * （2） 如果nodeA和nodeB中都不为null，那么这个时候就需要判断nodeA.val和nodeB.val是否相等，如果不相等
     *      那么直接返回false，如果相等，那么递归的调用nodeA.left和nodeB.left 以及 nodeA.right和nodeB.right同时
     *      返回true，那么才返回true
     * （3） 最后是如果nodeA和nodeB都是null，那么就返回true。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }else if(p == null & q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }
        return true;
    }
}
