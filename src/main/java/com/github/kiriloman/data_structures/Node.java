package com.github.kiriloman.data_structures;

public class Node {
    private Object value;
    private Node next;

    public Node() {
        this.value = null;
        this.next = null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
