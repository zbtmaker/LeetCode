package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class MiddleNode876 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return this.next;
        }

        public int getVal() {
            return this.val;
        }
    }

    /**
     * 通过计数的方式来计算结果
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        return middleNodeSlowAndFast(head);
    }


    /**
     * 第一种方式是采用计数的方式，给定计数器count1 = 1,指针p1 = head从链表的头部走到尾部，统计处链表的长度len;
     * 然后给一个指针p2走count2 = (len>>1) + 1，count2 = 1，当count2 = (len>>1)+1时表示指针刚好处在链表的中间
     * （奇数链表的正中间，偶数链表的后半部链表的其实位置）
     *
     * @param head
     * @return
     */
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

    /**
     * 第二终方式使用dijkstra提出的快慢指针解决有环图的算法思路，其实快慢指针是对我们第一种算法的一个优化。
     * 我们给定两个指针slow和fast，其中slow每次只走一步，而fast每次都走两步。这里我们可以分奇链表和偶链表
     * 来讨论。
     * 偶链表：1->2->3->4
     * initial: slow = 1, fast = 1;
     * step1: slow = 2, fast = 3;
     * setp2: slow = 3, fast = null;
     * 此时fast = null了，应该马上停止循环，返回slow指针
     * 奇链表: 1->2->3
     * initial: slow = 1, fast = 1;
     * step1: slow = 2, fast = 3
     * 此时发现slow已经处在链表的中间位置了，那么也应该退出循环，条件是什么呢，就是fast.next = null
     * 因此我们综上奇偶链表，我们就能得到我们循环退出条件，都能满足我们找到指针中点的位置
     *
     * @param head
     * @return
     */
    private ListNode middleNodeSlowAndFast(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
