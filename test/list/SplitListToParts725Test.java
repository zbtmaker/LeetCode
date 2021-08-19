package list;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/05/31
 */
public class SplitListToParts725Test extends TestCase {

    private final SplitListToParts725 split = new SplitListToParts725();

    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = new ListNode(10);

        ListNode[] listNodes = split.splitListToParts(node1, 3);
        print(listNodes);
    }

    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = new ListNode(5);

        ListNode[] listNodes = split.splitListToParts(node1, 5);
        print(listNodes);
    }

    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = new ListNode(3);

        ListNode[] listNodes = split.splitListToParts(node1, 5);
        print(listNodes);
    }

    private void print(ListNode[] listNodes) {
        for (ListNode node : listNodes) {
            while (node != null) {
                if (node.next != null) {
                    System.out.print(node.val + "->");
                } else {
                    System.out.print(node.val);
                }
                node = node.next;
            }
            System.out.println();
        }
    }
}
