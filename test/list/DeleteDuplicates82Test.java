package list;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * @author Baitao Zou
 * date 2020/12/21
 */
public class DeleteDuplicates82Test extends TestCase {

    private final DeleteDuplicates82 delete = new DeleteDuplicates82();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1});
        ListNode result = delete.deleteDuplicates(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(result), new int[]{1});
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 1});
        ListNode result = delete.deleteDuplicates(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(result), new int[]{});
    }

    public void test3() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 1, 2});
        ListNode result = delete.deleteDuplicates(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(result), new int[]{2});
    }

    public void test4() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 1, 1, 2, 3});
        ListNode result = delete.deleteDuplicates(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(result), new int[]{2, 3});
    }

    public void test5() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode result = delete.deleteDuplicates(head);
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(result), new int[]{1, 2, 5});
    }
}
