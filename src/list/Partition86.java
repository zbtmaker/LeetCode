package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;

        ListNode curNode = head;
        ListNode smallNode= dumyNode;
        ListNode preNode = dumyNode;

        while(curNode != null){
            if(curNode.val < x && curNode != smallNode.next){
                preNode.next = curNode.next;
                curNode.next = smallNode.next;
                smallNode.next = curNode;
                smallNode = curNode;

                curNode = preNode.next;
            }else if(curNode.val < x && curNode == smallNode.next){
                preNode = curNode;
                smallNode = curNode;
                curNode = curNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return dumyNode.next;
    }
}
