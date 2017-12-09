package algorithm.sort;

import algorithm.sort.HeapSort;
import org.junit.Assert;
import org.junit.Test;
import algorithm.ArrayTestHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by camiloporto on 12/7/17.
 */
public class HeapSortTest {

    private ArrayTestHelper arrayTestHelper;
    private HeapSort heapSort;

    public HeapSortTest() {
        this.arrayTestHelper = new ArrayTestHelper();
        heapSort = new HeapSort();
    }

    @Test
    public void shouldSort() {
        int[] input = new int[] {4, 7, 6, 1, 9, 10, 3};
        int[] expectedOutput = new int[] {1, 3, 4, 6, 7, 9, 10};

        heapSort.sort(input);

        Assert.assertArrayEquals(expectedOutput, input);

        Random random = new Random();
        input = arrayTestHelper.randomArray(10, random);
        checkSort(input);

        input = arrayTestHelper.randomArray(1, random);
        checkSort(input);

        input = arrayTestHelper.randomArray(2, random);
        checkSort(input);

        input = arrayTestHelper.randomArray(11, random);
        checkSort(input);

        input = arrayTestHelper.randomArray(10000000, random);
        checkSort(input);

        input = arrayTestHelper.randomArray(11, random);
        Arrays.sort(input);
        checkSort(input);

        input = new int[] {7, 6, 5, 4, 3, 2, 1};
        checkSort(input);
    }

    private void checkSort(int[] input) {

        int[] expectedOutput = Arrays.copyOf(input, input.length);
        Arrays.sort(expectedOutput);

        heapSort.sort(input);

        Assert.assertArrayEquals(expectedOutput, input);
    }
}
