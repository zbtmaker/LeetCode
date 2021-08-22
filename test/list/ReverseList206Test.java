package list;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class ReverseList206Test extends TestCase {
    private ReverseList206 reverse = new ReverseList206();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{});
        ListNode cur = reverse.reverseList(head);
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1});
        ListNode cur = reverse.reverseList(head);
    }

    public void test3() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1,2});
        ListNode cur = reverse.reverseList(head);
    }

    public void test4() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1,2,3});
        ListNode cur = reverse.reverseList(head);
    }

    public void test5() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1,2,3,4,5,6});
        ListNode cur = reverse.reverseList(head);
    }
}
