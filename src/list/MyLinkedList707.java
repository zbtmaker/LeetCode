package list;

/**
 * LeetCode707:https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author baitao zou
 * date 2020/05/31
 */
public class MyLinkedList707 {
    private int size;

    private Node head;
    private Node tail;

    private static class Node {
        private int val;
        private Node last;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList707() {
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        if (index == 0) {
            return head.val;
        } else if (index == size - 1) {
            return tail.val;
        } else {
            int i = 0;
            Node curNode = head;
            while (i < index) {
                curNode = curNode.next;
                i++;
            }
            return curNode.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        size++;
        Node curNode = new Node(val);
        if (head == null) {
            head = curNode;
            tail = curNode;
            return;
        }
        curNode.next = head;
        head.last = curNode;
        head = curNode;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size++;
        Node curNode = new Node(val);
        if (head == null) {
            head = curNode;
            tail = curNode;
            return;
        }
        tail.next = curNode;
        curNode.last = tail;
        tail = curNode;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        Node node = new Node(val);
        //插入头节点
        if (index <= 0) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.last = node;
                node.next = head;
                head = node;
            }

        } else if (index == size) {
            node.last = tail;
            tail.next = node;
            tail = node;
        } else {
            int i = 0;
            Node curNode = head;
            while (i < index) {
                curNode = curNode.next;
                i++;
            }
            node.next = curNode;
            node.last = curNode.last;
            curNode.last.next = node;
            curNode.last = node;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        //删除头节点
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
        }
        //删除尾节点
        else if (index == size - 1) {
            tail = tail.last;
            tail.next = null;

        } else {
            int i = 0;
            Node curNode = head;
            while (i < index) {
                curNode = curNode.next;
                i++;
            }
            curNode.next.last = curNode.last;
            curNode.last.next = curNode.next;
        }

        size--;
    }
}
