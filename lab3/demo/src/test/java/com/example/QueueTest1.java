package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Queue; 
import com.example.ArrayQueue; 
import com.example.LinkedListQueue; 
import com.example.CircularLinkedListQueue;

public class QueueTest1 {
    @Test
    public void testIntegerQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        assertEquals(1, queue.size());
        assertEquals(Integer.valueOf(10), queue.peek());

        queue.enqueue(20);
        assertEquals(2, queue.size());
        assertEquals(Integer.valueOf(10), queue.peek());
    }

    @Test
    public void testStringQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Electric");
        assertEquals(1, queue.size());
        assertEquals("Electric", queue.peek());

        queue.enqueue("Gas");
        assertEquals(2, queue.size());
        assertEquals("Electric", queue.peek());

        String dequeued = queue.dequeue();
        assertEquals("Electric", dequeued);
        assertEquals(1, queue.size());
        assertEquals("Gas", queue.peek());
    }

    @Test public void testIntegerQueueLinkedList() { 
        Queue<Integer> queue = new LinkedListQueue<>(); 
        queue.enqueue(10); assertEquals(1, queue.size()); 
        assertEquals(Integer.valueOf(10), queue.peek()); 
        queue.enqueue(20); assertEquals(2, queue.size()); 
        assertEquals(Integer.valueOf(10), queue.peek()); 
        Integer dequeued = queue.dequeue(); 
        assertEquals(Integer.valueOf(10), dequeued); 
        assertEquals(1, queue.size()); 
        assertEquals(Integer.valueOf(20), queue.peek());
    }

    @Test public void testStringQueueLinkedList() { 
        Queue<String> queue = new LinkedListQueue<>(); 
        queue.enqueue("Electric"); 
        assertEquals(1, queue.size()); 
        assertEquals("Electric", queue.peek()); 
        queue.enqueue("Gas"); 
        assertEquals(2, queue.size()); 
        assertEquals("Electric", queue.peek()); 
        String dequeued = queue.dequeue(); 
        assertEquals("Electric", dequeued); 
        assertEquals(1, queue.size()); 
        assertEquals("Gas", queue.peek()); }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        assertEquals(Integer.valueOf(10), queue.peek());
    }

    @Test public void testIntegerQueueCircularLinkedList() { 
        Queue<Integer> queue = new CircularLinkedListQueue<>(); 
        queue.enqueue(10); assertEquals(1, queue.size()); 
        assertEquals(Integer.valueOf(10), queue.peek()); 
        queue.enqueue(20); 
        assertEquals(2, queue.size()); 
        assertEquals(Integer.valueOf(10), queue.peek()); 
        Integer dequeued = queue.dequeue(); 
        assertEquals(Integer.valueOf(10), dequeued); 
        assertEquals(1, queue.size()); 
        assertEquals(Integer.valueOf(20), queue.peek()); 
    } 
    
    @Test public void testStringQueueCircularLinkedList() { 
        Queue<String> queue = new CircularLinkedListQueue<>(); 
        queue.enqueue("Electric"); 
        assertEquals(1, queue.size()); 
        assertEquals("Electric", queue.peek()); 
        queue.enqueue("Gas"); 
        assertEquals(2, queue.size()); 
        assertEquals("Electric", queue.peek()); 
        String dequeued = queue.dequeue(); 
        assertEquals("Electric", dequeued); 
        assertEquals(1, queue.size()); 
        assertEquals("Gas", queue.peek()); }
}
