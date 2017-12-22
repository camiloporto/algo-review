package datastructure;

/**
 * Created by camiloporto on 12/21/17.
 */
public interface Queue<T> {
    int size();

    void enqueue(T e);

    T peek();

    T dequeue();

    boolean isEmpty();
}
