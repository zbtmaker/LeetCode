package list;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2020/12/20
 */
public class DeleteDuplicates83Test extends TestCase {

    private DeleteDuplicates83 delete = new DeleteDuplicates83();

    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test2() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node2.next = new ListNode(2);
        ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    public void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
        node4.next = new ListNode(3);
        ListNode head = delete.deleteDuplicates(node1);
        print(head);
    }

    private void print(ListNode head) {
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
