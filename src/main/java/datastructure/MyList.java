package datastructure;

/**
 * Created by camiloporto on 1/17/18.
 */
public interface MyList<T> {

    T head();

    void add(T e);

    void remove(T e);

    boolean contains(T e);

    T get(int i);
}
