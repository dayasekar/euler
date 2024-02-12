package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class A29DistinctPowers {
    public static void main(String... args) {
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        A29DistinctPowers impl = new A29DistinctPowers();
        Stopwatch stopwatch = Stopwatch.createStarted();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
        stopwatch.reset();
        stopwatch.start();
        impl.run2();
        System.out.println(stopwatch.elapsed());
        stopwatch.stop();
    }

    void run() {
        int floorLimit = 2;
        int ceilingLimit = 100;
        Set<Double> set = new HashSet<>(ceilingLimit);

        for (int a = floorLimit; a <= ceilingLimit; a++) {
            for (int b = floorLimit; b <= ceilingLimit; b++) {
                double result = Math.pow(a, b);
                set.add(result);
            }
        }
        System.out.println(set.size());
    }

    void run2() {
        int floorLimit = 2;
        int ceilingLimit = 101;
        Set<Double> set = new HashSet<>(ceilingLimit);

        IntStream.range(floorLimit, ceilingLimit).parallel().forEach(a -> {
            IntStream.range(floorLimit, ceilingLimit).parallel().forEach(b -> {
                double result = Math.pow(a, b);
                set.add(result);
            });
        });
        System.out.println(set.size());
    }
}
