package main.java.algorithm.sort;

/**
 * Created by camiloporto on 12/4/17.
 */
public class MergeSort {

    public int[] sort(int[] input) {
        return mergeSort(input, 0, input.length-1);
    }

    private int[] mergeSort(int[] input, int begin, int end) {

        if(begin >= end) {
            return new int[]{input[end]};
        }

        int median = (begin + end) / 2;
        int[] left = mergeSort(input, begin, median);
        int[] right = mergeSort(input, median+1, end);

        int[] output2 = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if(left[l] <= right[r]) {
                output2[i] = left[l];
                l++;
            }
            else {
                output2[i] = right[r];
                r++;
            }
            i++;
        }

        int k = l;
        int[] remain = left;
        if(l >= left.length) {
            remain = right;
            k = r;
        }
        while (i < output2.length) {
            output2[i] = remain[k];
            i++;
            k++;
        }
        return output2;
    }
}
