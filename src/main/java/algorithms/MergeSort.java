package algorithms;

import java.util.Arrays;

public class MergeSort {

    private MergeSort() {} // Utility class, hide public constructor

    public static <T extends Comparable<T>> void  mergeSort(T[] data) {
        // Data of length 1 or 0 is already sorted, nothing to do.
        if (data.length > 1) {
            // Create left and right arrays of half size.
            int halfSize = data.length / 2;
            T[] left = Arrays.copyOfRange(data, 0, halfSize);
            T[] right = Arrays.copyOfRange(data, halfSize, data.length);

            // Sort the left side
            mergeSort(left);
            // Sort the right side
            mergeSort(right);

            // Merge them together, store result in data.
            merge(left, right, data);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] result) {
        int l = 0; // idx in left
        int r = 0; // idx in right
        int o = 0; // idx in output
        // As long as we aren't off the end of either left or right...
        while (l < left.length && r < right.length) {
            // Find which is smaller, insert into the result.
            // increment indices.
            if (left[l].compareTo(right[r]) <= 0) {
                result[o++] = left[l++];
            } else {
                result[o++] = right[r++];
            }
        }
        // If one of the left or right has more items, copy them to result.
        while (l < left.length) {
            result[o++] = left[l++];
        }
        while (r < right.length) {
            result[o++] = right[r++];
        }
    }

    // Testing
    public static void main(String[] args) {
        Integer[] data = {25, 67, 4, 12, 14, 42, 96};
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        mergeSort(data);
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
