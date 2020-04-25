package list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class HasCycle141Test {
    private HasCycle141 hasCycle = new HasCycle141();

    @Test
    public void test1() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        HasCycle141.ListNode l2 = new HasCycle141.ListNode(2);
        HasCycle141.ListNode l3 = new HasCycle141.ListNode(3);
        HasCycle141.ListNode l4 = new HasCycle141.ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        boolean result = hasCycle.hasCycle(null);
        Assert.assertFalse(result);
    }

    @Test
    public void test3() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        HasCycle141.ListNode l2 = new HasCycle141.ListNode(2);
        HasCycle141.ListNode l3 = new HasCycle141.ListNode(3);
        HasCycle141.ListNode l4 = new HasCycle141.ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l4;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        HasCycle141.ListNode l2 = new HasCycle141.ListNode(2);
        HasCycle141.ListNode l3 = new HasCycle141.ListNode(3);
        HasCycle141.ListNode l4 = new HasCycle141.ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l3;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        HasCycle141.ListNode l2 = new HasCycle141.ListNode(2);
        HasCycle141.ListNode l3 = new HasCycle141.ListNode(3);
        HasCycle141.ListNode l4 = new HasCycle141.ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    @Test
    public void test6() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        HasCycle141.ListNode l2 = new HasCycle141.ListNode(2);
        HasCycle141.ListNode l3 = new HasCycle141.ListNode(3);
        HasCycle141.ListNode l4 = new HasCycle141.ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l1;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }

    @Test
    public void test7() {
        HasCycle141.ListNode l1 = new HasCycle141.ListNode(1);

        l1.next = l1;
        boolean result = hasCycle.hasCycle(l1);
        Assert.assertTrue(result);
    }
}
