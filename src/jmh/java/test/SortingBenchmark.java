package test;

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
    private ExpandableArray<Integer> presorted;

    // Re-initialize for each iteration to ensure fresh data
    @Setup(Level.Iteration)
    public void setup() {
        unsorted = new ExpandableArray<>();
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            unsorted.add(random.nextInt());
        }
        presorted = new ExpandableArray<>();
        for (int i = 0; i < arraySize; i++) {
            presorted.add(i);
        }
    }

    // Sorting benchmarks
//    @Benchmark
//    public void bubbleSortRandomBenchmark() {
//        ExpandableArray<Integer> ea = unsorted.copy();
//        ea.bubbleSort();
//    }
//
//    @Benchmark
//    public void bubbleSortPresortedBenchmark() {
//        ExpandableArray<Integer> ea = presorted.copy();
//        ea.bubbleSort();
//    }

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