package list;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2019\3\2 0002.
 */
public class sortList148 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        ListNode head= null;/*new ListNode(3);
        ListNode h1 = new ListNode(4);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(1);
        ListNode h4 = new ListNode(6);
        ListNode h5 = new ListNode(5);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;*/
        sortList148 sort = new sortList148();
        ListNode curNode = sort.sortList(head);
        while(curNode != null){
            System.out.println(curNode.val+"->");
            curNode = curNode.next;
        }
    }

    /**
     * 不敢提什么高见，那么就用Collections.sort来实现吧，不是单纯的调用
     * Collections.sort方法，而是将head转换成一个数组，然后将其进行排序。
     * 问题是我们不知道这个ListNode的head是多少。那么首先进行一次循环，然后
     * 通过数组的Arrays.sort方法实现排序，但是这里有一个问题就是对于排好序的之后
     * 我们还需要重构这个链表。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        int len = 0;
        ListNode curNode = head;
        while(curNode != null){
            len ++;
            curNode = curNode.next;
        }
        ListNode[] nodes = new ListNode[len];
        curNode = head;
        int i = 0;
        while(curNode != null){
            nodes[i] = new ListNode(curNode.val);
            i++;
            curNode = curNode.next;
        }
        //到上面为止，我们已经花费了2 * N的时间
        //下面花费的时间为O(NlogN),所以总的时间为(3N + NlogN)
        Arrays.sort(nodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }
                if(o1.val > o2.val){
                    return 1;
                }
                return 0;
            }
        });
        ListNode dumyNode = new ListNode(Integer.MAX_VALUE);
        ListNode preNode= dumyNode;
        for(ListNode node : nodes){
            preNode.next = node;
            preNode = node;
        }
        return dumyNode.next;
    }

    /**
     * 之前没有好好考虑问题，那么现在我们参考别人的方法使用mergeSort的思想来
     * 解决这个问题，如何找到一个链表的中点，那么就是找到一个链表的中点，其实这个
     * 题目可以参考一下由有序链表转BST搜索二叉树，那里面的思想很值得借鉴。
     * @param head
     * @return
     */
    public ListNode sortListII(ListNode head) {
        int len = 0;
        ListNode curNode = head;
        while(curNode != null){
            len ++;
            curNode = curNode.next;
        }
        int left = 1;
        int right = len;

        return null;
    }

    private void  mergeSort(ListNode head,int left,int right){
        if(left > right){
            return ;
        }
        int middle = (left + right) >> 1;
        mergeSort(head,left,middle);
        mergeSort(head,middle + 1,right);

    }
}
