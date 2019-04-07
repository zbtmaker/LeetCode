package List;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class removeNthFromEnd19 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);

        l1.next = l12;l12.next = l13;l13.next = l14;

        ListNode curNode = new removeNthFromEnd19().removeNthFromEnd(l1,5);

        while(curNode != null){
            if(curNode.next == null){
                System.out.print(curNode.val);
            }else{
                System.out.print(curNode.val + "->");
            }

            curNode = curNode.next;
        }

    }

    /**
     * 如果要删除一个链表的倒数第N个节点，那么我们就用一个curNodeA先走N-1步，然后可以用另一个指针curNodeB从head开始走，一旦
     * curNodeA到达节点末尾，那么就可以进行节点删除操作了。时间复杂度为O(N)，空间复杂度为O(1)。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curNodeA = head;
        int i = 1;
        while(i<n && curNodeA != null){
            curNodeA = curNodeA.next;
            i++;
        }
        if(curNodeA == null){
            return head;
        }
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNodeB = head;
        while(curNodeA.next != null){
            preNode = curNodeB;
            curNodeA = curNodeA.next;
            curNodeB = curNodeB.next;
        }
        preNode.next = curNodeB.next;
        curNodeB.next = null;
        return dumyNode.next;
    }
}
