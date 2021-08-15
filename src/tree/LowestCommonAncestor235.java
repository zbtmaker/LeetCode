package tree;

/**
 * @author Baitao Zou
 * @date 2019/04/14
 */
public class LowestCommonAncestor235 {

    /**
     * 解题思路：对于任意两个node,如果一个节点比其中的两个节点都要大，那么这两个节点的公共祖先肯定该节点的右子树中的
     * 某一个节点，如果节点比两个节点都要小，那么这两个节点的公共祖先肯是当前节点左子树中的某一个节点。另外就是如果两个
     * 节点有一个节点和当前节点的val相等，那么当前节点就是其common ancestor;另一种情况就是如果当前节点夹在两个节点的中间
     * ，那么当前节点就是其common ancestor
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curNode = root;
        while (curNode != null) {
            if ((p.val < curNode.val && q.val > curNode.val) ||
                    (p.val > curNode.val && q.val < curNode.val) ||
                    p.val == curNode.val ||
                    q.val == curNode.val) {
                return curNode;
            } else if (p.val < curNode.val && q.val < curNode.val) {
                curNode = curNode.left;
            } else if (p.val > curNode.val && q.val > curNode.val) {
                curNode = curNode.right;
            }
        }
        return null;
    }
}
