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
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);
        MiddleNode876.ListNode second = new MiddleNode876.ListNode(2);
        head.next = second;
        MiddleNode876.ListNode result = middle.middleNode(head);
        traverseList(result);
    }


    @Test
    public void test2() {
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);
        MiddleNode876.ListNode second = new MiddleNode876.ListNode(2);
        MiddleNode876.ListNode third = new MiddleNode876.ListNode(3);
        head.next = second;
        second.next = third;
        MiddleNode876.ListNode result = middle.middleNode(head);
        traverseList(result);
    }

    /**
     * 遍历链表
     *
     * @param head
     */
    private void traverseList(MiddleNode876.ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
