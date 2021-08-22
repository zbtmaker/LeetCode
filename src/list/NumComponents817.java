package list;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode817:https://leetcode-cn.com/problems/linked-list-components
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * @author baitao zou
 * date 2020/07/10
 */
public class NumComponents817 {

    /**
     * 通过标志位的方式实现，如果链表中的元素是G数组中的一个元素，那么我们就把标志为置为true，
     * 如果链表中的元素不在数组G中，那么我们就看这个节点前面的那个标志为是否是true，如果为true
     * 表示只是当前位置的元素不满足条件，那么应该count++，如果标志为false，那么此时标志前面就
     * 不满足，那么什么都不需要做。但是这里需要注意的是我们还需要判断最后一个元素是否在数组G中，
     * 如果在的话也是需要count++的，否则不需要。
     *
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        Set<Integer> gSet = arrToSet(G);
        ListNode cur = head;
        boolean flag = false;
        int count = 0;
        while (cur != null) {
            if (!gSet.contains(cur.val)) {
                if (flag) {
                    count++;
                    flag = false;
                }
            } else {
                flag = true;
            }
            cur = cur.next;
        }
        if (flag) {
            count++;
        }
        return count;
    }

    private Set<Integer> arrToSet(int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        return set;
    }
}
