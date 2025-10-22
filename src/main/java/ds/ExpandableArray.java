package ds;

import java.util.AbstractList;

public class ExpandableArray<T extends Comparable<T>> extends AbstractList<T> {
    private T[] data;
    private int numElts;

    @SuppressWarnings("unchecked")
    public ExpandableArray() {
        data = (T[]) new Comparable[2];
        numElts = 0;
    }

    @SuppressWarnings("unchecked")
    private void growArray() {
        T[] bigger = (T[]) new Comparable[data.length * 2]; // 2n space (assuming data has size n)
        for (int i = 0; i < data.length; i++) { // Some small constant amt of space for i.
            bigger[i] = data[i];
        }
        data = bigger;
    }
    // O(n) space complexity.
    // O(n) time complexity. (loops through data just once).

    /**
     *
     * @param index {@inheritDoc}
     * @param item {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, T item) {
        // Case 1: index < 0 || index > numElts - error cases.
        if (index < 0 || index > numElts) {
            throw new IndexOutOfBoundsException();
        }
        // Make sure we have room to add another element.
        if (numElts == data.length) {
            growArray();
        }
        // Case 2: Adding at beginning/middle (shift elts over)
        // Make space...
        if ( index < numElts ) {
            for (int i = numElts; i >= index; i--) {
                data[i] = data[i - 1];
            }
        }
        // Do the addition, and also...
        // Case 3: Adding at the end (just add and be done)
        data[index] = item;
        numElts++;
    }
    // Time complexity - worst case - O(n), best case O(1)
    // Space complexity - worst case - O(n) when we have to grow. Best case O(1). 

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= numElts)
            throw new IndexOutOfBoundsException();
        T old = data[index];
        data[index] = element;
        return old;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= numElts)
            throw new IndexOutOfBoundsException();
        T old = (T) data[index];
        for (int i = index; i < numElts-1; i++) {
            data[i] = data[i+1];
        }
        numElts--;
        return old;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        numElts = 0;
        data = (T[]) new Comparable[10];
    }

    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > numElts - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    @Override
    public int size() {
        return numElts;
    }

    // Sorting Experiments //
    public void bubbleSort() {
        // Do an in-place bubble sort.
        // Use the fact that the elements are comparable to sort them (i.e., use compareTo).
        // a.compareTo(b) < 0 means a < b.
    }

}
