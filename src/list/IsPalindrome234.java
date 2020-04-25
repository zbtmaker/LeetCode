package list;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * @author Baitao Zou
 * date 2019\2\20
 */
public class IsPalindrome234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        return isPalindromeII(head);
    }

    /**
     * 待优化
     * 如果要我们判断一个数组是否是回文，那么我们直接使用两个指针，一个left指向数组最左边，另一个指针
     * right指向数组最右边，当left<right时，循环结束。
     * 现在我们要对一个链表进行操作，那么我们就需要仔细考虑。因为链表中没法使用一个两个指针同时走，
     * 因此，如果我们要一个从头走，另一个从结尾走，那么我们就只能借助堆栈stack这个数据结构的特性：先进后出。
     * 这样一来我们根据下面的步骤就可以判断这个链表是否是一个回文链表。
     * （1）我们将链表中的元素押入堆栈中
     * （2）我们利用一个指针来curNode，如果stack.pop()出来的ListNode的val不等于curNode.val,那么直接返回false。
     * （3）循环结束，那么此时仍然没有返回，那么我们返回true就可以了
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param head
     * @return
     */
    private boolean isPalindromeI(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        curNode = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != curNode.val) {
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }

    /**
     * 上面我们使用Stack数据结构实现了时间复杂度O(N)，空间复杂度O(N)。那么我们如何实现空间复杂度为
     * O(N),而时间复杂度为O(1)。我们之前的算法是采用一个辅助空间的方式，但是我们参考IsPalindrome9,
     * 我们可以把一个链表进行翻转之后与原链表进行比较。但是如果是这样的话就会造成O(N),所以我们可以翻转一半
     * 的链表的方式。其实我们可以翻转前一半链表或者是后一半链表来解决。所以这个题目就是回文判断和快慢指针。
     * 既然我们要将后一半链表翻转过来，那么我们就可以借鉴MiddleNode876的思路。
     * 第一步:使用快慢指针找到链表的中间节点(奇数链表)或者是偶数链表的后一半的起始位置
     * 第二步:翻转前一半链表就能解决问题，
     * 第三步:两个指针一起走判断是否是回文
     * 所以这个问题是接着回文的皮在考察链表中间节点Middle876和ReverseList206。这里我们需要注意单节点链表，
     * 奇数节点链表和偶数节点链表
     *
     * @param head
     * @return
     */
    private boolean isPalindromeII(ListNode head) {
        //解决单节点链表
        if (head == null || head.next == null) {
            return true;
        }
        //由快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转前半部分链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != slow) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        //判断是否是回文,这里pre是前半部分翻转后的头节点，slow是后半部分的头节点，
        // 同时还需要判断是偶数节点链表还是奇数节点链表。
        slow = fast == null ? slow : slow.next;
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
