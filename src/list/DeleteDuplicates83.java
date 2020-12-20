package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class DeleteDuplicates83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 其实链表的操作和数组的操作一致，无需多言
     *
     * @param head 头节点
     * @return 头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val != fast.next.val) {
                slow = slow.next;
                slow.val = fast.next.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
