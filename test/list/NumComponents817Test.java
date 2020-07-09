package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/07/10
 */
public class NumComponents817Test extends TestCase {

    private NumComponents817 num = new NumComponents817();

    public void test1() {
        NumComponents817.ListNode node1 = new NumComponents817.ListNode(0);
        NumComponents817.ListNode node2 = new NumComponents817.ListNode(1);
        NumComponents817.ListNode node3 = new NumComponents817.ListNode(2);
        NumComponents817.ListNode node4 = new NumComponents817.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int result = num.numComponents(node1, new int[]{1, 0, 3});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        NumComponents817.ListNode node1 = new NumComponents817.ListNode(0);
        NumComponents817.ListNode node2 = new NumComponents817.ListNode(1);
        NumComponents817.ListNode node3 = new NumComponents817.ListNode(2);
        NumComponents817.ListNode node4 = new NumComponents817.ListNode(3);
        NumComponents817.ListNode node5 = new NumComponents817.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int result = num.numComponents(node1, new int[]{1, 0, 3, 4});
        Assert.assertEquals(result, 2);
    }

    public void test3() {
        NumComponents817.ListNode node1 = new NumComponents817.ListNode(0);

        int result = num.numComponents(node1, new int[]{0});
        Assert.assertEquals(result, 1);
    }

    public void test4() {
        NumComponents817.ListNode node1 = new NumComponents817.ListNode(0);

        int result = num.numComponents(node1, new int[]{});
        Assert.assertEquals(result, 0);
    }

    public void test5() {
        NumComponents817.ListNode node1 = new NumComponents817.ListNode(0);
        NumComponents817.ListNode node2 = new NumComponents817.ListNode(1);
        NumComponents817.ListNode node3 = new NumComponents817.ListNode(2);
        NumComponents817.ListNode node4 = new NumComponents817.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int result = num.numComponents(node1, new int[]{1, 2, 0, 3});
        Assert.assertEquals(result, 1);
    }
}
