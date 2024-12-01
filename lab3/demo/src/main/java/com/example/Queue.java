package com.example;


public interface Queue<T> {
    // Retrieve the front element of the queue without removing it
    T peek();
 
    // Return the number of elements in the queue
    int size();

    void enqueue(T element);

    T dequeue();
    
 }
 
