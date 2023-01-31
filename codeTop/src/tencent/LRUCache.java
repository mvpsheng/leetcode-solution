package tencent;

import java.util.HashMap;

/**
 * FileName: LRUCache
 * author: gxs
 * Date: 2022/3/15  15:59
 */
class DListNode {
    private int key;
    private int value;
    DListNode pre;
    DListNode next;

    public DListNode() {
    }

    public DListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class LRUCache {
    private int capacity;
    private DListNode head;
    private DListNode tail;
    HashMap<Integer, DListNode> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            tail.pre.next = map.get(key);
            map.get(key).pre = tail.pre;
            tail.pre = map.get(key);
            map.get(key).next = tail;
            return map.get(key).getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).setValue(value);
            removeNode(map.get(key));
            tail.pre.next = map.get(key);
            map.get(key).pre = tail.pre;
            tail.pre = map.get(key);
            map.get(key).next = tail;
        } else {
            if (map.size() == capacity) {
                DListNode rem = head.next;
                rem.next.pre = head;
                head.next = rem.next;
                map.remove(rem.getKey());
            }
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            tail.pre.next = newNode;
            newNode.next = tail;
            newNode.pre = tail.pre;
            tail.pre = newNode;
        }
    }
    private void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
