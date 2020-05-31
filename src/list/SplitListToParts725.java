package list;


/**
 * LeetCode725
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 *
 * @author zoubaitao
 * date 2019/3/20
 */
public class SplitListToParts725 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 分割链表，这个题目分两步走，第一步是统计链表总节点个数，第二个是
     * 是进行平均划分
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        ListNode[] listNodes = new ListNode[k];
        int len = count(root);
        int size = 0, res = 0;
        if (len <= k) {
            size = 1;
        } else {
            size = len / k;
            res = len % k;
        }
        int i = 0;

        ListNode curNode = root;
        while (curNode != null) {
            int total = size + (res <= 0 ? 0 : 1);
            int count = 1;
            listNodes[i] = new ListNode(curNode.val);
            ListNode curRoot = listNodes[i];
            ListNode preNode = curNode;
            curNode = curNode.next;
            while (count < total) {
                curRoot.next = new ListNode(curNode.val);
                curRoot = curRoot.next;
                preNode = curNode;
                curNode = curNode.next;
                count++;
            }
            preNode.next = null;
            res--;
            i++;
        }
        return listNodes;
    }

    /**
     * 计算链表长度
     *
     * @param root 链表根节点
     * @return 链表长度
     */
    private int count(ListNode root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }
}
