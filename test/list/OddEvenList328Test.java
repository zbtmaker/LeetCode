package list;

import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class OddEvenList328Test {

    private OddEvenList328 oddEvenList = new OddEvenList328();

    @Test
    public void test1() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);
        OddEvenList328.ListNode h1 = new OddEvenList328.ListNode(2);
        OddEvenList328.ListNode h2 = new OddEvenList328.ListNode(3);
        OddEvenList328.ListNode h3 = new OddEvenList328.ListNode(4);
        OddEvenList328.ListNode h4 = new OddEvenList328.ListNode(5);
        OddEvenList328.ListNode h5 = new OddEvenList328.ListNode(6);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }

    @Test
    public void test2() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);

        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }

    @Test
    public void test3() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);
        head.next = new OddEvenList328.ListNode(2);

        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }


    @Test
    public void test4() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);
        OddEvenList328.ListNode h1 = new OddEvenList328.ListNode(2);
        OddEvenList328.ListNode h2 = new OddEvenList328.ListNode(3);
        head.next = h1;
        h1.next = h2;
        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }

    @Test
    public void test5() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);
        OddEvenList328.ListNode h1 = new OddEvenList328.ListNode(2);
        OddEvenList328.ListNode h2 = new OddEvenList328.ListNode(3);
        OddEvenList328.ListNode h3 = new OddEvenList328.ListNode(4);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }

    @Test
    public void test6() {
        OddEvenList328.ListNode head = new OddEvenList328.ListNode(1);
        OddEvenList328.ListNode h1 = new OddEvenList328.ListNode(2);
        OddEvenList328.ListNode h2 = new OddEvenList328.ListNode(3);
        OddEvenList328.ListNode h3 = new OddEvenList328.ListNode(4);
        OddEvenList328.ListNode h4 = new OddEvenList328.ListNode(5);
        OddEvenList328.ListNode h5 = new OddEvenList328.ListNode(6);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        OddEvenList328.ListNode curNode = new OddEvenList328().oddEvenList(head);
        print(curNode);
    }

    private void print(OddEvenList328.ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
