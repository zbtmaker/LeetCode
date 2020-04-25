package list;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * <p>
 * Created by Administrator on 2019\2\20 0020.
 */
public class OddEvenList328 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 这个题目比较巧的是可以在原地将链表中的元素进行分块，我们利用一个oddNode表示奇数链表的最后一个元素；
     * 而evenNode表示偶数链表的最后一个元素。这里的最后一个元素表示在curNode之前的最后一个奇/偶节点。
     * 例如：1------>2------>3--->4--->5
     * ^       ^       ^
     * oddNode evenNode curNode
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
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        /*return oddEvenListByCount(head);*/
        return oddEvenListByDoublePoint(head);
    }

    public ListNode oddEvenListByCount(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode curNode = evenNode.next;
        int i = 3;
        while (curNode != null) {
            if ((i & 1) == 1) {
                evenNode.next = curNode.next;

                curNode.next = oddNode.next;

                oddNode.next = curNode;

                oddNode = curNode;

                curNode = evenNode.next;
            } else {
                evenNode = evenNode.next;
                curNode = curNode.next;
            }
            i++;
        }
        return head;
    }

    /**
     * 这个题目我们也是要分奇偶来讨论的，对于所有从head节点开始的双指针算法，我们
     * 都需要对链表长度为奇数和偶数时分别进行判断，这样我们才能防止空指针异常。
     * 奇数链表:1->2->3
     * initial: oddNode = 1, evenNode = 2, evenHead = evenNode
     * step1: {oddNode:1->3->null, evenNode:2->3->null}, {oddNode:3->null}, {evenNode:2->null}, {oddNode:3->2->null},{evenNode:null}
     * 所以对于长度为3的链表，我们经过一步之后，链表evenNode=null，那么此时我们就需要退出循环了
     * 偶数链表:1->2->3->4
     * initial: oddNode = 1->2->3->4, evenNode = 2->3->4
     * step1: {oddNode:1->3->4->null,evenNode:2->3->4}, {oddNode:3->4->null}, {evenNode:2->4->null}, {oddNode:3->2->4->null},{evenNode:4->null}
     * 这个算法我们还需要规避的两点就是链表是head == null，以及oddNode最后一个节点的指针永远要指向evenNode链表的头节点
     *
     * @param head
     * @return
     */
    public ListNode oddEvenListByDoublePoint(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            oddNode.next = evenHead;
            evenNode = evenNode.next;
        }
        return head;
    }
}
