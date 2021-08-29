package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/15
 */
public class MergeTwoLists21Test extends TestCase {
    private final MergeTwoLists21 merge = new MergeTwoLists21();

    public void test1() {
        ListNode h10 = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4, 5});

        ListNode h20 = CommonUtil.convertArrToListNode(new int[]{2, 4, 5});

        ListNode head = merge.mergeTwoLists(h10, h20);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(head), new int[]{1, 2, 2, 3, 4, 4, 5, 5});
    }
}
