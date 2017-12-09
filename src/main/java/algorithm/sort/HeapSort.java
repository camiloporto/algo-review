package algorithm.sort;

import datastructure.Heap;

/**
 * Created by camiloporto on 12/7/17.
 */
public class HeapSort {

    public void sort(int[] input) {
        final boolean MAX_HEAP = false;

        Heap heap = new Heap(input, MAX_HEAP);
        int max;
        for (int i = input.length-1; i >= 0; i--) {
            max = heap.extractRoot();
            input[i] = max;
        }
    }
}
