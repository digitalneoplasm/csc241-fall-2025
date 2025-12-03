package algorithms;

public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            // partition the array.
            // pivotIndex is the index of the pivot element after partitioning.
            int pivotIndex = partition(arr, low, high);
            // sort data left of the pivot
            quickSort(arr, low, pivotIndex - 1);
            // sort data right of the pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // Select the first element to be the pivot. Any element will do, but this is easy.
        T pivot = arr[low];
        int up = low+1;
        int down = high;
        do {
            // Find the next element greater than (or equal to) the pivot.
            // Moving left to right
            while (up < high && pivot.compareTo(arr[up]) >= 0) {
                up++;
            }
            // Find the next element less than the pivot.
            // Moving right to left
            while (pivot.compareTo(arr[down]) < 0) {
                down--;
            }
            // If the up and down pointers have not crossed, swap the elements at those indices
            if (up < down) {
                swap(arr, up, down);
            }
        } while (up < down); // Keep going as long as we haven't crossed indices.
        // Move the pivot into position.
        swap(arr, low, down);
        return down;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] data = {25, 67, 4, 12, 14, 42, 96};
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(data);
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
