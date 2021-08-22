package list;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class partition86 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(4);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(2);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(2);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        ListNode curNode = new partition86().partition(headA,3);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
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
