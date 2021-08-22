package list;

/**
 * Created by Administrator on 2019\3\22 0022.
 */
public class sortedListToBST109 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {

        int len = 0;
        ListNode curNode = head;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        return recurSortedListToBST(1,len,head);

    }

    /**
     * 这个题目我使用的就是利用一次遍历找到链表的长度，然后使用left = 0
     * right = len;然后递归的去做，每次找到中点就是这个子树的root，
     * 然后递归的向右走，向左走
     * @param left
     * @param right
     * @param head
     * @return
     */
    private TreeNode  recurSortedListToBST(int left,int right,ListNode head){
        if(left>right){
            return null;
        }
        int middle = (left + right) >>1;


        ListNode curNode = head;

        int i = left;
        while(i<middle){
            curNode = curNode.next;
            i++;
        }
        TreeNode root = new TreeNode(curNode.val);

        root.left = recurSortedListToBST(left,middle-1,head);
        root.right = recurSortedListToBST(middle + 1,right,curNode.next);

        return root;
    }
}
