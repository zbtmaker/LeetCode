package list;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class reverseKGroup25 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        ListNode curNode = new reverseKGroup25().reverseKGroup(head,4);
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

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
        if(preNode != null){
            return preNode;
        }else{
            return curNode;
        }
    }
}
