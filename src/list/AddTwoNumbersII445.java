package list;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class AddTwoNumbersII445 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：这里我们借助堆栈Stack来实现两个链表的相加。具体步骤如下：
     * （1） 将两个链表分别入栈
     * （2） 将两个链表出栈，因此出栈的元素出栈以后相加，同时我们还需要加上前面的进位位(sum = stack1.pop().val + stack2.pop().val+carray;)
     * 得到的sum，因为超过sum超过9就需要进位了，由sum % 10得到本位为basic，由basic / 10 得到进位位。
     * （3） 我们将本位(basic)构造成一个ListNode(node = new ListNode(basic);)，并将这个节点指向前一个节点。
     * （4） 因为可能出现一个链表长一个链表短的情况，因此需要将对于那个长的链表单独像步骤（2）那样进行处理。
     * （5） 最后需要对carry尽心判断，如果carry位不为零，那么需要重新构造一个节点，如果carry为为零，那么就不需要重新构造一个节点作为头结点。
     * 时间复杂度和空间复杂度分析：因为我们只有一次入栈和一次出栈因此时间复杂度为为4N（其中N表示最长的那个链表的长度）
     * 空间复杂度我们使用两个堆栈，因此空间复杂度为O(N+M)。
     * <p>
     * 进一步改进：这里我们的时间复杂度为O(N),空间复杂度为O(1)；
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        push(stack1, l1);
        push(stack2, l2);
        int sum;
        int carry = 0;
        ListNode curNode = null;
        ListNode lastNode;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = stack1.pop().val + stack2.pop().val + carry;
            carry = sum / 10;
            sum = sum % 10;
            lastNode = new ListNode(sum);
            lastNode.next = curNode;
            curNode = lastNode;
        }
        while (!stack1.isEmpty()) {
            sum = stack1.pop().val + carry;
            carry = sum / 10;
            sum = sum % 10;
            lastNode = new ListNode(sum);
            lastNode.next = curNode;
            curNode = lastNode;
        }
        while (!stack2.isEmpty()) {
            sum = stack2.pop().val + carry;
            carry = sum / 10;
            sum = sum % 10;
            lastNode = new ListNode(sum);
            lastNode.next = curNode;
            curNode = lastNode;
        }
        if (carry != 0) {
            lastNode = new ListNode(carry);
            lastNode.next = curNode;
            curNode = lastNode;
        }
        return curNode;
    }

    /**
     * @param stack
     * @param l
     */
    private void push(Stack<ListNode> stack, ListNode l) {
        ListNode curNode = l;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
    }
}
