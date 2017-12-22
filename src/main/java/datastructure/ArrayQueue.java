package datastructure;

import java.lang.reflect.Array;

/**
 * Created by camiloporto on 12/21/17.
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(Class<T> elementType, int maxSize) {
        this.queue = (T[]) Array.newInstance(elementType, maxSize);
        head = -1;
        tail = -1;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T e) {
        if(isFull()) {
            throw new IllegalStateException("queue full");
        }
        if(head == -1) {
            head = 0;
        }
        tail++;
        if(tail == queue.length) {
            tail = 0;
        }
        queue[tail] = e;
        size++;
    }

    private boolean isFull() {
        return size == queue.length;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new IllegalStateException("queue empty");
        }
        return queue[head];
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("queue empty");
        }
        T e = queue[head];
        head++;
        if(head == queue.length) {
            head = 0;
        }
        size--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
