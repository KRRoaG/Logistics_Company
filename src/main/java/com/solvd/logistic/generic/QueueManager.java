package com.solvd.logistic.generic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueManager<T>{
    private final Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.remove();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
