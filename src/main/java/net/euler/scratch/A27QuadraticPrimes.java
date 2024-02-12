package net.euler.scratch;

import static com.google.common.math.LongMath.isPrime;

public class A27QuadraticPrimes {
    public static void main(String... args) {
        A27QuadraticPrimes impl = new A27QuadraticPrimes();
        impl.run();
    }

    void run() {
        int isPrimeCount = 0;
        for (int n = 1; n < 10000; n++) {
            for (int a = 1; a < 1000; a++) {
                isPrimeCount = 0;
                for (int b = 1; b <= 1000; b++) {
                    long v = (long) (Math.pow(n, 2) + (a * n) + b);
                    if (isPrime(v)) {
                        isPrimeCount++;
                    }
                }
                if (isPrimeCount >= n) {
                    System.out.println(String.format("a %d, n %d count %d", a, n, isPrimeCount));
                }
            }
        }
    }
}
