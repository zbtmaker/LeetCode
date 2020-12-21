package list;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * @author Baitao Zou
 * date 2020/12/21
 */
public class TestDeleteDuplicates82 extends TestCase {

    private DeleteDuplicates82 delete = new DeleteDuplicates82();

    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode result = delete.deleteDuplicates(node1);
        Assert.assertArrayEquals(listToArr(result), new Integer[]{1});
    }

    public void test2() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        ListNode result = delete.deleteDuplicates(node1);
        Assert.assertArrayEquals(listToArr(result), new Integer[]{});
    }

    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node2.next = new ListNode(2);
        ListNode result = delete.deleteDuplicates(node1);
        Assert.assertArrayEquals(listToArr(result), new Integer[]{2});
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
