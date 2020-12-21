package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicatesRecur(head);
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                pre.next = fast;
            } else {
                pre = fast;
                fast = fast.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 这里采用递归的方式主要是因为二叉树很多题目都可以用递归的方式解决，而链表其实就是
     * 一叉树，那么链表也可以采用递归方式解决
     * @param head 链表头节点
     * @return 删除后的节点
     */
    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicatesRecur(head.next);
            return head;
        }
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicatesRecur(head.next);
    }
}
