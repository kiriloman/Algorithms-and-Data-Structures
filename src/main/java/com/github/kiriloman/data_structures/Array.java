package com.github.kiriloman.data_structures;

public class Array<V> {
    private Node root;
    private Node last;
    public int length;

    public Array() {
        this.root = null;
        this.last = null;
        this.length = 0;
    }

    public void add(V value) {
        if (value == null) throw new NullPointerException();
        if (root == null) {
            root = new Node(value);
            last = root;
        }
        else {
            Node newNode = new Node(value);
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    public void remove(Integer index) {
        if (index == null) throw new NullPointerException();
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();
        if (index == 0) {
            root = root.getNext();
            length--;
            return;
        }
        int counter = 0;
        Node current = root;
        while (counter < index - 1 && current != null) {
            counter++;
            current = current.getNext();
        }
        if (current.getNext() != null) {
            Node aux = current.getNext();
            current.setNext(aux.getNext());
        }
        length--;
    }

    public void removeFirst() {
        if (length == 0) throw new NullPointerException();
        this.remove(0);
    }

    public void removeLast() {
        if (length == 0) throw new NullPointerException();
        this.remove(length - 1);
    }

    public V get(Integer index) {
        if (index == null) throw new NullPointerException();
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();
        int counter = 0;
        Node current = root;
        while (counter != index && current != null) {
            counter++;
            current = current.getNext();
        }
        return (V) current.getValue();
    }

    public void destroy() {
        root = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        String str = "{";
        Node aux = root;
        if (aux == null) return str.concat("}");
        while (aux.getNext() != null) {
            str = str.concat(aux.getValue().toString() + ", ");
            aux = aux.getNext();
        }
        str = str.concat(aux.getValue().toString());
        str = str.concat("}");
        return str;
    }
}
