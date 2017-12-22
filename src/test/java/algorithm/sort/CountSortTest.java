package algorithm.sort;

import algorithm.ArrayTestHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by camiloporto on 12/8/17.
 */
public class CountSortTest {

    private ArrayTestHelper arrayTestHelper;
    private CountSort countSort;

    public CountSortTest() {
        this.arrayTestHelper = new ArrayTestHelper();
        countSort = new CountSort();
    }

    @Test
    public void shouldSort() {
        int[] input = new int[] {4, 7, 6, 1, 9, 10, 3};
        int[] expectedOutput = new int[] {1, 3, 4, 6, 7, 9, 10};

        countSort.sort(input, 10);

        Assert.assertArrayEquals(expectedOutput, input);

        Random random = new Random();
        input = arrayTestHelper.randomArrayWithMaxValue(10, random, 100);
        checkSort(input, 100);

        input = arrayTestHelper.randomArrayWithMaxValue(1, random, 100);
        checkSort(input, 100);

        input = arrayTestHelper.randomArrayWithMaxValue(2, random, 100);
        checkSort(input, 100);

        input = arrayTestHelper.randomArrayWithMaxValue(11, random, 100);
        checkSort(input, 100);

        input = arrayTestHelper.randomArrayWithMaxValue(10000000, random, 1000);
        checkSort(input, 1000);

        input = arrayTestHelper.randomArrayWithMaxValue(11, random, 1000);
        Arrays.sort(input);
        checkSort(input, 1000);

        input = new int[] {7, 6, 5, 4, 3, 2, 1};
        checkSort(input, 7);

    }

    private void checkSort(int[] input, int maxValue) {

        int[] expectedOutput = Arrays.copyOf(input, input.length);
        Arrays.sort(expectedOutput);

        countSort.sort(input, maxValue);

        Assert.assertArrayEquals(expectedOutput, input);
    }

}
