package algorithm;

/**
 * Created by camiloporto on 2/6/17.
 */
public class ArrayPartition {

    public int partition(int[] input, int pivotIndex) {
        swap(input, 0, pivotIndex);
        int pivot = input[0];
        int i = 0;
        for(int j = 1; j < input.length; j++) {
            if(input[j] < pivot) {
                swap(input, i+1, j);
                i++;
            }
        }
        swap(input, 0, i);
        return i;
    }

    private void swap(int[] input, int i, int j) {
        int aux = input[i];
        input[i] = input[j];
        input[j] = aux;
    }
}
