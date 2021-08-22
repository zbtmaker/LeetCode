package list;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class OddEvenList328Test extends TestCase {

    private final OddEvenList328 oddEvenList = new OddEvenList328();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }

    public void test3() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }


    public void test4() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }

    public void test5() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }

    public void test6() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode curNode = oddEvenList.oddEvenList(head);
    }
}
