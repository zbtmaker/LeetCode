package list;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class ReverseBetween92 {


    /**
     * 这里借助reverseList206的method3来解决这个题，同时我们还需要一个index指针用于表示我们遍历到
     * 第几个节点了，同时我们定义了一个dumyNode用于解决返回头结点的问题，将dumyNode.next指向我们的头结点
     * 因此
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n){
            return head;
        }
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;
        int index = 1;
        while(curNode != null){
            if(index == m){
                ListNode tmpPreNode = null;
                ListNode tmpTail = curNode;
                while(curNode != null && index >= m && index <= n){
                    ListNode next = curNode.next;
                    curNode.next = tmpPreNode;
                    tmpPreNode = curNode;
                    curNode = next;
                    index ++;
                }
                tmpTail.next = curNode;
                if(preNode != null){
                    preNode.next = tmpPreNode;
                }
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
            index ++;
        }
        return dumyNode.next;
    }
}
