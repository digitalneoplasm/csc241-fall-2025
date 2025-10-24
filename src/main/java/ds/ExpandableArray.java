package ds;

import java.util.AbstractList;
import java.util.Arrays;

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
        T old = data[index];
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
        return data[index];
    }

    @Override
    public int size() {
        return numElts;
    }

    public ExpandableArray<T> copy() {
        ExpandableArray<T> copy = new ExpandableArray<>();
        copy.data = Arrays.copyOf(data, data.length);
        copy.numElts = numElts;
        return copy;
    }

    // Sorting Experiments //
    public void bubbleSort() {
        // Do an in-place bubble sort.
        // Use the fact that the elements are comparable to sort them (i.e., use compareTo).
        // a.compareTo(b) < 0 means a < b.
        for (int i = 0; i < numElts; i++) {
            boolean changedData = false; // Optomization for pre-sorted data.
            for (int j = 1; j < numElts - i; j++) {
                if (data[j].compareTo(data[j-1]) < 0) {
                    T temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                    changedData = true;
                }
            }
            if (!changedData) return;
        }
    }

    public void insertionSort() {

    }

    public void selectionSort() {
        // limit starts at the end of data, moves backwards
        // one index at a time. When index is at 1, we're done!
        for (int limit = numElts - 1; limit > 0; limit = limit -1  ){
            // 1) Get the index of the maximum element in the list of
            // data up to the limit.
            int maxIdx = maxIndex(limit);
            // 2) Swap the maximum element with the element at the limit.
            swap(maxIdx, limit);
        }
    }

    private void swap(int maxIdx, int limit) {
        T temp = this.get(maxIdx);
        this.set(maxIdx, this.get(limit));
        this.set(limit, temp);
    }

    private int maxIndex(int limit) {
        // Find the max value in data up to limit, but also keep track
        // of what the index is of that max value. Return that index.

        // Our initial champion is the first element of data.
        T champion = this.get(0);
        int champIndex = 0;
        // Walk through the List up to and including the limit
        // For each element in data (these are our challengers!),
        // if the challenger is bigger than our champion, make it the new
        // champion.
        for ( int i = 1; i <= limit; i = i + 1) {
            T challenger = this.get(i);
            if ( challenger.compareTo(champion) > 0 ){
                champion = challenger;
                champIndex = i;
            }
        }
        // Return the champion
        return champIndex;
    }

}















