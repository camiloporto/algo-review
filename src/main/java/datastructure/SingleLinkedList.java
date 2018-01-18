package datastructure;

/**
 * Created by camiloporto on 1/17/18.
 */
public class SingleLinkedList<T> implements MyList<T> {

    private Node<T> head;

    public T head() {
        return (head != null) ? head.key : null;
    }

    @Override
    public void add(T e) {
        addFirst(e);
    }

    public void addFirst(T e) {
        Node<T> n = new Node<>(e);
        n.next = head;
        head = n;
    }

    public void removeFirst() {
        if(head != null) {
            head = head.next;
        }
    }

    public boolean contains(T e) {
        return find(e) != null;
    }

    private Node<T> find(T e) {

        Node<T> n = head;
        while (n != null && !n.key.equals(e)) {
            n = n.next;
        }
        return n;
    }

    public void remove(T e) {
        if(head != null) {
            if(head.key.equals(e)) {
                removeFirst();
            }
            else {
                Node<T> n = head;
                while (n.next != null && !n.next.key.equals(e)) {
                    n = n.next;
                }
                if(n.next != null) {
                    n.next = n.next.next;
                }
            }
        }
    }

    public void addLast(T e) {
        Node<T> n = new Node<>(e);

        if(head == null) {
            head = n;
        }
        else {
            Node<T> r = head;
            while (r.next != null) {
                r = r.next;
            }
            r.next = n;
        }
    }

    public T get(int index) {
        Node<T> n = head;
        int i = 0;
        while (n != null && i < index) {
            n = n.next;
            i++;
        }
        return (n != null) ? n.key : null;
    }

    private static final class Node<T> {
        T key;
        Node<T> next;

        public Node(T key) {
            this.key = key;
        }
    }
}
