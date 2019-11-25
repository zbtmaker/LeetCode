package graph;

import java.util.*;

public class CloneGraph133 {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 使用广度有限
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return null;
    }

    /**
     * 广度优先深度
     *
     * @param node
     */
    public void breadthFirstSearch(Node node) {
        Stack<Node> pushStack = new Stack<>();
        Stack<Node> pullStack = new Stack<>();
        pullStack.push(node);
        Map<Node, String> map = new HashMap<>();
        while (!pushStack.isEmpty() || !pullStack.isEmpty()) {
            if(pullStack.isEmpty()){
                while (!pushStack.isEmpty()) {
                    pullStack.push(pushStack.pop());
                }
            }

            Node node1 = pullStack.pop();

            for (Node tmpNode : node1.neighbors) {
                if (!map.containsKey(tmpNode)) {
                    pushStack.push(tmpNode);
                }
            }
            System.out.println(node1.val);
            map.put(node1, "");
        }
    }

    /**
     * 深度优先比遍历
     *
     * @param node
     */
    public void depthFirstSearch(Node node) {
        Map<Node, String> map = new HashMap<>();
        recurDepthFirstSearch(node, map);
    }

    /**
     * 递归深度优先遍历
     *
     * @param node
     * @param map
     */
    public void recurDepthFirstSearch(Node node, Map<Node, String> map) {
        if (node == null) {
            return;
        }
        map.put(node, "");
        for (Node tmpNode : node.neighbors) {
            if (!map.containsKey(tmpNode)) {
                recurDepthFirstSearch(tmpNode, map);
                System.out.println(tmpNode.val);
            }
        }
    }

}
