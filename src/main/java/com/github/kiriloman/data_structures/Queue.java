package com.github.kiriloman.data_structures;

//FIFO Queue
public class Queue<T> {
    private final int LIMIT;
    private int length;

    public Queue() {
        LIMIT = Integer.MAX_VALUE;
        length = 0;
    }

    public Queue(Integer limit) {
        if (limit < 0) throw new ArithmeticException();
        LIMIT = limit;
        length = 0;
    }

    public void add(T element) {
        
    }

    public void remove() {

    }

    public T element() {

        return null;
    }

    public void offer(T element) {

    }

    public void poll() {

    }

    public void peek() {

    }
}
