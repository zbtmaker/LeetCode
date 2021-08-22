package list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class DetectCycle142 {
    /**
     * method1 : HashSet time complexity O(1), space complexity O(N)
     * method2 : Fast-Slow Point time complexity O(N), space complexity O(1)
     *
     * @param head 头节点
     * @return 环入口
     */
    public ListNode detectCycle(ListNode head) {
        return detectCycleByFastAndSlow(head);
    }

    /**
     * 相当于数组中寻找重复元素
     *
     * @param head 头节点
     * @return 环入口
     */
    private ListNode detectCycleByHashSet(ListNode head) {
        Set<ListNode> map = new HashSet<>();
        while (head != null) {
            if (map.contains(head)) {
                return head;
            }
            map.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 参考链接 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     * 假如环存在，假定链表首节点到环入口的距离为x,而slow和fast指针在环内走了y步之后相遇了，那么此时slow走的步数就是
     * s = x + y,因为fast走的速度是slow速度的2倍，因此
     * f = 2(x + y). (1)
     * 假设从相遇点顺时针到环入口距离为z,那么fast指针一定至少在环中走了n圈然后又走了y步之后与slow指针相遇，因此fast走过的距离又可以表示为
     * f = x + (y + z)n + y (2)
     * 联合公式（1）、（2）得到
     * x = (n - 1)(y + z) + z. (3)
     * 从这个公式(3)我们可以看出来，从链表首节点到环的走过的步数应该是等于节点在环中走n - 1圈之后，然后又走z 步的距离是相等的。
     * 也就是说，slow节点从链表头节点，然后我让fast节点先走z步，然后两个节点开始一起走，这个时候slow节点和fast节点肯定会在环入口处相遇
     * 根据上面这个思路，如果链表中存在环，那么我们在首先找到两个节点相遇的点，然后让一个节点回到链表首节点，另一个节点从相遇点开始走，一直走到
     * 两个链表相遇为止。
     *
     * @param head
     * @return
     */
    private ListNode detectCycleByFastAndSlow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //注意交点不一定是环点
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
