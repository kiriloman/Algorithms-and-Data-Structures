package com.github.kiriloman.data_structures;

public class LinkedList<T> {
    public int length;
    private Node root;
    private Node last;

    public LinkedList() {
        this.root = null;
        this.last = null;
        this.length = 0;
    }

    public Node getLastNode() {
        Node aux = root;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        return aux;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
       this.root = root;
    }

    public void add(T value) {
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

    public void add(LinkedList other) {
        if (other == null) throw new NullPointerException();
        int otherLength = other.length;
        if (otherLength == 0) return;
        Node thisNode, otherNode = other.getRoot();
        if (length == 0) {
            root = otherNode;
            thisNode = root;
            otherNode = otherNode.getNext();
        }
        else {
            thisNode = this.getLastNode();
        }
        while (otherNode.getNext() != null) {
            thisNode.setNext(otherNode);
            thisNode = otherNode;
            otherNode = otherNode.getNext();
        }
        length += otherLength;
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

    public T get(Integer index) {
        if (index == null) throw new NullPointerException();
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();
        int counter = 0;
        Node current = root;
        while (counter != index && current != null) {
            counter++;
            current = current.getNext();
        }
        return (T) current.getValue();
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
