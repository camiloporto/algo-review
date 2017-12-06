package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by camiloporto on 12/5/17.
 */
public class RandomSelectionTest {

    private ArrayTestHelper arrayTestHelper;
    private Selection selection;

    public RandomSelectionTest() {
        arrayTestHelper = new ArrayTestHelper();
        selection = new Selection();
    }

    @Test
    public void shouldReturnSelectionOrder() {
        int[] input = new int[]{3, 6, 2, 7, 5};
        int order = selection.select(input, 5);
        Assert.assertEquals(3, order);

        input = new int[]{3};
        order = selection.select(input, 3);
        Assert.assertEquals(1, order);

        Random random = new Random();

        input = arrayTestHelper.randomArrayWithDistinctElements(10, random);
        int el = input[random.nextInt(input.length)];
        checkSelection(input, el);

        input = arrayTestHelper.randomArrayWithDistinctElements(10000000, random);
        el = input[random.nextInt(input.length)];
        checkSelection(input, el);

        input = arrayTestHelper.randomArrayWithDistinctElements(10000000, random);
        el = input[random.nextInt(input.length)];
        checkSelection(input, el);
    }

    private void checkSelection(int[] input, int el) {
        int order = selection.select(input, el);
        Arrays.sort(input);
        int elIndex = Arrays.binarySearch(input, el);
        Assert.assertEquals(order, elIndex+1);
    }

}
