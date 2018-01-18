package datastructure;

/**
 * Created by camiloporto on 1/17/18.
 */
public class DoublyLinkedList<T> implements MyList<T> {

    private Node<T> sentinel;

    public DoublyLinkedList() {
        this.sentinel = new Node<>(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    public T head() {
        return headNode().key;
    }

    @Override
    public void add(T e) {
        addFirst(e);
    }

    public T tail() {
        return tailNode().key;
    }

    private Node<T> headNode() {
        return sentinel.next;
    }

    private Node<T> tailNode() {
        return sentinel.prev;
    }

    public void addFirst(T e) {
        Node<T> n = new Node<>(e);
        n.next = headNode();
        n.prev = sentinel;
        headNode().prev = n;
        sentinel.next = n;
    }

    public void addLast(T e) {
        Node<T> n = new Node<>(e);
        n.next = sentinel;
        n.prev = tailNode();
        tailNode().next = n;
        sentinel.prev = n;
    }

    public void removeFirst() {
        if(headNode() != sentinel) {
            Node<T> n = headNode();
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
        }
    }

    public void removeLast() {
        if(tailNode() != sentinel) {
            Node<T> n = tailNode();
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
        }
    }

    public boolean contains(T e) {
        Node<T> n = headNode();
        while (n != sentinel && !n.key.equals(e)) {
            n = n.next;
        }

        return n !=  sentinel;
    }

    public void remove(T e) {
        Node<T> n = headNode();
        while (n != sentinel && !n.key.equals(e)) {
            n = n.next;
        }

        if(n != sentinel) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
        }
    }

    public T get(int index) {
        Node<T> n = headNode();
        int i = 0;
        while (n != sentinel && i < index) {
            n = n.next;
            i++;
        }

        return n.key;
    }


    private static final class Node<T> {
        T key;
        Node<T> next;
        Node<T> prev;

        public Node(T key) {
            this.key = key;
        }
    }
}