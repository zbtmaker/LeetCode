package List;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class mergeKLists23 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        for(int i = 1;i<lists.length;i++){
            lists[0] = mergeTwoLists(lists[0],lists[i]);

        }
        return lists[0];
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        ListNode currNode3 = null;
        ListNode newNode = null;
        while(currNode1 != null && currNode2 != null){
            if(currNode1.val < currNode2.val){
                newNode = new ListNode(currNode1.val);
                currNode1 = currNode1.next;
            }else{
                newNode = new ListNode(currNode2.val);
                currNode2 = currNode2.next;
            }
            if(head == null){
                head = newNode;
                currNode3 = head;
            }else{
                currNode3.next = newNode;
                currNode3 = currNode3.next;
            }
        }
        if(currNode2 != null){
            while(currNode2 != null){
                newNode = new ListNode(currNode2.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode2 = currNode2.next;
            }
        }else {
            while(currNode1 != null){
                newNode = new ListNode(currNode1.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode1 = currNode1.next;
            }

        }
        return head;
    }
}
