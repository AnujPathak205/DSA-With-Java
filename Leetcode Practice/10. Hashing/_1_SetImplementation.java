/*
    705. Design HashSet
    (easy)

    Design a HashSet without using any built-in hash table libraries.

    Implement MyHashSet class:

        void add(key) Inserts the value key into the HashSet.
        bool contains(key) Returns whether the value key exists in the HashSet or not.
        void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*/

import java.util.ArrayList;

class MyHashSet {
    private ArrayList<Integer>[] buckets;
    private int N;
    private int size;
    private final double threshold = 4.0;

    public MyHashSet() {
        this.N = 16;
        this.buckets = new ArrayList[N];

        for (int i = 0;i < N;i++) {
            buckets[i] = new ArrayList<>();
        }

        this.size = 0;
    }
    
    public void add(int key) {
        int hc = hashFunction(key);

        for (int val:buckets[hc]) {
            if (val == key) return;
        }

        this.size++;
        buckets[hc].add(key);

        if (lambda() > threshold) {
            rehash();
        }
    }
    
    public void remove(int key) {
        int hc = hashFunction(key);

        for (int i = 0;i < buckets[hc].size();i++) {
            if (buckets[hc].get(i) == key) {
                buckets[hc].remove(i);
                this.size--;
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        int hc = hashFunction(key);

        for (int val:buckets[hc]) {
            if (val == key) return true;
        }

        return false;
    }

    @Override 
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ArrayList bucket:buckets) {
            for (Object val:bucket) {
                result.append(val).append(" ");
            }
        }
        return result.toString();
    }

    // Helper private functions
    private int hashFunction(int key){
        int hc = String.valueOf(key).hashCode();
        return Math.abs(hc)%N;
    }

    private double lambda() {
        return size/(double) N;
    }

    private void rehash() {
        ArrayList<Integer>[] oldBuckets = new ArrayList[N];

        for (int i = 0;i < buckets.length;i++) {
            oldBuckets[i] = buckets[i];
        }

        this.N = N*2;
        this.size = 0;
        buckets = new ArrayList[N];

        for (int i = 0;i < N;i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0;i < oldBuckets.length;i++) {
            for (int j = 0;j < oldBuckets[i].size();j++) {
                this.add(oldBuckets[i].get(j));
            }
        }
    }
}

public class _1_SetImplementation {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(4);
        set.add(3);
        set.add(2);

        System.out.println(set.contains(2));
        System.out.println(set.contains(5));

        System.out.println(set);

        set.remove(2);

        System.out.println(set);
    }
}
