package test;

import algorithms.MergeSort;
import algorithms.QuickSort;
import ds.BST;
import ds.ExpandableArray;
import org.openjdk.jmh.annotations.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SortingBenchmark {

    @Param({"1000", "10000", "100000"})
    public int arraySize;

    private ExpandableArray<Integer> unsorted;
    private Integer[] unsortedArray;
    private ExpandableArray<Integer> presorted;
    private Integer[] presortedArray;

    // Re-initialize for each iteration to ensure fresh data
    @Setup(Level.Iteration)
    public void setup() {
        unsorted = new ExpandableArray<>();
        unsortedArray = new Integer[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            int randNum = random.nextInt();
            unsorted.add(randNum);
            unsortedArray[i] = randNum;
        }
        presorted = new ExpandableArray<>();
        presortedArray = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            presorted.add(i);
            presortedArray[i] = i;
        }
    }

    // Sorting benchmarks
    @Benchmark
    public void bubbleSortRandomBenchmark() {
        ExpandableArray<Integer> ea = unsorted.copy();
        ea.bubbleSort();
    }

    @Benchmark
    public void bubbleSortPresortedBenchmark() {
        ExpandableArray<Integer> ea = presorted.copy();
        ea.bubbleSort();
    }

    @Benchmark
    public void selectionSortRandomBenchmark() {
        ExpandableArray<Integer> ea = unsorted.copy();
        ea.selectionSort();
    }

    @Benchmark
    public void selectionSortPresortedBenchmark() {
        ExpandableArray<Integer> ea = presorted.copy();
        ea.selectionSort();
    }

    @Benchmark
    public void mergeSortRandomBenchmark() {
        MergeSort.mergeSort(unsortedArray.clone());
    }

    @Benchmark
    public void mergeSortPresortedBenchmark() {
        MergeSort.mergeSort(presortedArray.clone());
    }


    @Benchmark
    public void quickSortRandomBenchmark() {
        QuickSort.quickSort(unsortedArray.clone());
    }

    @Benchmark
    public void quickSortPresortedBenchmark() {
        QuickSort.quickSort(presortedArray.clone());
    }

    @Benchmark
    public void bstSortUnsortedBenchmark() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < unsorted.size(); i++) {
            bst.insert(unsorted.get(i));
        }
        bst.sorted();
    }

    @Benchmark
    public void bstSortPresortedBenchmark() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < presorted.size(); i++) {
            bst.insert(presorted.get(i));
        }
        bst.sorted();
    }
}