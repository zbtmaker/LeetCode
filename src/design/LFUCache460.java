package design;

import java.util.*;

/**
 * LeetCode460:https://leetcode-cn.com/problems/lfu-cache
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * @author Baitao Zou
 * date 2020/06/27
 */
public class LFUCache460 {
    /**
     * 容量
     */
    private final int capacity;
    /**
     * Cache中元素的个数
     */
    private int size;
    /**
     * 用于统计每个key-value出现的次数，这里用LinkedHashMap主要是每一个key-value是一个LRU算法
     */
    private TreeMap<Integer, LinkedHashMap<Integer, Node>> freqMap;

    /**
     * 用来存储每个key-value是否存在
     */
    private Map<Integer, Node> keyMap;

    public static class Node {
        private final int key;
        private  int val;
        private int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LFUCache460(int capacity) {
        this.capacity = capacity;
        this.freqMap = new TreeMap<>();
        this.keyMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if(capacity <= 0){
            return -1;
        }
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        int result = node.val;
        //从原来的频次中删除
        LinkedHashMap<Integer, Node> lruMap = freqMap.get(node.freq);
        lruMap.remove(node.key);
        if (lruMap.size() == 0) {
            freqMap.remove(node.freq);
        }
        //自增新的频次
        node.freq = node.freq + 1;

        //添加到新的频次中
        LinkedHashMap<Integer,Node> newLruMap = freqMap.computeIfAbsent(node.freq,k->new LinkedHashMap<>());
        newLruMap.put(node.key, node);
        return result;
    }

    public void put(int key, int value) {
        if(capacity <= 0){
            return;
        }
        Node node = keyMap.get(key);
        if (node != null) {
            node.val = value;
            //从原来的频次中删除
            LinkedHashMap<Integer, Node> lruMap = freqMap.get(node.freq);
            lruMap.remove(node.key);
            if (lruMap.size() == 0) {
                freqMap.remove(node.freq);
            }
            //自增新的频次
            node.freq = node.freq + 1;

            //添加到新的频次中
            LinkedHashMap<Integer,Node> newLruMap = freqMap.computeIfAbsent(node.freq,k->new LinkedHashMap<>());
            newLruMap.put(node.key, node);
        } else {
            //如果size++大于capacity，则先执行一次最小的
            size++;
            if (size > capacity) {
                //删除最小的那个元素
                Map.Entry<Integer, LinkedHashMap<Integer, Node>> firstEntry = freqMap.firstEntry();
                int firstKey = firstEntry.getKey();
                LinkedHashMap<Integer, Node> firstLru = firstEntry.getValue();
                Node firstNode = null;
                for (Iterator<Map.Entry<Integer, Node>> iterator = firstLru.entrySet().iterator(); iterator.hasNext(); ) {
                    firstNode = iterator.next().getValue();
                    break;
                }
                firstLru.remove(firstNode.key);
                keyMap.remove(firstNode.key);
                if (firstLru.isEmpty()) {
                    freqMap.remove(firstKey);
                }
                size--;
            }
            Node newNode = new Node(key, value);
            newNode.freq = 1;
            keyMap.put(key, newNode);
            LinkedHashMap<Integer, Node> newLruMap = freqMap.computeIfAbsent(1, k -> new LinkedHashMap<>());
            newLruMap.put(key,newNode);
        }
    }
}
