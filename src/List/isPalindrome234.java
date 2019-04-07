package List;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\20 0020.
 */
public class isPalindrome234 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode head = null ;//new ListNode(1);
        /*ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);*/
        /*head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;*/
        System.out.println(new isPalindrome234().isPalindromeI(head));

    }

    /**
     * 如果要我们判断一个数组是否是回文，那么我们直接使用两个指针，一个left指向数组最左边，另一个指针
     * right指向数组最右边，当left<right时，循环结束。
     * 现在我们要对一个链表进行操作，那么我们就需要仔细考虑。因为链表中没法使用一个两个指针同时走，
     * 因此，如果我们要一个从头走，另一个从结尾走，那么我们就只能借助堆栈stack这个数据结构的特性：先进后出。
     * 这样一来我们根据下面的步骤就可以判断这个链表是否是一个回文链表。
     * （1）我们将链表中的元素押入堆栈中
     * （2）我们利用一个指针来curNode，如果stack.pop()出来的ListNode的val不等于curNode.val,那么直接返回false。
     * （3）循环结束，那么此时仍然没有返回，那么我们返回true就可以了
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public boolean isPalindromeI(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while(curNode != null){
            stack.push(curNode);
            curNode = curNode.next;
        }
        curNode = head;
        while(!stack.isEmpty()){
            if(stack.pop().val != curNode.val){
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }

    /**
     * 上面我们使用Stack数据结构实现了时间复杂度O(N)，空间复杂度O(N)。那么我们如何实现空间复杂度为
     * O(N),而时间复杂度为O(1)。
     * @param head
     * @return
     */
    public boolean isPalindromeII(ListNode head) {

        return true;
    }
}
