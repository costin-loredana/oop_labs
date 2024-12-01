package com.example;

public class ArrayQueue<T> implements Queue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        queue = new Object[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    public ArrayQueue(Queue<T> otherQueue) {
        this();
        Queue<T> tempQueue = new ArrayQueue<>();
        while (otherQueue.size() > 0) {
            T element = otherQueue.dequeue();
            tempQueue.enqueue(element);
        }
        while (tempQueue.size() > 0) {
            enqueue(tempQueue.dequeue());
        }
    }

    @Override
    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot enqueue null element");
        }
        if (size == queue.length) {
            resize();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        @SuppressWarnings("unchecked")
        T element = (T) queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = queue.length * 2;
        Object[] newQueue = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}
