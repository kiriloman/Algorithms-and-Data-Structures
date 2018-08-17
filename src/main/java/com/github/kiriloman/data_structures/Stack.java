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
        Node last = stack.getLastNode();
        stack.removeLast();
        return (T) last.getValue();
    }

    public T push(T element) {
        stack.add(element);
        return element;
    }

    public int search(Object o) {
        for (int i = 0; i < stack.length; i++) {
            //if (stack.)
        }
        return 0;
    }
}
