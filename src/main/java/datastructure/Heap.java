package datastructure;

/**
 * Created by camiloporto on 12/7/17.
 */
public class Heap {

    private int size = 0;
    private int[] data;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    public Heap(int[] data) {
        this.data = data;
        this.size = data.length;
        heapify();
    }


    private void heapify() {
        int initIndex = father(lastElementIndex());
        for(int k = initIndex; k >=0; k--) {
            bubbleDown(k);
        }
    }

    public int peek() {
        return data[0];
    }

    public void insert(int element) {
        if(size == capacity) throw new IllegalStateException("heap full");
        size++;
        data[lastElementIndex()] = element;
        bubbleUp();
    }

    public int extractMin() {
        int min = data[0];
        data[0] = data[lastElementIndex()];
        size--;
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int nodeIndex) {
        int i = nodeIndex;
        while(left(i) <= lastElementIndex() && fatherGreaterThanChildren(i)) {
            int minIndex = minChildrenIndexOf(i);
            swap(minIndex, i);
            i = minIndex;
        }
    }

    private boolean fatherGreaterThanChildren(int fatherIndex) {
        int left = left(fatherIndex);
        int right = right(fatherIndex);
        boolean isGreater = (left <= lastElementIndex() && data[fatherIndex] > data[left]) ||
                (right <= lastElementIndex() && data[fatherIndex] > data[right]);
        return isGreater;
    }

    private int minChildrenIndexOf(int fatherIndex) {
        int left = left(fatherIndex);
        int right = right(fatherIndex);
        if (right <= lastElementIndex()) {
            return Math.min(data[left], data[right]) == data[left] ? left : right;
        }
        return left;
    }

    private void bubbleUp() {
        int i = lastElementIndex();
        while(father(i) >= 0 && data[i] < data[father(i)]) {
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
}
