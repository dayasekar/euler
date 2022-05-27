package net.euler.scratch;

import java.util.Set;
import java.util.TreeSet;

public class A3LargestPrimeFactor {
    public static void main(String... args) {
        A3LargestPrimeFactor object = new A3LargestPrimeFactor();
        object.run(13195);
        object.run(600851475143l);
    }

    public void run(long limit) {
        Set<Long> primes = new TreeSet<>();
        for (long i = 2; i < limit; i++) {
            if (limit % i == 0 && isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }

        for (long j : primes) {
            System.out.println(limit + "\t" + j);
        }
    }

    private boolean isPrime(long no) {
        for (long i = 2; i <= Math.sqrt(no); i++) {
            if (no % i == 0) {
                return false;
            }
        }
        return true;
    }
}
