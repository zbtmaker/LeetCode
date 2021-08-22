package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class RemoveElements203 {
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
