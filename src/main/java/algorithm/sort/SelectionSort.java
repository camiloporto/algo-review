package algorithm.sort;

/**
 * Created by camiloporto on 12/5/17.
 */
public class SelectionSort {

    public void sort(int[] input) {

        for(int i = 0; i < input.length; i++) {
            int k = indexOfMinElement(input, i);
            swap(i, k, input);
        }
    }

    private void swap(int i, int k, int[] input) {
        int aux = input[i];
        input[i] = input[k];
        input[k] = aux;
    }

    private int indexOfMinElement(int[] input, int fromIndex) {
        int minIndex = fromIndex;
        for(int i = fromIndex; i < input.length; i++) {
            if(input[minIndex] > input[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
