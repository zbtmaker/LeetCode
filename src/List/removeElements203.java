package List;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class removeElements203 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        removeElements203 rem = new removeElements203();

        ListNode h = new ListNode(4);
        ListNode h1 = new ListNode(4);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(1);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;

        ListNode curNode = rem.removeElements1(h,4);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
    public ListNode removeElements(ListNode head,int val) {
        ListNode preNode = head;
        ListNode curNode = head;
        while(curNode != null){
            if(curNode.val == val && curNode == head){
                preNode = curNode.next;
                //curNode = curNode.next;
                head = curNode.next;
            }else if(curNode.val == val && curNode != head){
                preNode.next = curNode.next;
                //curNode = curNode.next;
            }else{
                preNode = curNode;
                //curNode = curNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
    public ListNode removeElements1(ListNode head,int val) {

        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;
        while(curNode != null){
            if(curNode.val == val){

                curNode = curNode.next;
                preNode.next = curNode;

            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
           // curNode = curNode.next;
        }
        return dumyNode.next;
    }
}
