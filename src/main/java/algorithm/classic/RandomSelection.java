package main.java.algorithm.classic;

/**
 * Created by camiloporto on 12/5/17.
 */
public class RandomSelection {

    public int select(int[] input, int element) {
        ArrayPartition partitioner = new ArrayPartition();
        return select(input, 0, input.length-1, element, partitioner);
    }

    private int select(int[] input, int begin, int end, int element, ArrayPartition partition) {
        int pivotIndex = partition.partition(input, begin, end, 0);
        if(input[pivotIndex] == element) {
            return pivotIndex + 1;
        }
        if(input[pivotIndex] > element) {
            return select(input, begin, pivotIndex-1, element, partition);
        }
        else {
            return select(input, pivotIndex+1, end, element, partition);
        }
    }
}
