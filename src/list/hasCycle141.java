package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class hasCycle141 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);

        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);

        l1.next = l1;/*l12.next = l13;l13.next = l14;l14.next = l15;*/
        //l14.next = l14;
        System.out.println(new hasCycle141().hasCycleII(l1));
    }

    /**
     * 这里忽略了一个问题就是其实这个问题就是相当于在一个数组中找到一个重复的元素，因为链表如果存在一个环，那么
     * 我们任意两个ListNode的hashCode值是相同的，因此HashMap在比较两个ListNode时，就会判断ListNode的HashNode是
     * 否相同。
     * @param head
     * @return
     */
    public boolean hasCycleI(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        int i = 1;
        ListNode curNode = head;
        while(curNode != null){
            if(map.containsKey(curNode)){
                return true;
            }else{
                map.put(curNode,i++);
            }
            curNode = curNode.next;
        }
        return false;

    }
    public boolean hasCycleII(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode curNodeA = head;
        ListNode curNodeB = head.next.next;

        while(curNodeB.next != null){
            if(curNodeA == curNodeB){
                return true;
            }
            curNodeA = curNodeA.next;
            curNodeB = curNodeB.next.next;
        }
        return false;
    }
}
