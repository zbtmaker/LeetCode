package List;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class addTwoNumbersI2 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(8);
        /*ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(3);*/

        l1.next = l12;//l12.next = l13;//l13.next = l14;

        ListNode l2 = new ListNode(0);
        /*ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l2.next = l22;l22.next = l23;*/

        ListNode curNode = new addTwoNumbersI2().addTwoNumbers(l1,l2);

        while(curNode != null){
            if(curNode.next == null){
                System.out.print(curNode.val);
            }else{
                System.out.print(curNode.val + "->");
            }

            curNode = curNode.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;

        int sum = 0;
        int carry = 0;
        int basic = 0;


        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        ListNode preNode = dumyNode;
        ListNode node = null;
        while(curNode1 != null&& curNode2 != null){
            sum = curNode1.val + curNode2.val+carry;
            basic = sum % 10;
            carry = sum / 10;
            node = new ListNode(basic);
            preNode.next = node;
            preNode = node;
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        while(curNode1 != null){
            sum = curNode1.val + carry;
            basic = sum % 10;
            carry = sum / 10;
            node = new ListNode(basic);
            preNode.next = node;
            preNode = node;
            curNode1 = curNode1.next;
        }
        while(curNode2 != null){
            sum =  curNode2.val+carry;
            basic = sum % 10;
            carry = sum / 10;
            node = new ListNode(basic);
            preNode.next = node;
            preNode = node;
            curNode2 = curNode2.next;
        }
        if(carry != 0){
            node = new ListNode(carry);
            preNode.next = node;
            preNode = node;
        }
        return dumyNode.next;
    }
}
