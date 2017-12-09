package algorithm.sort;

import algorithm.classic.ArrayPartition;

/**
 * Created by camiloporto on 12/4/17.
 */
public class QuickSort {

    private ArrayPartition partitioner;

    public QuickSort() {
        this.partitioner = new ArrayPartition();
    }

    public void sort(int[] input) {
        sort(input, 0, input.length-1);
    }

    private void sort(int[] input, int beginIndex, int endIndex) {
        if(beginIndex > endIndex)
            return;
        int pivotIndex = partitioner.partition(input, beginIndex, endIndex, 0);
        sort(input, beginIndex, pivotIndex-1);
        sort(input, pivotIndex+1, endIndex);
    }
}
