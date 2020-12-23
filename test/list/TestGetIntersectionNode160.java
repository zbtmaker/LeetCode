package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/23
 */
public class TestGetIntersectionNode160 extends TestCase {

    private GetIntersectionNode160 intersection = new GetIntersectionNode160();

    public void test1() {
        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;

        ListNode headB = new ListNode(1);
        ListNode hb1 = new ListNode(4);
        headB.next = hb1;
        hb1.next = h2;

        ListNode result = intersection.getIntersectionNode(headA, headB);
        Assert.assertEquals(result, h2);
    }

    public void test2() {
        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        headA.next = h1;
        h1.next = h2;

        ListNode headB = new ListNode(1);
        headB.next = h1;

        ListNode result = intersection.getIntersectionNode(headA, headB);
        Assert.assertEquals(result, h1);
    }

    public void test3() {
        ListNode result = intersection.getIntersectionNode(null, null);
        Assert.assertNull(result);
    }

    public void test4() {

    }
}
