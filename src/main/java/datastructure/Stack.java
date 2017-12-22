package datastructure;

/**
 * Created by camiloporto on 12/19/17.
 */
public interface Stack<T> {

    void push(T e);

    T pop();

    T top();

    int size();

    boolean isEmpty();

}
