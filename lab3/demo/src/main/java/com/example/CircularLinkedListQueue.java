package com.example;

//import java.util.Queue;

public class CircularLinkedListQueue<T> implements Queue<T> {
    private class Node {
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }
    private Node tail;
    private int size;

    public CircularLinkedListQueue() {
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node new_node = new Node(element);
        if(tail == null){
            tail = new_node;
            tail.next = tail;
        } else{
            new_node.next = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
             throw new IllegalStateException("Queue is empty"); 
        }
        Node head = tail.next;
        T element = head.data;
        if(head == tail){
            tail = null;
        }else{
            tail.next = head.next;
        }
        size--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
             throw new IllegalStateException("Queue is empty"); 
        }
        return tail.next.data;
    }

    @Override
    public int size() {
        return size;
    }

}
