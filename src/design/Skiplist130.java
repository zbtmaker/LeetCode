package design;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Baitao Zou
 * date 2021/08/02
 */
public class Skiplist130 {

    private Node root;

    private final Random random = new Random();

    private class Node {

        private int key;
        private Node next, down;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Node next, Node down) {
            this.key = key;
            this.next = next;
            this.down = down;
        }
    }

    public Skiplist130() {
        root = new Node(-1);
    }

    /**
     * 1、在每一层都要找到最后一个满足node.key < target的节点
     * 2、如果当第i层的node.key>target，其实应该是从当前node的上一个节点获取下一层遍历的起始节点
     * 3、如果到了最后一层如果有node.key == target，则返回节点，否则返回的是node.key < target
     *
     * @param target
     * @return
     */
    public boolean search(int target) {
        Node node = this.root;
        while (node != null) {
            while (node.next != null && node.next.key < target) {
                node = node.next;
            }
            if (node.next != null && node.next.key == target) {
                return true;
            }
            node = node.down;
        }
        return false;
    }

    /**
     * 1、对于每一层找到第一个不满足node.next.key >= num,结束当前循环
     * 2、进入下一层执行步骤1
     * 3、重复步骤1和步骤2，直到node == null
     * 4、从最底层开始，开始将当前节点添加到链表，然后每一层执行一样的操作
     *
     * @param num
     */
    public void add(int num) {
        Node node = root;
        LinkedList<Node> nodes = new LinkedList<>();
        while (node != null) {
            while (node.next != null && node.next.key < num) {
                node = node.next;
            }
            nodes.add(node);
            node = node.down;
        }
        Node downNode = null;
        boolean insert = true;
        double l = 1.0;
        while (insert && !nodes.isEmpty()) {
            Node lastNode = nodes.removeLast();
            lastNode.next = new Node(num, lastNode.next, downNode);
            downNode = lastNode.next;
            l /= 2;
            insert = random.nextDouble() > l;
        }

        if (insert) {
            root = new Node(-1, null, root);
        }
    }

    /**
     * 1、对于每一层找到第一个不满足node.next.key >= num时，结束当前层循环；
     * 2、判断node.next.key == num是否成立，如果成立，则将node.next从当前层删除；
     * 3、不管上面的条件是否成立都往下走一层，每一层都循环执行步骤1，2，直到最终node为null。
     *
     * @param num
     * @return
     */
    public boolean erase(int num) {
        Node node = root;
        boolean flag = false;
        while (node != null) {
            while (node.next != null && node.next.key < num) {
                node = node.next;
            }
            if (node.next != null && node.next.key == num) {
                node.next = node.next.next;
                flag = true;
            }
            node = node.down;
        }
        return flag;
    }

}
