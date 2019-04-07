package List;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class middleNode876 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        deleteDuplicates83 del = new deleteDuplicates83();

        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;

        ListNode curNode = new middleNode876().middleNode(headA);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
    public ListNode middleNode(ListNode head) {
        ListNode curNode = head;
        int count = 0;
        while(curNode != null){
            count++;
            curNode = curNode.next;
        }
        int middle = count>>1;
        curNode = head;
        while(middle>0){
            curNode = curNode.next;
            middle -- ;
        }
        return curNode;
    }
}
