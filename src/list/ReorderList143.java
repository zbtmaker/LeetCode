package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class ReorderList143 {
    public void reorderList(ListNode head) {
        ListNode curNode = head;
        while(curNode != null){
            ListNode preNode = null;
            ListNode tmpNode = curNode;

            while(tmpNode.next != null){
                preNode = tmpNode;
                tmpNode = tmpNode.next;
            }
            if(preNode == null){
                break;
            }else{
                preNode.next = null;
                tmpNode.next = curNode.next;
                curNode.next = tmpNode;
                curNode = tmpNode.next;
            }
        }
    }
}
