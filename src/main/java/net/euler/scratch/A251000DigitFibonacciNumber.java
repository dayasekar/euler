package net.euler.scratch;

import java.math.BigInteger;

public class A251000DigitFibonacciNumber {

    public static void main(String... args) {
        A251000DigitFibonacciNumber impl = new A251000DigitFibonacciNumber();
        impl.run(1000);
    }

    void run(int limit) {
        BigInteger iOfn = new BigInteger("0");
        BigInteger iOfnPlus1 = new BigInteger("1");
        for (int i = 2; i <= limit; i++) {
            BigInteger current = iOfn.add(iOfnPlus1);
            iOfn = iOfnPlus1;
            iOfnPlus1 = current;
            System.out.println(String.format("%d) %d", i, current));
        }
    }
}

