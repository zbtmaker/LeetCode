package list;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * @author baitao zou
 * date 2020/06/15
 */
public class TestMergeTwoLists21 extends TestCase {
    private MergeTwoLists21 merge = new MergeTwoLists21();

    public void test1() {
        ListNode h10 = new ListNode(1);
        ListNode h11 = new ListNode(2);
        ListNode h12 = new ListNode(3);
        ListNode h13 = new ListNode(4);
        ListNode h14 = new ListNode(5);

        h10.next = h11;
        h11.next = h12;
        h12.next = h13;
        h13.next = h14;

        ListNode h20 = new ListNode(2);
        ListNode h21 = new ListNode(4);
        ListNode h22 = new ListNode(5);
        h20.next = h21;
        h21.next = h22;
        ListNode head = merge.mergeTwoLists(h10, h20);
        Assert.assertArrayEquals(listToArr(head), new Integer[]{1, 2, 2, 3, 4, 4, 5, 5});
    }

    private Integer[] listToArr(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new Integer[0]);
    }
}
