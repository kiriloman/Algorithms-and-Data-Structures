package com.github.kiriloman.data_structures;

public class HashMap<K, V> {

    private final int SIZE;
    private LinkedList[] buckets;

    HashMap() {
        SIZE = 32;
        buckets = new LinkedList[SIZE];
        initializeBuckets(buckets);
    }

    HashMap(int size) {
        SIZE = size;
        buckets = new LinkedList[SIZE];
        initializeBuckets(buckets);
    }

    private void initializeBuckets(LinkedList[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Pair<K, V>>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        Pair<K, V> pair = new Pair<>(key, value);
        for (int i = 0; i < buckets[hash].length; i++) {
            if (((Pair) buckets[hash].get(i)).getFirst().equals(key)) {
                ((Pair) buckets[hash].get(i)).setSecond(value);
                return;
            }
        }
        buckets[hash].add(pair);
    }

    public V get(K key) {
        int hash = hash(key);
        for (int i = 0; i < buckets[hash].length; i++) {
            if (((Pair) buckets[hash].get(i)).getFirst().equals(key)) {
                return (V) ((Pair) buckets[hash].get(i)).getSecond();
            }
        }
        return null;
    }
}
