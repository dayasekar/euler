package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class A30FifthPower {
    public static void main(String... args) {
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        A30FifthPower impl = new A30FifthPower();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
        stopwatch.reset();
        stopwatch.start();
        impl.run2();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }

    void run() {
        int ceiling = 9;
        int power = 3;
        for (int i = 0; i <= ceiling; i++) {
            for (int j = 0; j <= ceiling; j++) {
                for (int k = 0; k <= ceiling; k++) {
                    for (int l = 0; l <= ceiling; l++) {
                        double sum = Math.pow(i, power) + Math.pow(j, power) + Math.pow(k, power) + Math.pow(l, power);
                        String nos = String.valueOf(i) + String.valueOf(j) + String.valueOf(k) + String.valueOf(l);
                        long nosLong = Long.valueOf(nos);

                        if (nosLong == sum) {
                            System.out.println("=" + nosLong);
                        }
                    }
                }
            }
        }
    }

    void run2() {
        int ceiling = 10000;
        int power = 3;
        IntStream.range(1, ceiling).forEach(l -> {
            List<Integer> indi = mod(l);
            double sum = 0;
            for (int i : indi) {
                sum += Math.pow(i, power);
            }
            StringBuilder nos = new StringBuilder();
            for (int i : indi) {
                nos.append(i);
            }

            long nosLong = Long.valueOf(nos.toString());

            if (nosLong == sum) {
                System.out.println("=" + nosLong);
            }
        });
    }

    List<Integer> mod(int no) {
        List<Integer> values = new ArrayList<>();
        int mod = 0;
        do {
            mod = no % 10;
            no = no / 10;
            values.add(mod);
        } while (no != 0);
        Collections.reverse(values);
        return values;
    }
}
