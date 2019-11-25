package tree;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class connect116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args){
        Node  root = new Node();root.val = 1;
        Node  node1 = new Node();node1.val = 2;
        Node node2 = new Node();node2.val = 3;
        root.left = node1;
        root.right = node2;

        Node node3 = new Node();node3.val = 4;
        Node node4 = new Node();node4.val = 5;
        node1.left = node3;
        node1.right = node4;

        Node node5 = new Node();node5.val = 6;
        Node node6 = new Node();node6.val = 7;
        node2.left = node5;
        node2.right = node6;

        new connect116().connectII(root);
    }
    /**
     * 层次遍历大法好
     * @param root
     * @return
     */
    public Node connectI(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        int levelNum = 1;
        Node curNode = root;
        queue.add(curNode);

        Node dumyNode = new Node();

        while(!queue.isEmpty()){
            int tmpLevelNum = 0;
            Node preNode = dumyNode;
            for(int i = 0;i<levelNum;i++){
                curNode = queue.removeFirst();
                preNode.next = curNode;
                preNode = curNode;
                if(curNode.left != null){
                    queue.add(curNode.left);
                    tmpLevelNum++;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    tmpLevelNum++;
                }
            }
            levelNum = tmpLevelNum;
        }
        return root;
    }

    /**
     * 递归遍历大法好，因为这是一个完美的二叉树，每一个节点都有两个
     * @param root
     * @return
     */
    public Node connectII(Node root) {
        recurConnect(root);
        return root;
    }
    public void recurConnect(Node root){
        if(root.left == null ){
            return;
        }
        root.left.next = root.right;

        if(root.next != null){
            root.right.next = root.next.left;
        }

        recurConnect(root.left);
        recurConnect(root.right);
    }
}
