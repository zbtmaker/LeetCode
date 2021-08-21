package list;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * @author zoubaitao
 * date 2021/08/21
 */
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicatesCycleII(head);
    }

    /**
     * 对于数组或者字符串中出现的重复字符串，有两种思想，第一种就是发现有重复的节点，用一个
     * while循环找到重复节点的最后一个节点，然后用第一个重复节点firstDuplicateNode的前一个节点preNode指向最后一个
     * 重复节点lastDuplicateNode的nextNode。这样就能达到将所有节点删除；第二种方式是每次只观察当前节点，如果当前节点
     * curNode.val和之前节点的value相同，那么当前节点需要被删除，如果
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode deleteDuplicatesCycleII(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        int lastValue = Integer.MIN_VALUE;
        while(cur != null) {
            if(cur.val == lastValue) {
                pre.next = cur.next;
                cur = pre.next;
            } else if(cur.next != null && cur.val == cur.next.val) {
                lastValue = cur.val;
                pre.next = cur.next.next;
                cur = pre.next;
            } else {
                lastValue = cur.val;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 这里采用递归的方式主要是因为二叉树很多题目都可以用递归的方式解决，而链表其实就是
     * 一叉树，那么链表也可以采用递归方式解决
     *
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
