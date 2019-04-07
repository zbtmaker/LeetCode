package List;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class swapPairs24 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        /*ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;*/


        ListNode curNode = new swapPairs24().swapPairs(headA);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;

        while(curNode != null){
            ListNode nextNode = curNode.next;
            if(nextNode == null){
                break;
            }
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            preNode.next = nextNode;

            preNode = curNode;
            curNode = curNode.next;

        }
        return dumyNode.next;
    }
}
