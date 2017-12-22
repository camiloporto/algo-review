package datastructure;

import org.junit.Assert;
import org.junit.Test;



/**
 * Created by camiloporto on 12/21/17.
 */
public class ArrayQueueTest {

    @Test
    public void shouldEnqueueAndDequeue() {

        Queue<Integer> queue = new ArrayQueue<Integer>(Integer.class, 10);

        Assert.assertEquals(0, queue.size());

        queue.enqueue(5);
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(Integer.valueOf(5), queue.peek());

        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(8);

        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(Integer.valueOf(5), queue.peek());

        Assert.assertEquals(Integer.valueOf(5), queue.dequeue());
        Assert.assertEquals(4, queue.size());

        Assert.assertEquals(Integer.valueOf(6), queue.dequeue());
        Assert.assertEquals(3, queue.size());

        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
        Assert.assertEquals(2, queue.size());

        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(1, queue.size());

        Assert.assertEquals(Integer.valueOf(8), queue.dequeue());
        Assert.assertEquals(0, queue.size());

        try {
            queue.dequeue();
            Assert.fail("queue empty. should throws exception");
        }
        catch (IllegalStateException e) {}

        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);

        try {
            queue.enqueue(1);
            Assert.fail("queue full. should throws exception");
        }
        catch (IllegalStateException e) {}

    }

    @Test
    public void shouldGoFullAndEmpty() {
        int maxSize = 10;
        Queue<Integer> queue = new ArrayQueue<Integer>(Integer.class, maxSize);
        for(int i = 1; i <= maxSize; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(Integer.valueOf(1), queue.peek());

        for(int i = 1; i <= maxSize; i++) {
            queue.dequeue();
        }
        Assert.assertTrue(queue.isEmpty());

        for(int i = 1; i <= maxSize; i++) {
            queue.enqueue(i*2);
        }
        Assert.assertEquals(Integer.valueOf(2), queue.peek());

        for(int i = 1; i <= maxSize; i++) {
            queue.dequeue();
        }
        Assert.assertTrue(queue.isEmpty());

        for(int i = 1; i <= maxSize; i++) {
            queue.enqueue(i*4);
        }
        Assert.assertEquals(Integer.valueOf(4), queue.peek());

    }
}
