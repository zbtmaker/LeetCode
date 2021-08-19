package list;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表工具类
 *
 * @author zoubaitao
 * date 2021/08/19
 */
public class CommonUtil {

    /**
     * 将数组转换成ListNode
     *
     * @param arr 数组
     * @return ListNode
     */
    public static ListNode convertArrToListNode(int[] arr) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }
        return dummyNode.next;
    }

    /**
     * 将链表转换成数组
     *
     * @param head 链表
     * @return 数组
     */
    public static int[] convertListNodeToArr(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
