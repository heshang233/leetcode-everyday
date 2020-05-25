package cn.huangsy;

import java.util.HashMap;

/**
 * @author huangsy
 * @date 2020/5/25 8:37
 */
public class LRUCache {

    private HashMap<Integer, LinkNode> map = new HashMap<>();

    private int capacity;
    private LinkNode head;
    private LinkNode tail;

    class LinkNode {
        private int key;
        private int value;
        private LinkNode preNode;
        private LinkNode postNode;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkNode();
        tail = new LinkNode();
        head.postNode = tail;
        tail.preNode = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode linkNode = map.get(key);
            linkNode.preNode.postNode = linkNode.postNode;
            linkNode.postNode.preNode = linkNode.preNode;
            linkNode.preNode = head;
            linkNode.postNode = head.postNode;
            linkNode.preNode.postNode = linkNode;
            linkNode.postNode.preNode = linkNode;
            head.postNode = linkNode;
            return linkNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkNode linkNode;
        if (map.containsKey(key)) {
            linkNode = map.get(key);
            linkNode.value = value;
            linkNode.preNode.postNode = linkNode.postNode;
            linkNode.postNode.preNode = linkNode.preNode;
            linkNode.preNode = head;
            linkNode.postNode = head.postNode;
            head.postNode = linkNode;
        } else {

            linkNode = new LinkNode();
            linkNode.key = key;
            linkNode.value = value;
            linkNode.preNode = head;
            linkNode.postNode = head.postNode;
            linkNode.preNode.postNode = linkNode;
            linkNode.postNode.preNode = linkNode;
            if (map.size()>=capacity) {
                LinkNode preNode = tail.preNode;
                tail.preNode = preNode.preNode;
                preNode.preNode.postNode = tail;
                preNode.preNode = null;
                preNode.postNode = null;
                map.remove(preNode.key);
            }
        }
        linkNode.preNode.postNode = linkNode;
        linkNode.postNode.preNode = linkNode;
        map.put(key, linkNode);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 3 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */