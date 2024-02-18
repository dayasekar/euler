package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class A34DigitFactorials {

    public static void main(String... args) {
        A34DigitFactorials impl = new A34DigitFactorials();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }

    void run() {
        for (int i = 3; i < 100000; i++) {
            List<Long> mods = mod(i);
            LongSummaryStatistics sum = mods.stream().map(e -> {
                return getFactorial(e);
            }).collect(Collectors.summarizingLong(l -> l));
            if (i == sum.getSum()) {
                System.out.println(i);
            }
        }
    }

    long getFactorial(long i) {
        long factorial = 1;
        for (long j = 2; j <= i; j++) {
            factorial *= j;
        }
        return factorial;
    }

    List<Long> mod(int no) {
        List<Long> values = new ArrayList<>();
        long mod = 0;
        do {
            mod = no % 10;
            no = no / 10;
            values.add(mod);
        } while (no != 0);
        Collections.reverse(values);
        return values;
    }
}
