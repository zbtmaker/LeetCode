package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class HasCycle141 {

    /**
     * MethodI :HashMap, time complexity O(N), space complexity O(N)
     * MethodII:Slow and Fast Point, time complexity O(N), space complexity O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        return hasCycleBySlowAndFast(head);
    }

    /**
     * 这里忽略了一个问题就是其实这个问题就是相当于在一个数组中找到一个重复的元素，因为链表如果存在一个环，那么
     * 我们任意两个ListNode的hashCode值是相同的，因此HashMap在比较两个ListNode时，就会判断ListNode的HashNode是
     * 否相同。
     * time complexity : O(N)
     * space complexity : O(N)
     *
     * @param head
     * @return
     */
    private boolean hasCycleByHashMap(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        int i = 1;
        ListNode curNode = head;
        while (curNode != null) {
            if (map.containsKey(curNode)) {
                return true;
            } else {
                map.put(curNode, i++);
            }
            curNode = curNode.next;
        }
        return false;

    }

    /**
     * 通过快慢指针实现，用两个指针，慢指针每次只移动一次，快指针每次移动两次。如果链表不存在环，
     * 那么最终快指针会到达链表的尾端，而此时的慢指针恰好在链表的中间节点。快慢指针能够解决的问题
     * 有：判断一个链表是否存在环、找到一个链表的中间节点、判断链表是否是一个回文。
     * time complexity : O(N),
     * space complexity : O(1)
     *
     * @param head
     * @return
     */
    private boolean hasCycleBySlowAndFast(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
