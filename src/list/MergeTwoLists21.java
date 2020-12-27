package list;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class MergeTwoLists21 {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        ListNode currNode3 = null;
        ListNode newNode = null;
        while (currNode1 != null && currNode2 != null) {
            if (currNode1.val < currNode2.val) {
                newNode = new ListNode(currNode1.val);
                currNode1 = currNode1.next;
            } else {
                newNode = new ListNode(currNode2.val);
                currNode2 = currNode2.next;
            }
            if (head == null) {
                head = newNode;
                currNode3 = head;
            } else {
                currNode3.next = newNode;
                currNode3 = currNode3.next;
            }
        }
        if (currNode2 != null) {
            while (currNode2 != null) {
                newNode = new ListNode(currNode2.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode2 = currNode2.next;
            }
        } else {
            while (currNode1 != null) {
                newNode = new ListNode(currNode1.val);
                currNode3.next = newNode;
                currNode3 = currNode3.next;
                currNode1 = currNode1.next;
            }

        }
        return head;
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = l1;
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;

        ListNode preNode = dumyNode;
        while (curNode2 != null) {
            while (curNode1 != null && curNode1.val <= curNode2.val) {
                preNode = curNode1;
                curNode1 = curNode1.next;
            }
            preNode.next = curNode2;
            ListNode nextNode2 = curNode2.next;
            curNode2.next = curNode1;
            curNode2 = nextNode2;
            curNode1 = preNode.next;
        }
        return dumyNode.next;
    }
}
