package com.github.kiriloman.data_structures;

public class HashMap<K, V> {

    private final int NUM_OF_BUCKETS;
    private LinkedList[] buckets;
    private int size;

    HashMap() {
        NUM_OF_BUCKETS = 32;
        size = 0;
        buckets = new LinkedList[NUM_OF_BUCKETS];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Pair<K, V>>();
        }
    }

    HashMap(int numberOfBuckets) {
        NUM_OF_BUCKETS = numberOfBuckets;
        size = 0;
        buckets = new LinkedList[NUM_OF_BUCKETS];
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

    public boolean containsKey(K key) {
        int hash = hash(key);
        for (int i = 0; i < buckets[hash].length; i++) {
            if (((Pair) buckets[hash].get(i)).getFirst().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < NUM_OF_BUCKETS; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                if (((Pair) buckets[i].get(j)).getSecond().equals(value))
                    return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        int hash = hash(key);
        for (int i = 0; i < buckets[hash].length; i++) {
            if (((Pair) buckets[hash].get(i)).getFirst().equals(key)) {
                buckets[hash].remove(i);
                size--;
                return;
            }
        }
    }

    public void remove(K key, V value) {
        int hash = hash(key);
        for (int i = 0; i < buckets[hash].length; i++) {
            if (((Pair) buckets[hash].get(i)).getFirst().equals(key) && ((Pair) buckets[hash].get(i)).getSecond().equals(value)) {
                buckets[hash].remove(i);
                size--;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
