package list;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/06/15
 */
public class MergeKLists23Test extends TestCase {
    private MergeKLists23 merge = new MergeKLists23();

    public void test1() {
        MergeKLists23.ListNode node10 = new MergeKLists23.ListNode(1);
        MergeKLists23.ListNode node11 = new MergeKLists23.ListNode(4);
        MergeKLists23.ListNode node12 = new MergeKLists23.ListNode(5);
        node10.next = node11;
        node11.next = node12;

        MergeKLists23.ListNode node20 = new MergeKLists23.ListNode(1);
        MergeKLists23.ListNode node21 = new MergeKLists23.ListNode(3);
        MergeKLists23.ListNode node22 = new MergeKLists23.ListNode(4);
        node20.next = node21;
        node21.next = node22;

        MergeKLists23.ListNode node30 = new MergeKLists23.ListNode(2);
        MergeKLists23.ListNode node31 = new MergeKLists23.ListNode(6);
        node30.next = node31;

        MergeKLists23.ListNode[] lists = new MergeKLists23.ListNode[]{node10, node20, node30};
        MergeKLists23.ListNode head = merge.mergeKLists(lists);
        print(head);
    }

    public void test2() {
        MergeKLists23.ListNode node10 = new MergeKLists23.ListNode(-2);
        MergeKLists23.ListNode node11 = new MergeKLists23.ListNode(-1);
        MergeKLists23.ListNode node12 = new MergeKLists23.ListNode(-1);
        MergeKLists23.ListNode node13 = new MergeKLists23.ListNode(-1);
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        MergeKLists23.ListNode[] lists = new MergeKLists23.ListNode[]{node10, null};
        MergeKLists23.ListNode head = merge.mergeKLists(lists);
        print(head);
    }

    public void print(MergeKLists23.ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + "->");
            } else {
                System.out.println(head.val);
            }
            head = head.next;
        }
    }
}
