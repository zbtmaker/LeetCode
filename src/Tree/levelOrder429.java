package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class levelOrder429 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static void main(String[] args){
        Node root = new Node(1,null);
        Node node1 = new Node(3,null);
        Node node2 = new Node(2,null);
        Node node3 = new Node(4,null);
        Node node4 = new Node(5,null);
        Node node5 = new Node(6,null);

        List<Node> l0 = new ArrayList<>();
        l0.add(node1);
        l0.add(node2);
        l0.add(node3);
        root.children = l0;

        List<Node> l1 = new ArrayList<>();
        l1.add(node4);
        l1.add(node5);
        node1.children = l1;

        List<List<Integer>> lists = new levelOrder429().levelOrder(root);

        System.out.println("[");
        for(int i = 0;i<lists.size();i++){
            List<Integer> list = lists.get(i);
            System.out.print("[");
            for(Integer integer : list){
                System.out.print(integer+",");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Stack<Node> dequeue = new Stack();
        Stack<Node> enqueue = new Stack();

        Node curNode = root;

        dequeue.push(curNode);

        while(!dequeue.isEmpty() || !enqueue.isEmpty()){
            if(dequeue.isEmpty()){
                while(!enqueue.isEmpty()){
                    dequeue.push(enqueue.pop());
                }
            }

            List<Integer> list = new ArrayList<>();

            while(!dequeue.isEmpty()){
                curNode = dequeue.pop();
                list.add(curNode.val);
                if(curNode.children != null){
                    List<Node> nodes = curNode.children;
                    for(Node node : nodes){
                        enqueue.push(node);
                    }
                }

            }

            lists.add(list);
        }
        return lists;
    }
}
