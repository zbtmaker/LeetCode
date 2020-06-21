package list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class MergeKLists23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsByPriorityQueue(lists);
    }

    /**
     * 通过优先队列的方式来维护一个小顶堆，这样能够减少算法的时间复杂度
     *
     * @param lists
     * @return 排序好的链表
     */
    private ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        //1、统计链表的长度
        int len = countLen(lists);

        if (len == 0) {
            return null;
        }
        //2、构建一个小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));

        //3、将Node添加到queue当中
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }
        ListNode head = new ListNode(queue.poll().val);
        ListNode pre = head;
        for (Iterator<ListNode> iterator = queue.iterator(); iterator.hasNext(); ) {
            ListNode cur = queue.poll();
            pre.next = cur;
            pre = cur;
        }
        pre.next = null;
        return head;
    }

    private int countLen(ListNode[] lists) {
        int len = 0;
        for (ListNode list : lists) {
            while (list != null) {
                len++;
                list = list.next;
            }
        }
        return len;
    }

    /**
     * 这个题目可以借助LeetCode21-合并两个链表实现，对于每一个链表都需要和之前的链表进行合并操作。
     * 其实这个题目有一个更好的实现方式，其实就是归并排序，这个过程就是相当于归并排序已经将局部排序好
     * 的元素然后再次进行排序。算法时间复杂度和空间复杂度需要通过推导公式来计算，暂时不做详细的推导。
     *
     * @param lists
     * @return
     */
    private ListNode mergeKListsByMultiplePoint(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);

        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        ListNode currNode3 = null;
        ListNode newNode = null;
        while (currNode1 != null && currNode2 != null) {
            if (currNode1.val < currNode2.val) {
                newNode = new ListNode(currNode1.val);
                currNode1 = currNode1.next;
            } else {
                newNode = new ListNode(currNode2.val);
                currNode2 = currNode2.next;
            }
            if (head == null) {
                head = newNode;
                currNode3 = head;
            } else {
                currNode3.next = newNode;
                currNode3 = currNode3.next;
            }
        }
        if (currNode2 != null) {
            while (currNode2 != null) {
                newNode = new ListNode(currNode2.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode2 = currNode2.next;
            }
        } else {
            while (currNode1 != null) {
                newNode = new ListNode(currNode1.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode1 = currNode1.next;
            }

        }
        return head;
    }
}
