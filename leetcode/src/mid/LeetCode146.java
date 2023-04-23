package mid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/4/23 22:14
 * @Description:
 */
public class LeetCode146 {

    static class LRUCache {

        class Node{
            public int key;
            public int val;
            public Node pre;
            public Node next;
        }

        private Node head;
        private Node tail;
        private Map<Integer,Node> nodeMap;
        private int capacity;
        private int size = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            nodeMap = new HashMap<>();
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if(node == null){
                return -1;
            }
            removeNode(node);
            addToHead(node);
            return node.val;
        }

        private void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(Node node){
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if(node != null){
                node.val = value;
                removeNode(node);
                addToHead(node);
                return;
            }
            node = new Node();
            node.key = key;
            node.val = value;
            if(size == capacity){
                nodeMap.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                size--;
            }
            addToHead(node);
            nodeMap.put(node.key,node);
            size++;
        }
    }

    public static void main(String[] args) {
        LRUCache cache =  new LRUCache(2);
        cache.put(1,0);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
