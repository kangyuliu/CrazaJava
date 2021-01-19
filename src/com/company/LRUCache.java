package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//HashMap +双向链表
public class LRUCache {

    HashMap<String, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity){
        count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.before = null;
        tail = new DLinkedNode();
        tail.after = null;
        head.after = tail;
        tail.before = head;
    }

    public int get(String key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        removeToHead(node);
        return node.val;
    }

    public void add(String key, int val){
        DLinkedNode node = cache.get(key);
        if(node == node){
            node = new DLinkedNode(key,val);
            addNode(node);
            cache.put(key, node);
            count++;
            if(count > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        }else {
            node.val = val;
            removeToHead(node);
        }
    }

    //双向链表节点
    static class DLinkedNode{
        String key;
        int val;
        DLinkedNode before;
        DLinkedNode after;
        public DLinkedNode(){}
        public DLinkedNode(String key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private void addNode(DLinkedNode node){
        node.after = head.after;
        head.after.before = node;
        head.after = node;
        node.before = head;
    }
    private void removeNode(DLinkedNode node){
        DLinkedNode before = node.before;
        DLinkedNode after = node.after;
        before.after = after;
        after.before = before;
    }

    //将一个移动到列表头
    private void removeToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.before;
        removeNode(res);
        return res;
    }

    /**
     * 基于LinkedHashMap的 LRU Cache 实现
     */
    class MyLRUCache<K,V> extends LinkedHashMap<K,V> {
        private int cacheSize;  // 缓存容量

        public MyLRUCache(int cacheSize) {
            super(16,0.75f, true);
            this.cacheSize = cacheSize;
        }

        /**
         * 超过Cache容量即会移除最近最少被使用的元素
         * @param eldest
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() > cacheSize;
        }
    }
}
