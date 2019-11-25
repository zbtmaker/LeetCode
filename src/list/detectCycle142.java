package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class detectCycle142 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode l1 = null;/*new ListNode(1);

        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);

        l1.next = l12;l12.next = l13;l13.next = l14;l14.next = l15;*/
        //l14.next = l14;
        ListNode curNode = new detectCycle142().detectCycle(l1);
        if(curNode == null){
            System.out.println("null");
        }else{
            System.out.println(curNode.val);
        }

    }
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        int i = 1;
        ListNode curNode = head;
        while(curNode != null){
            if(map.containsKey(curNode)){
                return curNode;
            }else{
                map.put(curNode,i++);
            }
            curNode = curNode.next;
        }
        return null;

    }
}
