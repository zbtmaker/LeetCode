package tree;

import java.util.*;

/**
 * @author Baitao Zou
 * date 2019/2/22 0022.
 */
public class LevelOrder429 {
    /**
     * 方法一：程序采用的栈
     * 方法二：递归调用的栈
     *
     * @param root 多叉树根节点
     * @return 层次遍历节点
     */
    public List<List<Integer>> levelOrder(Node root) {
        return levelOrderByRecur(root);
    }

    /**
     * 采用栈实现队列方式
     *
     * @param root 二叉树根节点
     * @return 多叉树遍历方式
     */
    private List<List<Integer>> levelOrderByStack(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<Node> dequeue = new Stack<>();
        Stack<Node> enqueue = new Stack<>();

        Node curNode = root;

        dequeue.push(curNode);

        while (!dequeue.isEmpty() || !enqueue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }

            List<Integer> list = new LinkedList<>();

            while (!dequeue.isEmpty()) {
                curNode = dequeue.pop();
                list.add(curNode.val);
                if (curNode.children != null) {
                    List<Node> nodes = curNode.children;
                    for (Node node : nodes) {
                        enqueue.push(node);
                    }
                }
            }

            lists.add(list);
        }
        return lists;
    }

    private List<List<Integer>> levelOrderByRecur(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        recur(Collections.singletonList(root), result);
        return result;
    }

    /**
     * 递归遍历多叉树节点，采用JVM自身的递归
     *
     * @param nodes  当前层节点
     * @param result 遍历结果
     */
    private void recur(List<Node> nodes, List<List<Integer>> result) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        List<Node> nextNodes = new LinkedList<>();
        List<Integer> values = new LinkedList<>();
        for (Node node : nodes) {
            List<Node> curNoes = node.children;
            if (curNoes != null && curNoes.size() > 0) {
                nextNodes.addAll(curNoes);
            }
            values.add(node.val);
        }
        result.add(values);
        recur(nextNodes, result);
    }
}
