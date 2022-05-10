package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/05/10
 */
public class LFUCache {
    /**
     * Cache 容量大小
     */
    private final int capacity;

    /**
     * 实际的key大小
     */
    private int size;

    /**
     * key对应的节点
     */
    private Map<Integer, Node> keyMapNode;

    /**
     * freq对应的节点
     */
    private Map<Integer, FreqNode> freqNodeMap;

    private FreqNode freqHead;

    private FreqNode freqTail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyMapNode = new HashMap<>(16);
        this.freqNodeMap = new HashMap<>(16);
    }

    public int get(int key) {
        Node curNode = keyMapNode.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        Node curNode = keyMapNode.get(key);
        if (curNode == null) {
            curNode = new Node(key, value, 1);
        } else {
            curNode.val = value;
        }
        size++;
        if (size > capacity) {

        } else {

        }
    }


    private void updateNode(Node curNode) {
        // 从当前的freq 指向的same freq链表中删除
        int curFreq = curNode.freq;

        FreqNode freqNode = freqNodeMap.get(curFreq);
        FreqNode curBackward = freqNode.backward;
        FreqNode curForward = freqNode.forward;
        if (freqNode.sameFreqHead == curNode && freqNode.sameFreqTail == curNode) {
            freqNode.sameFreqHead = curNode.next;
            freqNode.sameFreqHead.last = null;
            freqNodeMap.remove(curFreq);

            // 删除freq链表
            if (freqNode == freqHead && freqNode == freqTail) {
                freqHead = null;
                freqTail = null;
                curBackward = null;
                curForward = null;
            } else if (freqNode == freqHead) {
                freqHead = freqNode.forward;
                freqHead.backward = null;
                curBackward = null;
                curForward = freqHead;
            } else if (freqNode == freqTail) {
                freqTail = freqNode.backward;
                freqTail.forward = null;
                curBackward = freqTail;
                curForward = null;
            } else {
                freqNode.backward.forward = freqNode.forward;
                freqNode.forward.backward = freqNode.backward;
                curForward = freqNode.forward;
                curBackward = freqNode.backward;
            }
        } else if (freqNode.sameFreqHead == curNode) {
            freqNode.sameFreqHead = curNode.next;
            freqNode.sameFreqHead.last = null;
        } else if (freqNode.sameFreqTail == curNode) {
            freqNode.sameFreqTail = curNode.last;
            freqNode.sameFreqTail.next = null;
        } else {
            curNode.last.next = curNode.next;
            curNode.next.last = curNode.last;
        }
        curNode.last = null;
        curNode.next = null;

        // 插入新的freqNode
        int nextFreq = curFreq + 1;
        curNode.freq = nextFreq;
        FreqNode nextFreqNode = freqNodeMap.get(nextFreq);
        if (nextFreqNode == null) {
            nextFreqNode = new FreqNode();
            nextFreqNode.freq = nextFreq;
            if (curBackward == null && curForward == null) {
                freqHead = nextFreqNode;
                freqTail = nextFreqNode;
            } else if (curForward == null) {
                freqTail.forward = nextFreqNode;
                nextFreqNode.backward = freqTail;
                freqTail = nextFreqNode;
            } else {
                if (curBackward == null) {
                    nextFreqNode.forward = curForward;
                    curForward.backward = nextFreqNode;
                    freqHead = nextFreqNode;
                } else {
                    curBackward.forward = nextFreqNode;
                    nextFreqNode.backward = curBackward;

                    nextFreqNode.forward = curForward;
                    curForward.backward = nextFreqNode;
                }
            }
            freqNodeMap.put(nextFreq, nextFreqNode);
        } else {
            nextFreqNode.sameFreqTail.next = curNode;
            curNode.last = nextFreqNode.sameFreqTail;
            nextFreqNode.sameFreqTail = curNode;
        }
    }

    private static class FreqNode {
        private int freq;

        /**
         * 上一个freq节点
         */
        private FreqNode forward;

        /**
         * 下一个freq节点
         */
        private FreqNode backward;

        /**
         * 相同freq 的头节点
         */
        private Node sameFreqHead;

        /**
         * 相同freq 的尾节点
         */
        private Node sameFreqTail;
    }

    private static class Node {
        private final int key;
        private int val;
        private int freq;
        private Node next;
        private Node last;

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}
