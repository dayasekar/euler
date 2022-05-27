package net.euler.scratch;

public class A2EvenFibonacciNumbers {

    public static void main(String... args) {
        A2EvenFibonacciNumbers object = new A2EvenFibonacciNumbers();
        object.run(4000000, true);
    }

    public void run(int limit, boolean even) {
        int previous = 0;
        int current = 1;
        int sum = 0;
        int val = 0;

        while (val < limit) {
            val = previous + current;
            previous = current;
            current = val;
            if (val < limit) {
                System.out.println(val);
                if (even && val % 2 == 0) {
                    sum = sum + val;
                }
                if (!even && val % 2 == 1) {
                    sum = sum + val;
                }
            }
        }
        System.out.println("Sum " + sum);
    }
}
