package List;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class reorderList143 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        //ListNode h4 = new ListNode(5);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;
        //h3.next = h4;
        new reorderList143().reorderList(headA);
        ListNode curNode = headA;
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
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
