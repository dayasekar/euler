package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.*;

public class A35CircularPrimes {

    public static void main(String... args) {
        A35CircularPrimes impl = new A35CircularPrimes();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }

    void run() {
        Set<Integer> alreadPrime = new HashSet<>();
        for (int i = 2; (i < 100 && !alreadPrime.contains(i)); i++) {
            List<Integer> splitNos = mod(i);
            int iterSize = splitNos.size();
            int primeCount = 0;
            int isPrime = i;
            for (int j = 0; j < iterSize; j++) {
                int no = rotateNumber(isPrime);
                isPrime = no;
                if (isPrime(no)) {
                    primeCount++;
                }
            }
            if (iterSize == primeCount) {
                System.out.println(String.format("Prime %d ", i));
                alreadPrime.addAll(splitNos);
            }
        }
    }

    private boolean isPrime(long no) {
        double limit = Math.sqrt(no);
        for (long i = 2; i <= limit; i++) {
            if (no % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int rotateNumber(int no) {
        List<Integer> nos = mod(no);
        if (nos.size() > 1) {
            int removeNo = nos.remove(0);
            nos.add(removeNo);
        }
        String noString = "";
        for (Integer i : nos) {
            noString = noString + String.valueOf(i);
        }
        return Integer.valueOf(noString);
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
