package list;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2020/12/20
 */
public class TestDeleteDuplicates83 extends TestCase {

    private DeleteDuplicates83 delete = new DeleteDuplicates83();

    public void test1() {
        DeleteDuplicates83.ListNode node1 = new DeleteDuplicates83.ListNode(1);
        DeleteDuplicates83.ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test2() {
        DeleteDuplicates83.ListNode node1 = new DeleteDuplicates83.ListNode(1);
        node1.next = new DeleteDuplicates83.ListNode(1);
        DeleteDuplicates83.ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test3() {
        DeleteDuplicates83.ListNode node1 = new DeleteDuplicates83.ListNode(1);
        DeleteDuplicates83.ListNode node2 = new DeleteDuplicates83.ListNode(1);
        node1.next = node2;
        node2.next = new DeleteDuplicates83.ListNode(2);
        DeleteDuplicates83.ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test4() {
        DeleteDuplicates83.ListNode node1 = new DeleteDuplicates83.ListNode(1);
        DeleteDuplicates83.ListNode node2 = new DeleteDuplicates83.ListNode(1);
        node1.next = node2;
        DeleteDuplicates83.ListNode node3 = new DeleteDuplicates83.ListNode(2);
        node2.next = node3;
        DeleteDuplicates83.ListNode node4 = new DeleteDuplicates83.ListNode(2);
        node3.next = node4;
        node4.next = new DeleteDuplicates83.ListNode(3);
        DeleteDuplicates83.ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    private void print(DeleteDuplicates83.ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + "->");
            } else {
                System.out.print(head.val);
            }

            head = head.next;
        }
    }
}
