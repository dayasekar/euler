package net.euler.scratch;

import java.math.BigInteger;

public class A20FactorialDigitSum {

    public static void main(String... args) {
        A20FactorialDigitSum impl = new A20FactorialDigitSum();
        impl.run(1000);
        impl.run(10);
        impl.run(1);
        impl.run(3);
    }

    public void run(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        BigInteger nBig = BigInteger.valueOf(n);
        for (BigInteger i = BigInteger.valueOf(1); i.compareTo(nBig) <= 0; i = i.add(BigInteger.ONE)) {
            fact = fact.multiply(i);
        }
        String factStr = fact.toString();
        long factSum = 0;
        for (Character c : factStr.toCharArray()) {
            factSum += Long.parseLong(String.valueOf(c));
        }
        System.out.println(n + "\t" + fact + "\t" + factSum);
    }
}
