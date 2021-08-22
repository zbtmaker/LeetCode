package list;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class ReverseKGroup25 {

    /**
     * 这个题目借鉴的是reverseBetween92和reverseList206，其中我们每次都会将一组链表进行翻转，
     * 同时我们在每次翻转的过程中需要记录一下这个group的头结点和为节点以及前一个group的尾节点。
     * 那么我们将index % K 作为group的分割线，此外我们需要注意的是如果最后一个分组小于K，那么
     * 我们之前翻转的部分需要重新翻转，所以我又调用了
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        dumyNode.next = head;
        ListNode preNode = dumyNode;
        ListNode curNode = head;
        ListNode tmpPreNode = null;
        ListNode tmpTail = curNode;
        int index = 1;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = tmpPreNode;
            tmpPreNode = curNode;
            curNode = nextNode;
            if(index % k == 0 ){
                tmpTail.next = curNode;
                preNode.next = tmpPreNode;

                preNode = tmpTail;
                tmpTail = curNode;
                tmpPreNode = null;
            }else if(index % k != 0 && curNode == null){
                preNode.next = reverseList(tmpPreNode);
            }
            index ++;
        }
        return dumyNode.next;
    }

    /**
     * 当最后一个分组的元素小于K，那么我们将最后一个节点的分组节点再一次调用翻转链表的
     * 方案实现。
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
