package datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by camiloporto on 1/17/18.
 */
public class DoublyLinkedListTest {

    @Test
    public void shouldInsertAtHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assert.assertNull(list.head());

        list.addFirst(1);
        Assert.assertEquals(1,list.head().intValue());
        Assert.assertEquals(1,list.tail().intValue());

        list.addFirst(2);
        Assert.assertEquals(2,list.head().intValue());
        Assert.assertEquals(1,list.tail().intValue());
    }

    @Test
    public void shouldRemoveHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.removeFirst();
        Assert.assertNull(list.head());
        Assert.assertNull(list.tail());

        list.addFirst(1);
        list.addFirst(2);

        Assert.assertEquals(2, list.head().intValue());
        list.removeFirst();
        Assert.assertEquals(1, list.head().intValue());
        list.removeFirst();
        Assert.assertNull(list.head());
    }

    @Test
    public void shouldRemoveTail() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.removeLast();
        Assert.assertNull(list.head());
        Assert.assertNull(list.tail());

        list.addFirst(1);
        list.addFirst(2);

        Assert.assertEquals(2, list.head().intValue());
        list.removeLast();
        Assert.assertEquals(2, list.head().intValue());
        list.removeLast();
        Assert.assertNull(list.head());
        Assert.assertNull(list.tail());
    }

    @Test
    public void shouldFindElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        Assert.assertFalse(list.contains(1));

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(4));

        Assert.assertFalse(list.contains(5));

    }

    @Test
    public void shouldRemoveElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.remove(1); //should do nothing..

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.remove(1);
        Assert.assertFalse(list.contains(1));

        list.remove(2);
        Assert.assertFalse(list.contains(2));

        list.remove(3);
        Assert.assertFalse(list.contains(3));
        list.remove(4);
        Assert.assertFalse(list.contains(4));

        Assert.assertNull(list.head());
    }

    @Test
    public void shouldInsertLast() {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assert.assertNull(list.head());
        Assert.assertNull(list.tail());

        list.addLast(1);
        Assert.assertEquals(1,list.head().intValue());
        Assert.assertEquals(1,list.tail().intValue());

        list.addLast(2);
        Assert.assertEquals(1,list.head().intValue());
        Assert.assertEquals(2,list.tail().intValue());

        list.addLast(3);
        Assert.assertEquals(1,list.head().intValue());
        Assert.assertEquals(3,list.tail().intValue());

        list.addLast(4);
        Assert.assertEquals(1,list.head().intValue());
        Assert.assertEquals(4,list.tail().intValue());


    }

    @Test
    public void shouldFindByIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assert.assertNull(list.get(0));
        Assert.assertNull(list.get(10));

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
    }
    
}
