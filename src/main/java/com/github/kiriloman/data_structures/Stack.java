package com.github.kiriloman.data_structures;

import java.util.EmptyStackException;

//LIFO data structure
public class Stack<T> {

    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public T peek() {
        if (empty()) throw new EmptyStackException();
        return (T) stack.getLastNode().getValue();
    }

    public T pop() {
        if (empty()) throw new EmptyStackException();
        Node last = stack.getLastNode();
        stack.removeLast();
        return (T) last.getValue();
    }

    public T push(T element) {
        stack.add(element);
        return element;
    }

    public int search(Object o) {
        if (stack.isEmpty()) return -1;

        int position = -1;
        int counter = 0;
        Node curr = stack.getRoot();

        while (curr != null) {
            if (curr.getValue().equals(o))
                position = counter;
            curr = curr.getNext();
            counter++;
        }

        if (position != -1) return stack.length - position;
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
