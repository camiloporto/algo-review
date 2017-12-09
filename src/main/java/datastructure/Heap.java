package datastructure;

import java.util.Comparator;

/**
 * Created by camiloporto on 12/7/17.
 */
public class Heap {

    private int size;
    private int[] data;
    private int capacity;
    private boolean isMinHeap = true;

    private Comparator<Integer> comparator;

    public Heap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        size = 0;
        this.comparator = new AscComparator();
    }

    public Heap(int[] data, boolean minHeap) {
        this.data = data;
        this.size = data.length;
        this.isMinHeap = minHeap;
        if(minHeap) {
            this.comparator = new AscComparator();
        }
        else {
            this.comparator = new DescComparator();
        }
        heapify();
    }

    private void heapify() {
        int initIndex = father(lastElementIndex());
        for(int k = initIndex; k >=0; k--) {
            bubbleDown(k);
        }
    }

    public int peek() {
        if(size == 0) throw new IllegalStateException("Heap empty");

        return data[0];
    }

    public void insert(int element) {
        if(size == capacity) throw new IllegalStateException("heap full");
        size++;
        data[lastElementIndex()] = element;
        bubbleUp();
    }

    public int extractRoot() {
        if(size == 0) throw new IllegalStateException("Heap empty");

        int min = data[0];
        data[0] = data[lastElementIndex()];
        size--;
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int nodeIndex) {
        int i = nodeIndex;
        while(!isLeaf(i) && isHeapPropertyBroken(i)) {
            int minIndex;;
            int maxIndex;
            if(isMinHeap) {
                minIndex = indexOfLowerChild(i);
                swap(minIndex, i);
                i = minIndex;
            }
            else {
                maxIndex = indexOfGreaterChild(i);
                swap(maxIndex, i);
                i = maxIndex;
            }
        }
    }

    private int indexOfGreaterChild(int fatherIndex) {
        int left = left(fatherIndex);
        int right = right(fatherIndex);
        if (right <= lastElementIndex()) {
            return Math.max(data[left], data[right]) == data[left] ? left : right;
        }
        return left;
    }

    private boolean isLeaf(int i) {
        return left(i) > lastElementIndex();
    }

    private boolean isHeapPropertyBroken(int fatherIndex) {
        int left = left(fatherIndex);
        int right = right(fatherIndex);
        boolean isGreater = (left <= lastElementIndex() &&  comparator.compare(data[fatherIndex], data[left])  > 0) ||
                (right <= lastElementIndex() && comparator.compare(data[fatherIndex], data[right]) > 0);
        return isGreater;
    }

    private int indexOfLowerChild(int fatherIndex) {
        int left = left(fatherIndex);
        int right = right(fatherIndex);
        if (right <= lastElementIndex()) {
            return Math.min(data[left], data[right]) == data[left] ? left : right;
        }
        return left;
    }

    private void bubbleUp() {
        int i = lastElementIndex();
        while(father(i) >= 0 && comparator.compare(data[i], data[father(i)]) < 0) {
            swap(i, father(i));
            i = father(i);
        }
    }

    private void swap(int i, int j) {
        int aux = data[i];
        data[i] = data[j];
        data[j] = aux;
    }

    private int lastElementIndex() {return size-1;}

    private int father(int i) {
        return (i-1) / 2;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i+1) * 2;
    }

    private static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    private static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2) * -1;
        }
    }
}
