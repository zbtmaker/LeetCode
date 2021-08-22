package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2021/08/{DAY}
 */
public class ReorderList143Test extends TestCase {

    private final ReorderList143 reorder = new ReorderList143();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4});
        reorder.reorderList(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(head), new int[]{1, 4, 2, 3});
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4, 5});
        reorder.reorderList(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(head), new int[]{1, 5, 2, 4, 3});
    }
}
