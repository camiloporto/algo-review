package datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by camiloporto on 12/19/17.
 */
public class StackTest {

    @Test
    public void shouldPushAndPop() {

        Stack<Integer> stack = new ArrayStack<Integer>(Integer.class, 10);

        Assert.assertEquals(0, stack.size());

        stack.push(5);
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(Integer.valueOf(5), stack.top());

        stack.push(6);
        stack.push(3);
        stack.push(2);
        stack.push(8);

        Assert.assertEquals(5, stack.size());
        Assert.assertEquals(Integer.valueOf(8), stack.top());

        Assert.assertEquals(Integer.valueOf(8), stack.pop());
        Assert.assertEquals(4, stack.size());

        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(3, stack.size());

        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(2, stack.size());

        Assert.assertEquals(Integer.valueOf(6), stack.pop());
        Assert.assertEquals(1, stack.size());

        Assert.assertEquals(Integer.valueOf(5), stack.pop());
        Assert.assertEquals(0, stack.size());

        try {
            stack.pop();
            Assert.fail("stack empty. should throws exception");
        }
        catch (IllegalStateException e) {}

        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);

        try {
            stack.push(1);
            Assert.fail("stack full. should throws exception");
        }
        catch (IllegalStateException e) {}

    }

    @Test
    public void shouldScale() {
        int stackSize = 10000000;
        Stack<Integer> stack = new ArrayStack<>(Integer.class, stackSize);
        for(int i = 0; i < stackSize; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

}
