package ds;

import java.util.AbstractList;

public class ExpandableArray extends AbstractList<String> {
    private String[] data;
    private int numElts;

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
        // Case 2: Adding at the end (just add and be done)

        // Case 3: Adding at beginning/middle (shift elts over)
    }




    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public int size() {
        return numElts;
    }
}
