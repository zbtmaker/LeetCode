package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class GetIntersectionNode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNodeII(headA, headB);
    }

    /**
     * 使用双层循环的方式的时间复杂度是O(NM)，其中N是headA的长度，M是headB的长度
     * 这种方式的运行时间较长，下面应该用Map的方式来减少时间复杂度。
     * 时间复杂度O(AB) 空间复杂度O(1)
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    private ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        ListNode curNodeA = headA;
        while (curNodeA != null) {
            ListNode curNodeB = headB;
            while (curNodeB != null) {
                if (curNodeB == curNodeA) {
                    return curNodeB;
                } else {
                    curNodeB = curNodeB.next;
                }
            }
            curNodeA = curNodeA.next;
        }
        return null;
    }

    /**
     * 使用HashMap的方式来解决，此方式的时间复杂度为O(N+M)。
     * 这种方式得到的运行时间虽然短，但是空间复杂度上去了，下面应该还会有更好的方法。
     * 时间复杂度O(max{A,B}), 空间复杂度O(max(A,B))
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    private ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        ListNode curNodeA = headA;
        Map<ListNode, Integer> map = new HashMap<>();
        while (curNodeA != null) {
            map.put(curNodeA, 1);
            curNodeA = curNodeA.next;
        }
        ListNode curNodeB = headB;
        while (curNodeB != null) {
            if (map.containsKey(curNodeB)) {
                return curNodeB;
            }
            curNodeB = curNodeB.next;
        }
        return null;
    }

    /**
     * 如果链表A节点走到了链表的尾部，那么将指针指向链表B的头节点，然后继续走
     * 如果链表B节点走到了链表的尾部，那么将指针指向链表A的头节点，然后继续走
     * 这个时候A和B走的路程一致
     * 如果链表A和链表B的长度一样长，那么一遍循环就能走到链表相交点
     * 如果链表A比链表B的长，那么B会先走到链表节点，然后B开始走A的节点，而A会走到尽头之后
     * 会走B的节点
     *
     * @param headA 链表A头节点
     * @param headB 链表B头节点
     * @return
     */
    private ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }

        return node1;
    }
}
