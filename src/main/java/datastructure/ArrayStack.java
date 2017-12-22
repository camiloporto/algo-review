package datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by camiloporto on 12/21/17.
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int size = 0;

    public ArrayStack(Class<T> elementType, int maxSize) {
        super();
        this.stack = (T[]) Array.newInstance(elementType, maxSize);
    }

    private int topIndex() {
        return size-1;
    }

    @Override
    public void push(T e) {
        if(isFull()) {
            throw new IllegalStateException("stack full");
        }
        size++;
        stack[topIndex()] = e;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        T top = stack[topIndex()];
        size--;
        return top;
    }

    @Override
    public T top() {
        if(isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return stack[topIndex()];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == stack.length;
    }
}
