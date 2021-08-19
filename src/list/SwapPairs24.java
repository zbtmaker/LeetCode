package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;

        while (curNode != null && curNode.next != null) {
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            preNode.next = nextNode;

            preNode = curNode;
            curNode = curNode.next;
        }
        return dummyNode.next;
    }
}
