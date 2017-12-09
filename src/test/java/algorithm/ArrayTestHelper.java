package algorithm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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

    public int[] randomArrayWithDistinctElements(int size, Random random) {
        int[] array = new int[size];
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add(random.nextInt(Integer.MAX_VALUE));
        }

        Iterator<Integer> it = set.iterator();
        int i = 0;
        while (i < size) {
            array[i] = it.next();
            i++;
        }
        return array;
    }


}
