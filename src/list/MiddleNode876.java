package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class MiddleNode876 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        deleteDuplicates83 del = new deleteDuplicates83();

        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;

        ListNode curNode = new MiddleNode876().middleNode(headA);

        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /**
     * 通过计数的方式来计算结果
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        return middleNodeTwoPoint(head);
    }


    private ListNode middleNodeCount(ListNode head) {
        ListNode curNode = head;
        int count = 0;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        int middle = count >> 1;
        curNode = head;
        while (middle > 0) {
            curNode = curNode.next;
            middle--;
        }
        return curNode;
    }

    private ListNode middleNodeTwoPoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
