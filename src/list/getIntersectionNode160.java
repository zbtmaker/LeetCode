package list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\19 0019.
 */
public class getIntersectionNode160 {
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
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        headA.next = h1;
        h1.next = h2;
        h2.next = h3;
        ListNode headB = new ListNode(1);
        ListNode hb1 = new ListNode(4);
        headB.next = hb1;
        hb1.next = h2;
        ListNode curNode = new getIntersectionNode160().getIntersectionNodeI( headA, headB);

        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /**
     * 使用双层循环的方式的时间复杂度是O(NM)，其中N是headA的长度，M是headB的长度
     * 这种方式的运行时间较长，下面应该用Map的方式来减少时间复杂度。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curNodeA = headA;
        while(curNodeA != null){
            ListNode curNodeB = headB;
            while(curNodeB != null){
                if(curNodeB == curNodeA){
                    return curNodeB;
                }else{
                    curNodeB = curNodeB.next;
                }
            }
            curNodeA = curNodeA.next;
        }
        return null;
    }

    /**
     * 使用HashMap的方式来解决，此方式的时间复杂度为O(N+M)。
     * 这种方式得到的运行时间虽然短，但是空间复杂度上去了，下面应该还会有更好的方法。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        ListNode curNodeA = headA;
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        while(curNodeA != null){
            map.put(curNodeA,1);
            curNodeA = curNodeA.next;
        }
        ListNode curNodeB = headB;
        while(curNodeB != null){
            if(map.containsKey(curNodeB)){
                return curNodeB;
            }
            curNodeB = curNodeB.next;
        }
        return null;
    }
}
