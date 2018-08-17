package com.github.kiriloman.data_structures;

public class Node {
    private Object value;
    private Node next;

    //does not accept null as a value
    public Node(Object value) {
        if (value == null) throw new NullPointerException();
        this.value = value;
        this.next = null;
    }

    public void setValue(Object value) {
        if (value == null) throw new NullPointerException();
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
