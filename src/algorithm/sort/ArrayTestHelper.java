package algorithm.sort;

import java.util.Random;

/**
 * Created by camiloporto on 12/4/17.
 */
public class ArrayTestHelper {

    public int[] randomArray(int size, Random random) {
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }

}
