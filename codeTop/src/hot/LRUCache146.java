package hot;

import javax.management.ValueExp;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LRUCache146
 * author: gxs
 * Date: 2021/11/13  20:59
 */
public class LRUCache146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _Value) {
            key = _key;
            value = _Value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
//        使用为头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
//        如果key存在，先通过哈希表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
//            如果key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key,value);
//            添加进哈希表
            cache.put(key,newNode);
//            添加之双向链表头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
//                如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
//                删除哈希表中对应的锁
                cache.remove(tail.key);
                --size;
            }
        } else {
//            如果key'存在，先通过哈希表定位，在修改value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
