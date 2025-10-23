//package test;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//
//import java.util.concurrent.TimeUnit;
//
//@State(Scope.Benchmark) // Define the scope of the state (e.g., per benchmark instance)
//@OutputTimeUnit(TimeUnit.MICROSECONDS) // Specify the time unit for results
//@Fork(value = 1) // Number of times to fork the JVM
//@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS) // Warmup iterations
//@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS) // Measurement iterations
//public class TestBenchmark {
//
//    // State variables can be initialized here
//    private int value = 10;
//
//    @Benchmark
//    public void myBenchmarkMethod(Blackhole blackhole) {
//        // Your code to benchmark
//        int result = value * 2;
//        blackhole.consume(result); // Consume the result to prevent dead code elimination
//    }
//
//    // You can have multiple benchmark methods within the same class
//    @Benchmark
//    public void anotherBenchmarkMethod() {
//        // Another piece of code to benchmark
//        String s = "Hello" + "World";
//    }
//}