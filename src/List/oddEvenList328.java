package List;

/**
 * Created by Administrator on 2019\2\20 0020.
 */
public class oddEvenList328 {
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
        ListNode curNode = new oddEvenList328().oddEvenList(head);
        while(curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /**
     * 这个题目比较巧的是可以在原地将链表中的元素进行分块，我们利用一个oddNode表示奇数链表的最后一个元素；
     * 而evenNode表示偶数链表的最后一个元素。这里的最后一个元素表示在curNode之前的最后一个奇/偶节点。
     * 例如：1------>2------>3--->4--->5
     *      ^       ^       ^
     *    oddNode evenNode curNode
     * 有了上面的指针以后，我们还需要做的一件事就是记录我们的节点是一个奇节点还是一个偶节点，因此我用了一个
     * 参数 i 来表示下标，当时奇节点的时候，我们需要做的步骤如下：
     * （1） 将当前节点节点的下一个节点赋值给evenNode的下一个节点(evenNode.next = curNode.next;)
     * （2） 将oddNode的下一个节点赋值给oddNode的下一个节点：防止evenNode头结点信息丢失(curNode.next = oddNode.next;)
     * （3） 将oddNode的下一个节点更新为当前节节点(oddNode.next = curNode;)
     * （4） 此时curNode便是奇链表的最后一个节点，将oddNode更新为curNode(oddNode = curNode;)
     * （5） 所有事情都做完了以后就需要更新curNode值
     * 如果节点为偶节点时，那么此时我们只需要更新偶节点的最后一个节点，以及更新一下curNode的信息
     * 最后但同等重要的是，我们不管节点时奇/偶，我们都需要更细下标i的值
     * 同时我们需要判断对于head == null或者是head.next == null时直接返回就可以了。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode curNode = evenNode.next;
        int i = 3;
        while(curNode != null){
            if(i % 2 == 1){
                evenNode.next = curNode.next;

                curNode.next = oddNode.next;

                oddNode.next = curNode;

                oddNode = curNode;

                curNode = evenNode.next;
            }else{
                evenNode = evenNode.next;
                curNode = curNode.next;
            }
            i++;
        }
        return head;
    }
}
