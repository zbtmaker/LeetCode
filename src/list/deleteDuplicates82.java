package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class deleteDuplicates82 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        deleteDuplicates82 del = new deleteDuplicates82();

        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(2);
        /*ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);*/
        h.next = h1;
        /*h1.next = h2;
        h2.next = h3;*/


        ListNode curNode = del.deleteDuplicates(h);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;
        while(curNode != null){
            if(curNode.next != null && curNode.val == curNode.next.val){

                while(curNode.next != null && curNode.val == curNode.next.val){
                    curNode = curNode.next;
                }
                curNode = curNode.next;
                preNode.next = curNode;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return dumyNode.next;
    }
}
