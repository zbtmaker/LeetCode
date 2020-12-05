package list;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class AddTwoNumbersI2 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;

        int sum;
        int carry = 0;

        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        ListNode preNode = dummyNode;
        ListNode node;
        while(curNode1 != null && curNode2 != null){
            sum = curNode1.val + curNode2.val+carry;
            carry = sum / 10;
            sum = sum % 10;

            preNode.next = new ListNode(sum);
            preNode = preNode.next;
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        while(curNode1 != null){
            sum = curNode1.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            preNode.next = new ListNode(sum);
            preNode = preNode.next;
            curNode1 = curNode1.next;
        }
        while(curNode2 != null){
            sum =  curNode2.val+carry;
            carry = sum / 10;
            sum = sum % 10;

            preNode.next = new ListNode(sum);
            preNode = preNode.next;
            curNode2 = curNode2.next;
        }
        if(carry != 0){
            node = new ListNode(carry);
            preNode.next = node;
        }
        return dummyNode.next;
    }
}
