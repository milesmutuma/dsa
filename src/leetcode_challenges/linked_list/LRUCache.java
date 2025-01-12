package leetcode_challenges.linked_list;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final DoublyLinkedList list = new DoublyLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Move the accessed node to the front
        Node node = cache.get(key);
        list.moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value and move to the front
            Node node = cache.get(key);
            node.value = value;
            list.moveToFront(node);
        } else {
            // Add a new node
            if (cache.size() == capacity) {
                // Evict the least recently used item
                Node lru = list.removeFromBack();
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            list.addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoublyLinkedList {
        private final Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFront(Node node) {
            remove(node);
            addToFront(node);
        }

        public Node removeFromBack() {
            if (tail.prev == head) {
                return null; // List is empty
            }
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 4);
        cache.put(3, 7);
        cache.put(1, 1);
        cache.put(4, 2);
    }
}