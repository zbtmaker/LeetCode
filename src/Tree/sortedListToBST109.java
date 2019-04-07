package Tree;

/**
 * Created by Administrator on 2019\3\10 0010.
 */
public class sortedListToBST109 {
    public static void main(String[] args){
        ListNode head = null;//new ListNode(-10);
        /*ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;*/
        sortedListToBST109 listTree = new sortedListToBST109();
        TreeNode root = listTree.sortedListToBST(head);
        listTree.inorder(root);

    }
    private static class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    private static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val){
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
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val+"->");
        inorder(root.right);
    }
}
