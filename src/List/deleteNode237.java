package List;

/**
 * 这个题目往往会出错，我们只需要将当前节点的下一个节点(node.next)的val赋值当前node的val；
 * 然后将该node指向下一的节点的下一个节点：node.next = node.next.next;
 * Created by Administrator on 2019\2\19 0019.
 */
public class deleteNode237 {
    private ListNode head;
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
