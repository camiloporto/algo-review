package datastructure;

import java.lang.reflect.Array;

/**
 * Created by camiloporto on 12/21/17.
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int head;
    private int tail;

    public ArrayQueue(Class<T> elementType, int maxSize) {
        this.queue = (T[]) Array.newInstance(elementType, maxSize+1);
        head = 0;
        tail = 0;
    }

    @Override
    public int size() {

        if(tail >= head) {
            return (tail - head);
        }
        else {
            return (tail) + (queue.length - head);
        }
    }

    @Override
    public void enqueue(T e) {
        if(isFull()) {
            throw new IllegalStateException("queue full");
        }
        if(tail == queue.length) {
            tail = 0;
        }
        queue[tail] = e;
        tail++;
    }

    private boolean isFull() {
        return head == (tail + 1);
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
        return e;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
