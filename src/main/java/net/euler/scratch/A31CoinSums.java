package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.*;

public class A31CoinSums {
    private static final int TOTAL_DENOMINATIONS = 8;
    private static final long COMBINATION_AMOUNT = 200;

    private static final long ONE_PENCE = 1;
    private static final long TWO_PENCE = 2;
    private static final long FIVE_PENCE = 5;
    private static final long TEN_PENCE = 10;
    private static final long TWENTY_PENCE = 20;
    private static final long FIFTY_PENCE = 50;

    private static final long ONE_POUND = 100;
    private static final long TWO_POUND = 200;

    public static void main(String... args) {
        A31CoinSums impl = new A31CoinSums();
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
        List<Long> denominations = Arrays.asList(ONE_PENCE, TWO_PENCE, FIVE_PENCE, TEN_PENCE, TWENTY_PENCE, FIFTY_PENCE, ONE_POUND, TWO_POUND);
        Map<Long, Long> factorsOfCombiAmount = new HashMap<>();
        for (Long denomination : denominations) {
            if (COMBINATION_AMOUNT % denomination == 0) {
                factorsOfCombiAmount.put(denomination, COMBINATION_AMOUNT / denomination);
            }
        }
        System.out.println("stop");
    }

    void run2() {

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
