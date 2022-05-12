package design;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考文档：https://arxiv.org/pdf/2110.11602.pdf
 *
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
    private final Map<Integer, Node> keyMapNode;

    /**
     * freq对应的节点
     */
    private final Map<Integer, FreqNode> freqNodeMap;

    private FreqNode freqHead;

    private FreqNode freqTail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyMapNode = new HashMap<>(capacity);
        this.freqNodeMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node curNode = keyMapNode.get(key);
        if (curNode == null) {
            return -1;
        }
        updateFreqNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Node curNode = keyMapNode.get(key);
        int curFreq = 1;
        if (curNode == null) {
            curNode = new Node(key, value, curFreq);
            keyMapNode.put(key, curNode);
            if (size + 1 > capacity) {
                size--;
                removeLeastFrequencyNode();
            }
            insertNode(curNode);
            size++;
        } else {
            curNode.val = value;
            updateFreqNode(curNode);
        }
    }

    /**
     * 移除最少使用的节点
     */
    private void removeLeastFrequencyNode() {
        if (freqHead.sameFreqHead == freqHead.sameFreqTail) {
            keyMapNode.remove(freqHead.sameFreqHead.key);
            freqHead.sameFreqHead = null;
            freqHead.sameFreqTail = null;
            freqNodeMap.remove(freqHead.freq);
            if (freqHead == freqTail) {
                freqHead = null;
                freqTail = null;
            } else {
                freqHead = freqHead.forward;
                freqHead.backward = null;
            }
        } else {
            keyMapNode.remove(freqHead.sameFreqTail.key);
            freqHead.sameFreqTail = freqHead.sameFreqTail.last;
            freqHead.sameFreqTail.next = null;
        }
    }

    /**
     * 将节点插入到与之相同freq对应的FreqNode的链表头处
     *
     * @param curNode 相同freq的节点
     */
    private void insertNode(Node curNode) {
        int curFreq = curNode.freq;
        FreqNode freqNode = freqNodeMap.get(curFreq);
        if (freqNode == null) {
            freqNode = new FreqNode();
            freqNode.freq = curFreq;
            freqNode.sameFreqHead = curNode;
            freqNode.sameFreqTail = curNode;
            freqNodeMap.put(curFreq, freqNode);
            if (freqHead == null) {
                freqHead = freqNode;
                freqTail = freqNode;
            } else {
                freqNode.forward = freqHead;
                freqHead.backward = freqNode;
                freqHead = freqNode;
            }
        } else {
            freqNode.sameFreqHead.last = curNode;
            curNode.next = freqNode.sameFreqHead;
            freqNode.sameFreqHead = curNode;
        }
    }


    /**
     * 将节点插入新的freq的节点
     *
     * @param curNode 节点
     */
    private void updateFreqNode(Node curNode) {
        int curFreq = curNode.freq;
        FreqNode freqNode = freqNodeMap.get(curFreq);

        // 将节点从freqNode中删除
        removeFromLastFreqNode(curNode, freqNode);

        // 将节点插入nextFreq节点
        insertToNextFreqNode(curNode, freqNode);

        // 判断当前节点是否删除
        updateFreqNode(freqNode);
    }

    /**
     * 从当前freq的链表中删除curNode
     *
     * @param curNode 节点
     */
    private void removeFromLastFreqNode(Node curNode, FreqNode freqNode) {
        // 将节点从freqNode中删除
        if (freqNode.sameFreqHead == curNode && freqNode.sameFreqTail == curNode) {
            freqNode.sameFreqHead = null;
            freqNode.sameFreqTail = null;
        } else if (freqNode.sameFreqTail == curNode) {
            freqNode.sameFreqTail = curNode.last;
            freqNode.sameFreqTail.next = null;
        } else if (freqNode.sameFreqHead == curNode) {
            freqNode.sameFreqHead = curNode.next;
            freqNode.sameFreqHead.last = null;
        } else {
            curNode.last.next = curNode.next;
            curNode.next.last = curNode.last;
        }
        curNode.last = null;
        curNode.next = null;
    }

    /**
     * 插入下一个freq节点的链表
     *
     * @param curNode 节点
     */
    private void insertToNextFreqNode(Node curNode, FreqNode freqNode) {
        // 将节点插入nextFreq节点
        int nextFreq = curNode.freq + 1;
        curNode.freq = nextFreq;
        FreqNode nextFreqNode = freqNodeMap.get(nextFreq);
        if (nextFreqNode == null) {
            nextFreqNode = new FreqNode();
            nextFreqNode.freq = nextFreq;
            nextFreqNode.sameFreqHead = curNode;
            nextFreqNode.sameFreqTail = curNode;

            freqNodeMap.put(nextFreq, nextFreqNode);

            if (freqNode.forward == null) {
                // 此时说明nextFreqNode插入到尾节点
                freqNode.forward = nextFreqNode;
                nextFreqNode.backward = freqNode;
                freqTail = nextFreqNode;
            } else {
                nextFreqNode.forward = freqNode.forward;
                freqNode.forward.backward = nextFreqNode;

                nextFreqNode.backward = freqNode;
                freqNode.forward = nextFreqNode;
            }
        } else {
            nextFreqNode.sameFreqHead.last = curNode;
            curNode.next = nextFreqNode.sameFreqHead;
            nextFreqNode.sameFreqHead = curNode;
        }
    }

    private void updateFreqNode(FreqNode freqNode) {
        if (freqNode.sameFreqTail == null && freqNode.sameFreqHead == null) {
            freqNodeMap.remove(freqNode.freq);
            // 删除freq链表
            if (freqNode == freqHead && freqNode == freqTail) {
                freqHead = null;
                freqTail = null;
            } else if (freqNode == freqHead) {
                freqHead = freqNode.forward;
                freqHead.backward = null;
            } else if (freqNode == freqTail) {
                freqTail = freqNode.backward;
                freqTail.forward = null;
            } else {
                freqNode.backward.forward = freqNode.forward;
                freqNode.forward.backward = freqNode.backward;
            }
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
