package list;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/06/15
 */
public class MergeKLists23Test extends TestCase {
    private final MergeKLists23 merge = new MergeKLists23();

    public void test1() {
        ListNode head0 = CommonUtil.convertArrToListNode(new int[]{1,4,5});

        ListNode head1 = CommonUtil.convertArrToListNode(new int[]{1,3,4});

        ListNode head2 = CommonUtil.convertArrToListNode(new int[]{2,6});

        ListNode[] lists = new ListNode[]{head0, head1, head2};
        ListNode head = merge.mergeKLists(lists);
    }

    public void test2() {
        ListNode head0 = CommonUtil.convertArrToListNode(new int[]{-2,-1,-1,-1});

        ListNode[] lists = new ListNode[]{head0, null};
        ListNode head = merge.mergeKLists(lists);
    }

}
