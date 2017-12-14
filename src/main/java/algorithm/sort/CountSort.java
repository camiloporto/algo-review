package algorithm.sort;

/**
 * Created by camiloporto on 12/13/17.
 */
public class CountSort {

    public void sort(int[] input, int maxValue) {
        int[] histogram = new int[maxValue+1];
        for(int i = 0; i< input.length; i++) {
            histogram[input[i]]++;
        }
        int k = 0;
        for(int i = 0; i < histogram.length; i++) {
            if(histogram[i] > 0) {
                for (int j = 0; j < histogram[i]; j++) {
                    input[k++] = i;
                }
            }
        }
    }
}
