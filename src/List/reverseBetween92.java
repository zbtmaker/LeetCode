package List;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class reverseBetween92 {
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
        /*head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;*/
        ListNode curNode = new reverseBetween92().reverseBetween(head,1,1);
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

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
