package net.euler.scratch;

public class A23NonAbundantSums {

    public static void main(String... args) {
        A23NonAbundantSums impl = new A23NonAbundantSums();
        impl.run(100);
    }

    void run(int n) {
        for (int i = 1; i < n; i++) {
            int divisorSum = divisorSum(i);
            if(divisorSum > i) {
                System.out.println(String.format("n = %d and sum = %d", i, divisorSum));
            }
        }
    }

    int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= (n / 2); i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
