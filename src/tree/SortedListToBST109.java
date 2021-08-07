package tree;

/**
 * Created by Administrator on 2019\3\10 0010.
 */
public class SortedListToBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode curNode = head;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        return recurSortedListToBST(1, len, head);
    }

    private TreeNode recurSortedListToBST(int left, int right, ListNode head) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) >> 1;

        ListNode curNode = head;

        int i = left;
        while (i < middle) {
            curNode = curNode.next;
            i++;
        }
        TreeNode root = new TreeNode(curNode.val);

        root.left = recurSortedListToBST(left, middle - 1, head);
        root.right = recurSortedListToBST(middle + 1, right, curNode.next);

        return root;
    }

}
