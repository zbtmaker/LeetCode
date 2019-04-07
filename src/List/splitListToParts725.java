package List;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class splitListToParts725 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode curNode = root;
        while(curNode != null){
            count ++;
            curNode = curNode.next;
        }
        ListNode[] result = new ListNode[k];
        int num = count / k;
        int res = count % k;
        curNode = root;
        int j = 1;
        ListNode preNode = null;
        while(curNode != null){

        }
        return null;
    }
}
