package net.euler.scratch;

public class A10SummationOfPrimes {

    public static void main(String... args) {
        A10SummationOfPrimes impl = new A10SummationOfPrimes();
        impl.run(10);
        impl.run(2000000);
    }

    public void run(int ceiling) {
        int sum = 0;
        for (int i = 2; i <= ceiling; i++) {
            if (isPrime(i)) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);
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
