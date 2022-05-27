package net.euler.scratch;

public class A6SumSquareDifference {

    public static void main(String... args) {
        A6SumSquareDifference impl = new A6SumSquareDifference();
        impl.run(10);
        impl.run(100);
    }

    private void run(int limit) {
        int sum = 0;
        int sumSquare = 0;

        for (int i = 1; i <= limit; i++) {
            sum += i;
            sumSquare += (i * i);
        }
        int difference = sumSquare - (sum * sum);
        System.out.println(difference);
    }
}
