package list;

import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class ReverseList206Test {
    private ReverseList206 reverse = new ReverseList206();

    @Test
    public void test1() {
        ReverseList206.ListNode head = new ReverseList206.ListNode(1);
        ReverseList206.ListNode h1 = new ReverseList206.ListNode(2);
        ReverseList206.ListNode h2 = new ReverseList206.ListNode(3);
        ReverseList206.ListNode h3 = new ReverseList206.ListNode(4);
        ReverseList206.ListNode h4 = new ReverseList206.ListNode(5);
        ReverseList206.ListNode h5 = new ReverseList206.ListNode(6);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        ReverseList206.ListNode cur = reverse.reverseList(head);
        print(cur);
    }

    @Test
    public void test2() {
        ReverseList206.ListNode head = new ReverseList206.ListNode(1);

        ReverseList206.ListNode cur = reverse.reverseList(head);
        print(cur);
    }

    @Test
    public void test3() {
        ReverseList206.ListNode head = new ReverseList206.ListNode(1);
        head.next = new ReverseList206.ListNode(2);
        ReverseList206.ListNode cur = reverse.reverseList(head);
        print(cur);
    }

    @Test
    public void test4() {
        ReverseList206.ListNode head = new ReverseList206.ListNode(1);
        ReverseList206.ListNode h1 = new ReverseList206.ListNode(2);
        ReverseList206.ListNode h2 = new ReverseList206.ListNode(3);
        head.next = h1;
        h1.next = h2;

        ReverseList206.ListNode cur = reverse.reverseList(head);
        print(cur);
    }

    @Test
    public void test5() {
        ReverseList206.ListNode cur = reverse.reverseList(null);
        print(cur);
    }

    private void print(ReverseList206.ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
