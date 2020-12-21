package list;

import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/23
 */
public class MiddleNode876Test {

    private MiddleNode876 middle = new MiddleNode876();

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode result = middle.middleNode(head);
        traverseList(result);
    }


    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        ListNode result = middle.middleNode(head);
        traverseList(result);
    }

    /**
     * 遍历链表
     *
     * @param head
     */
    private void traverseList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
