/*
    706. Design HashMap
    (easy)
*/

import java.util.ArrayList;

class MyHashMap {
    private ArrayList<Node>[] buckets;
    private int N;
    private int size;
    private final double threshold = 4.0;

    public MyHashMap() {
        this.N = 16;
        this.size = 0;
        initializeBuckets();
    }
    
    public void put(int key, int value) {
        int hc = hashFunction(key);

        for (Node node:buckets[hc]) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }

        buckets[hc].add(new Node(key,value));
        size++;

        if (lambda() > threshold) {
            rehash();
        }
    }
    
    public int get(int key) {
        int hc = hashFunction(key);

        for (Node node:buckets[hc]) {
            if (node.key == key) {
                return node.val;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int hc = hashFunction(key);

        for (int i = 0;i < buckets[hc].size();i++) {
            if (buckets[hc].get(i).key == key) {
                buckets[hc].remove(i);
                size--;
                return;
            }
        }
    }

    // private Helper Functions and classes
    private class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void initializeBuckets() {
        buckets = new ArrayList[N];

        for (int i = 0;i < N;i++) {
            buckets[i] = new ArrayList<>();
        }
    }
   
    private int hashFunction(int val) {
        int hc = String.valueOf(val).hashCode();
        return Math.abs(hc) % N;
    }

    private double lambda() {
        return size / (double) N;
    }

    private void rehash() {
        ArrayList<Node>[] oldBuckets = buckets;

        this.N = N*2;
        initializeBuckets();

        for (ArrayList<Node> bucket:oldBuckets) {
            for (Node node:bucket) {
                int hc = hashFunction(node.key);
                buckets[hc].add(node);
            }
        }
    }
}

public class _2_MapImplementation {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(3,5);
        map.put(2,7);
        map.put(3,11);

        System.out.println(map.get(3));
    }
}
