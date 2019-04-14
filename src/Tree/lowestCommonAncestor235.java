package Tree;

import org.junit.Test;

/**
 * @author Baitao Zou
 * @date 2019/04/14
 */
public class lowestCommonAncestor235 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;



        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        node4.left = node5;
        node4.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(9);
        node2.left = node7;
        node2.right = node8;

        lowestCommonAncestor235 lowest = new lowestCommonAncestor235();
        TreeNode common = lowest.lowestCommonAncestor(root,node3,node6);
        System.out.println(common.val);
    }

    /**
     * 解题思路：对于任意两个node,如果一个节点比其中的两个节点都要大，那么这两个节点的公共祖先肯定该节点的右子树中的
     * 某一个节点，如果节点比两个节点都要小，那么这两个节点的公共祖先肯是当前节点左子树中的某一个节点。另外就是如果两个
     * 节点有一个节点和当前节点的val相等，那么当前节点就是其common ancestor;另一种情况就是如果当前节点夹在两个节点的中间
     * ，那么当前节点就是其common ancestor
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curNode = root;
        while(curNode != null){
            if((p.val < curNode.val && q.val > curNode.val) ||
                    (p.val > curNode.val && q.val < curNode.val) ||
                    p.val == curNode.val ||
                    q.val == curNode.val){
                return curNode;
            }else if(p.val < curNode.val && q.val < curNode.val){
                curNode = curNode.left;
            }else if(p.val > curNode.val && q.val > curNode.val){
                curNode = curNode.right;
            }
        }
        return null;
    }
}
