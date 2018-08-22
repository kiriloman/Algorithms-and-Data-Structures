package com.github.kiriloman.data_structures;

public class HashMap<K, V> {

    private final int NUM_OF_BUCKETS;
    private LinkedList[] buckets;
    private int size;

    HashMap() {
        NUM_OF_BUCKETS = 32;
        size = 0;
        buckets = new LinkedList[NUM_OF_BUCKETS];
        initializeBuckets(buckets);
    }

    HashMap(int numberOfBuckets) {
        NUM_OF_BUCKETS = numberOfBuckets;
        size = 0;
        buckets = new LinkedList[NUM_OF_BUCKETS];
        initializeBuckets(buckets);
    }

    private void initializeBuckets(LinkedList[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Pair<K, V>>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % NUM_OF_BUCKETS;
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
        size++;
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

    public int size() {
        return size;
    }
}
