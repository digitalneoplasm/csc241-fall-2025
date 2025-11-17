//package test;
//
//import ds.ExpandableArray;
//import org.openjdk.jmh.annotations.*;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.ListIterator;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(value = 1, warmups = 1)
//@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
//@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//@State(Scope.Benchmark)
//public class LLBenchmark {
//
//    private LinkedList<Integer> ll;
//    private ArrayList<Integer> al;
//
//    @Param({"100", "1000", "10000"})
//    public int addCount;
//
//    // Re-initialize for each iteration to ensure fresh data
//    @Setup(Level.Iteration)
//    public void setup() {
//        al = new ArrayList<>();
//        ll = new LinkedList<>();
//        Random random = new Random();
//        for (int i = 0; i < 100000; i++) {
//            int r = random.nextInt();
//            ll.add(r);
//            al.add(r);
//        }
//    }
//
//    @Benchmark
//    public void addWithListIterator() {
//        Random random = new Random();
//        int addIdx = random.nextInt(99999);
//
//        ListIterator<Integer> it = ll.listIterator(addIdx);
//        for (int i = 0; i < addCount; i++) {
//            it.add(random.nextInt());
//        }
//    }
//
//    @Benchmark
//    public void addWithoutListIterator() {
//        Random random = new Random();
//        int addIdx = random.nextInt(99999);
//
//        for (int i = 0; i < addCount; i++) {
//            ll.add(addIdx, random.nextInt());
//        }
//    }
//
//    @Benchmark
//    public void arrayListAdd() {
//        Random random = new Random();
//        int addIdx = random.nextInt(99999);
//
//        for (int i = 0; i < addCount; i++) {
//            al.add(addIdx, random.nextInt());
//        }
//    }
//}
//
///*
//Benchmark                           (addCount)  Mode  Cnt    Score     Error  Units
//LLBenchmark.addWithListIterator            100  avgt    5    0.097 ±   0.068  ms/op
//LLBenchmark.addWithListIterator           1000  avgt    5    0.370 ±   0.030  ms/op
//LLBenchmark.addWithListIterator          10000  avgt    5    3.180 ±   0.359  ms/op
//LLBenchmark.addWithoutListIterator         100  avgt    5    3.938 ±   2.337  ms/op
//LLBenchmark.addWithoutListIterator        1000  avgt    5   41.592 ±  13.674  ms/op
//LLBenchmark.addWithoutListIterator       10000  avgt    5  429.361 ± 202.128  ms/op
//LLBenchmark.arrayListAdd                   100  avgt    5   0.758 ±  0.032  ms/op
//LLBenchmark.arrayListAdd                  1000  avgt    5   7.615 ±  0.543  ms/op
//LLBenchmark.arrayListAdd                 10000  avgt    5  79.493 ± 16.700  ms/op
// */