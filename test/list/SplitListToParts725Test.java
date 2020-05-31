package list;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/05/31
 */
public class SplitListToParts725Test extends TestCase {

    private SplitListToParts725 split = new SplitListToParts725();

    public void test1() {
        SplitListToParts725.ListNode node1 = new SplitListToParts725.ListNode(1);
        SplitListToParts725.ListNode node2 = new SplitListToParts725.ListNode(2);
        SplitListToParts725.ListNode node3 = new SplitListToParts725.ListNode(3);
        SplitListToParts725.ListNode node4 = new SplitListToParts725.ListNode(4);
        SplitListToParts725.ListNode node5 = new SplitListToParts725.ListNode(5);
        SplitListToParts725.ListNode node6 = new SplitListToParts725.ListNode(6);
        SplitListToParts725.ListNode node7 = new SplitListToParts725.ListNode(7);
        SplitListToParts725.ListNode node8 = new SplitListToParts725.ListNode(8);
        SplitListToParts725.ListNode node9 = new SplitListToParts725.ListNode(9);
        SplitListToParts725.ListNode node10 = new SplitListToParts725.ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        SplitListToParts725.ListNode[] listNodes = split.splitListToParts(node1, 3);
        print(listNodes);
    }

    public void test2() {
        SplitListToParts725.ListNode node1 = new SplitListToParts725.ListNode(1);
        SplitListToParts725.ListNode node2 = new SplitListToParts725.ListNode(2);
        SplitListToParts725.ListNode node3 = new SplitListToParts725.ListNode(3);
        SplitListToParts725.ListNode node4 = new SplitListToParts725.ListNode(4);
        SplitListToParts725.ListNode node5 = new SplitListToParts725.ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SplitListToParts725.ListNode[] listNodes = split.splitListToParts(node1, 5);
        print(listNodes);
    }

    public void test3() {
        SplitListToParts725.ListNode node1 = new SplitListToParts725.ListNode(1);
        SplitListToParts725.ListNode node2 = new SplitListToParts725.ListNode(2);
        SplitListToParts725.ListNode node3 = new SplitListToParts725.ListNode(3);

        node1.next = node2;
        node2.next = node3;

        SplitListToParts725.ListNode[] listNodes = split.splitListToParts(node1, 5);
        print(listNodes);
    }

    private void print(SplitListToParts725.ListNode[] listNodes) {
        for (SplitListToParts725.ListNode node : listNodes) {
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
