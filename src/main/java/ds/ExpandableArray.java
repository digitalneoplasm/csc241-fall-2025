package ds;

import java.util.AbstractList;

public class ExpandableArray extends AbstractList<String> {
    private String[] data;
    private int numElts;

    public ExpandableArray() {
        data = new String[2];
        numElts = 0;
    }

    private void growArray() {
        String[] bigger = new String[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }

    /**
     *
     * @param index {@inheritDoc}
     * @param item {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, String item) {
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

    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index > numElts - 1) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    // TODO:
    // - remove
    // - set
    // - clear

    @Override
    public int size() {
        return numElts;
    }
}
