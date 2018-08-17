package com.github.kiriloman.data_structures;

import java.util.NoSuchElementException;

//FIFO Queue
public class Queue<T> {
    private final int LIMIT;
    private LinkedList<T> queue;

    public Queue() {
        LIMIT = Integer.MAX_VALUE;
        queue = new LinkedList<>();
    }

    public Queue(Integer limit) {
        if (limit < 0) throw new ArithmeticException();
        LIMIT = limit;
        queue = new LinkedList<>();
    }

    public boolean add(T element) {
        if (queue.length >= LIMIT) throw new IllegalStateException();
        queue.add(element);
        return true;
    }

    public T remove() {
        if (queue.length < 1) throw new NoSuchElementException();
        Node first = queue.getRoot();
        queue.removeFirst();
        return (T) first.getValue();
    }

    public T element() {
        if (queue.length < 1) throw new NoSuchElementException();
        return (T) queue.getRoot().getValue();
    }

    public boolean offer(T element) {
        if (queue.length >= LIMIT) return false;
        queue.add(element);
        return true;
    }

    public T poll() {
        if (queue.length < 1) return null;
        Node first = queue.getRoot();
        queue.removeFirst();
        return (T) first.getValue();
    }

    public T peek() {
        if (queue.length < 1) return null;
        return (T) queue.getRoot().getValue();
    }
}
