package algorithm.sort;

import datastructure.Heap;

/**
 * Created by camiloporto on 12/7/17.
 */
public class HeapSort {

    //FIXME do it inplace
    public int[] sort(int[] input) {
        Heap heap = new Heap(input);
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = heap.extractMin();
        }
        return output;
    }
}
