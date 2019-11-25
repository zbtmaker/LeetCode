package list;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\8 0008.
 */
public class reverseList206 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode head = null;//new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        /*head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;*/
        ListNode curNode = new reverseList206().reverseListIII(head);
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /**
     * 这是第一种方法，我们使用一个双层循环的方式来，我们每一次用一个curNode = head的从头遍历到尾，
     * 然后利用一个preNode来记录curNode的前一个Node，然后我们将preNode.next = null,curNode.next = preNode
     * 困难的地方在于我们如果记录翻转之后的链表的头结点，因此我采用了一个i来记录第几次碰到头结点，如果是第1次
     * 或者是第0次，那么此时我们需要做的就是将dumyNode指向这个节点，否则什么都不做。最后返回dumyNode.next。
     * 这种方法的时间复杂度是O(n^2)，空间复杂的为O(1);
     * @param head
     * @return
     */
    public ListNode reverseListI(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dumyNode = new ListNode(0);
        dumyNode.next = head;
        ListNode preNode;
        ListNode curNode;
        int i = 1;
        while(true){
            curNode = head;
            preNode = null;
            while(curNode.next != null){
                preNode = curNode;
                curNode = curNode.next;
            }
            if(preNode != null){
                preNode.next = null;
                curNode.next = preNode;
            }else{
                break;
            }
            if(i == 1){
                dumyNode.next = curNode;
            }
            i++;
        }
        return dumyNode.next;
    }

    /**
     * 上面我们已经有了一个时间复杂度O(n^2)的算法了，那么下面我们利用空间换时间的思路来讲算法的
     * 时间复杂度变为O(n),同时将空间复杂度为O(n)。既然是翻转一个链表，堆栈这种数据结构就是先进后出的。
     * 因此我们可以让链表的元素进行入栈，然后出栈，这样链表就可以实现翻转了。此种方法实际的操作是O(2N);
     * 空间复杂度为O(N)。
     * @param head
     * @return
     */
    public ListNode reverseListII(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curNode = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(curNode != null){
            stack.push(curNode);
            curNode = curNode.next;
        }
        curNode = stack.pop();
        head = curNode;

        while(!stack.isEmpty()){
            curNode.next = stack.pop();
            curNode = curNode.next;
            curNode.next = null;
        }
        return head;
    }

    /**
     * |   方法   |时间复杂度|空间复杂度|
     * |   循环   |  O(N^2) |   O(1)  |
     * |   堆栈   |  O(N)   |   O(N)  |
     * |   递归   |  O(N)   |   O(1)  |
     * 既然上面我们实现了堆栈的方法，我们知道对于递归的方法就是将参数传递下去，同时在
     * @param head
     * @return
     */
    public ListNode reverseListIII(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        if(preNode != null){
            return preNode;
        }else{
            return curNode;
        }
    }
}
