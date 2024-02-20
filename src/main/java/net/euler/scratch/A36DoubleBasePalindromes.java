package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A36DoubleBasePalindromes {

    public static void main(String... args) {
        A36DoubleBasePalindromes impl = new A36DoubleBasePalindromes();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }

    void run() {
        for (int i = 1; i < 1000; i++) {
            List<Integer> order = mod(i);
            List<Integer> reverse = new ArrayList<>(order);
            Collections.copy(reverse, order);
            Collections.reverse(reverse);

            if (order.hashCode() == reverse.hashCode()) {
                System.out.println(i);
            }
        }
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
