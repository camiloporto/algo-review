package datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by camiloporto on 12/7/17.
 */
public class HeapTest {

    @Test
    public void shouldInsertNewElement() {
        Heap heap = new Heap(10);

        heap.insert(9);
        Assert.assertEquals(9, heap.peek());

        heap.insert(8);
        Assert.assertEquals(8, heap.peek());

        heap.insert(10);
        Assert.assertEquals(8, heap.peek());

        heap.insert(7);
        Assert.assertEquals(7, heap.peek());

        heap.insert(15);
        Assert.assertEquals(7, heap.peek());

        heap.insert(5);
        Assert.assertEquals(5, heap.peek());

        heap.insert(12);
        Assert.assertEquals(5, heap.peek());

        heap.insert(71);
        Assert.assertEquals(5, heap.peek());

        heap.insert(3);
        Assert.assertEquals(3, heap.peek());
    }

    @Test
    public void shouldExtractMin() {
        Heap heap = new Heap(5);

        heap.insert(9);
        heap.insert(5);
        heap.insert(8);
        heap.insert(6);
        heap.insert(7);
        Assert.assertEquals(5, heap.extractRoot());
        Assert.assertEquals(6, heap.extractRoot());
        Assert.assertEquals(7, heap.extractRoot());
        Assert.assertEquals(8, heap.extractRoot());
        Assert.assertEquals(9, heap.extractRoot());

    }

    @Test
    public void shouldHeapify() {
        final boolean MIN_HEAP = true;
        final boolean MAX_HEAP = false;

        int[] input = new int[]{9, 5, 8, 6, 7, 12};
        Heap heap = new Heap(input, MIN_HEAP);

        Assert.assertEquals(5, heap.extractRoot());
        Assert.assertEquals(6, heap.extractRoot());
        Assert.assertEquals(7, heap.extractRoot());
        Assert.assertEquals(8, heap.extractRoot());
        Assert.assertEquals(9, heap.extractRoot());

        input = new int[] {4, 7, 6, 1, 9, 10, 3};
        heap = new Heap(input, MIN_HEAP);
        Assert.assertEquals(1, heap.extractRoot());
        Assert.assertEquals(3, heap.extractRoot());
        Assert.assertEquals(4, heap.extractRoot());
        Assert.assertEquals(6, heap.extractRoot());
        Assert.assertEquals(7, heap.extractRoot());
        Assert.assertEquals(9, heap.extractRoot());
        Assert.assertEquals(10, heap.extractRoot());

        input = new int[] {4, 7, 6, 1, 9, 10, 3};
        heap = new Heap(input, MAX_HEAP);

        Assert.assertEquals(10, heap.extractRoot());
        Assert.assertEquals(9, heap.extractRoot());
        Assert.assertEquals(7, heap.extractRoot());
        Assert.assertEquals(6, heap.extractRoot());
        Assert.assertEquals(4, heap.extractRoot());
        Assert.assertEquals(3, heap.extractRoot());
        Assert.assertEquals(1, heap.extractRoot());

    }

}
