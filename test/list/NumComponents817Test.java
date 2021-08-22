package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/07/10
 */
public class NumComponents817Test extends TestCase {

    private final NumComponents817 num = new NumComponents817();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{0, 1, 2, 3});
        int result = num.numComponents(head, new int[]{1, 0, 3});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{0, 1, 2, 3, 4});
        int result = num.numComponents(head, new int[]{1, 0, 3, 4});
        Assert.assertEquals(result, 2);
    }

    public void test3() {

        ListNode head = CommonUtil.convertArrToListNode(new int[]{0});
        int result = num.numComponents(head, new int[]{0});
        Assert.assertEquals(result, 1);
    }

    public void test4() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{0});
        int result = num.numComponents(head, new int[]{});
        Assert.assertEquals(result, 0);
    }

    public void test5() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{0, 1, 2, 3});
        int result = num.numComponents(head, new int[]{1, 2, 0, 3});
        Assert.assertEquals(result, 1);
    }
}
