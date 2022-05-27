package net.euler.scratch;

import java.util.ArrayList;
import java.util.List;

public class A12HighlyDivisibleTriangularNumbers {

    public static void main(String... args) {
        A12HighlyDivisibleTriangularNumbers impl = new A12HighlyDivisibleTriangularNumbers();
        impl.run(10);
    }

    public void run(int limit) {
        int sum = 0;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            sum += i;
            List<Integer> divisors = printDivisors(sum);
            if(divisors.size() >= limit) {
                System.out.print(sum);
                for (Integer i1 : divisors) {
                    System.out.print(" " + i1);
                }
                System.out.println("");
                break;
            }
        }
    }

    private List<Integer> printDivisors(int sum) {
        List<Integer> list = new ArrayList<>(1);
        for (int i = 1; i < sum; i++) {
            if (sum % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
