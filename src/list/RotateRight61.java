package list;

/**
 * 这里通过找规律来发现旋转链表的规律，我们首先构造一个dumyNode指向链表的head。
 * 对于一个长为count的链表，那么我们如果要旋转K次，那么我们就相当于从dumyNode
 * 处出发，然后走count-K + 1次，然后将dumyNode指向这个curNode之后，将curNode
 * 的preNode.next置为最后一个节点，同时链表之前的lastNode需要指向head。
 * Created by Administrator on 2019\2\20 0020.
 */
public class RotateRight61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;
        ListNode lastNode = null;
        int count = 1;
        while(curNode.next != null){
            curNode = curNode.next;
            count++;
        }

        lastNode = curNode;
        k = k % count;
        k = k ==  0 ? 1 : count - k + 1;

        curNode = dumyNode;
        int i = 0;
        while(i<k){
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        preNode.next = null;
        lastNode.next = dumyNode.next;
        dumyNode.next = curNode;

        return dumyNode.next;
    }
}
