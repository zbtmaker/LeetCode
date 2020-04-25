package string;

import list.MiddleNode876;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class MiddleNode876Test {

    private MiddleNode876 middleNode = new MiddleNode876();

    @Test
    public void test1() {
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);
        MiddleNode876.ListNode h1 = new MiddleNode876.ListNode(2);
        MiddleNode876.ListNode h2 = new MiddleNode876.ListNode(3);
        MiddleNode876.ListNode h3 = new MiddleNode876.ListNode(4);
        head.setNext(h1);
        h1.setNext(h2);
        h2.setNext(h3);

        MiddleNode876.ListNode curNode = new MiddleNode876().middleNode(head);
        print(curNode);
    }

    @Test
    public void test2() {
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);
        MiddleNode876.ListNode h1 = new MiddleNode876.ListNode(2);
        MiddleNode876.ListNode h2 = new MiddleNode876.ListNode(3);
        head.setNext(h1);
        h1.setNext(h2);

        MiddleNode876.ListNode curNode = new MiddleNode876().middleNode(head);
        print(curNode);
    }


    @Test
    public void test3() {
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);
        MiddleNode876.ListNode h1 = new MiddleNode876.ListNode(2);
        head.setNext(h1);

        MiddleNode876.ListNode curNode = new MiddleNode876().middleNode(head);
        print(curNode);

    }

    @Test
    public void test4() {
        MiddleNode876.ListNode head = new MiddleNode876.ListNode(1);

        MiddleNode876.ListNode curNode = new MiddleNode876().middleNode(head);
        print(curNode);
    }

    private void print(MiddleNode876.ListNode head) {
        while (head != null) {
            System.out.print(head.getVal() + "->");
            head = head.getNext();
        }
    }
}
