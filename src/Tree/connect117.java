package Tree;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class connect117 {
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
        //node1.left = node3;
        //node1.right = node4;

        Node node5 = new Node();node5.val = 6;
        Node node6 = new Node();node6.val = 7;
        node2.left = node5;
        node2.right = node6;

        new connect117().connect(root);
    }

    /**
     * 这里采用的还是递归的方式来解决这个问题，但是需要解决的问题是我们必须先递归右边，
     * 因为如果先递归左边的话，那么会导致root.next == null,这就
     * @param root
     * @return
     */
    public Node connect(Node root) {
        recurConnect(root);
        return root;
    }

    private void recurConnect(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        Node nextNode = recurNext(root.next);
        if(root.left == null){  //root.right != null
            root.right.next = nextNode;

        }else if(root.right == null){ //root.left != null
            root.left.next = nextNode;

        }else{ //root.left != null && root.right != null
            root.left.next = root.right;
            root.right.next = nextNode;
        }
        recurConnect(root.right);
        recurConnect(root.left);

    }

    /**
     * 找到当前节点下一层最左的节点
     * @param curNode
     * @return
     */
    private Node recurNext(Node curNode){
        while(curNode != null){
            if(curNode.left != null){
                return curNode.left;
            }
            if(curNode.right != null){
                return curNode.right;
            }
            curNode = curNode.next;

        }
        return null;
    }
}
