package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class HasCycle141Test extends TestCase {
    private final HasCycle141 hasCycle = new HasCycle141();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4});

        boolean result = hasCycle.hasCycle(head);
        Assert.assertFalse(result);
    }

    public void test2() {
        boolean result = hasCycle.hasCycle(null);
        Assert.assertFalse(result);
    }


    public void test3() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    public void test4() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l1;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    public void test5() {
        ListNode l1 = new ListNode(1);

        l1.next = l1;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }
}
