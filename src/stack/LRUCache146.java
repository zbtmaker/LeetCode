package stack;

import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * @author baitao zou
 * date 2020/01/27
 */
public class LRUCache146 {
    /**
     * 采用HashMap主要是我们需要查找实现O(1)的时间复杂度
     */
    private final Map<Integer, Node> map;
    private final int capacity;
    private int size;

    /**
     * 双向链表，主要是我们在链表更新节点的时候，如果是单节点，每次都需要
     * 从头遍历找到当前节点的头节点，但是我们可以使用双向链表能够很快的得到
     * 当前节点的上一个节点。
     */
    private Node head;
    private Node tail;

    public LRUCache146(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity argument exception");
        }
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }


    /**
     * @param key 查找的Key
     * @return 存在返回value，不存在返回-1
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        refresh(node);
        return node.val;
    }

    /**
     * 更新当前节点的位置，判断头节点，尾节点以及中间节点三种情况，
     *
     * @param node 需要被更新的节点
     */
    private void refresh(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            //更新尾节点
            tail = tail.last;
            tail.next = null;

            //更新头节点
            node.next = head;
            head.last = node;
            head = node;
        } else {
            //更新当前节点的上下节点
            Node lastNode = node.last;
            Node nextNode = node.next;
            lastNode.next = nextNode;
            nextNode.last = lastNode;

            //更新头节点
            node.last = null;
            node.next = head;
            head.last = node;
            head = node;
        }
    }

    /**
     * put操作有一个值的注意的地方就是，如果key存在cache当中，此时需要操作两步，
     * 第一步是更新当前key对应的value，于此同时还需要把这个节点更新到头节点上，如果
     * 这个节点是尾节点还需要更新尾节点位置，所有的这些操作都由refresh操作完成。
     *
     * @param key   键
     * @param value 值
     */
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            refresh(node);
            return;
        }
        Node node = new Node(key, value);
        if (head == null || tail == null) {
            head = node;
            tail = node;
            size++;
        } else if (size + 1 <= capacity) {
            size++;
            node.next = head;
            head.last = node;
            head = node;
        } else {
            size = capacity;
            //更新头节点
            node.next = head;
            head.last = node;
            head = node;

            //删除HashMap中尾节点值
            map.remove(tail.key);

            //更新尾节点
            tail = tail.last;
            tail.next = null;
        }
        map.put(key, node);
    }

    private static class Node {
        private final int key;
        private int val;
        private Node next;
        private Node last;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
