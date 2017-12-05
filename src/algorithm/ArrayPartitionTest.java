package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by camiloporto on 2/6/17.
 */
public class ArrayPartitionTest {

    @Test
    public void testPartitionOverInterval() {

        ArrayPartition partition = new ArrayPartition();

        int[] input = new int[] {1, 7, 3, 5, 4, 9, 6};
        int absolutePivotIndex = partition.partition(input, 2, 5, 1);
        Assert.assertEquals(4, absolutePivotIndex);

        input = new int[] {1, 7, 3, 5, 4, 9, 6};
        absolutePivotIndex = partition.partition(input, 0, input.length-1, 3);
        Assert.assertEquals(3, absolutePivotIndex);
    }

    @Test
    public void testPartition() {
        ArrayPartition partition = new ArrayPartition();

        int[] input = new int[] {1, 7, 3, 5, 4, 9, 6};
        int pivotIndex = partition.partition(input, 3);
        Assert.assertEquals(3, pivotIndex);

        input = new int[] {1, 2, 3, 4, 5};
        pivotIndex = partition.partition(input, 0);
        Assert.assertEquals(0, pivotIndex);

        input = new int[] {1, 2, 3, 4, 5};
        pivotIndex = partition.partition(input, 4);
        Assert.assertEquals(4, pivotIndex);

        input = new int[] {5, 4, 3, 2, 1};
        pivotIndex = partition.partition(input, 0);
        Assert.assertEquals(4, pivotIndex);

        input = new int[] {5, 4, 3, 2, 1};
        pivotIndex = partition.partition(input, 4);
        Assert.assertEquals(0, pivotIndex);

        input = new int[] {5};
        pivotIndex = partition.partition(input, 0);
        Assert.assertEquals(0, pivotIndex);
    }

    @Test
    public void testOverLargeInput() {
        int[] input = new int[100000000];
        Random random = new Random();
        for(int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(Integer.MAX_VALUE);
        }

        ArrayPartition partition = new ArrayPartition();
        int pivotIndex = partition.partition(input, input.length / 2);

        int pivot = input[pivotIndex];
        for(int i = 0; i < pivotIndex; i++) {
            Assert.assertTrue("pivot: " + pivot + " less than " + input[i], pivot >= input[i]);
        }

        for(int i = pivotIndex+1; i < input.length; i++) {
            Assert.assertTrue(pivot <= input[i]);
        }
    }
}
