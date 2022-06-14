package net.euler.scratch;

public class A21AmicableDivisors {

    public static void main(String... args) {
        A21AmicableDivisors impl = new A21AmicableDivisors();
        impl.run(1000);
    }

    public void run(int n) {
        for (int i = 1; i < n; i++) {
            int divisorSum = divisorSum(i);
            int reverseSum = divisorSum(divisorSum);
            if (i == reverseSum) {
                System.out.println(String.format("d(%d) = %d and d(%d) = %d", i, divisorSum, divisorSum, reverseSum));
            }
        }
    }

    int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= (n/2); i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
