package net.euler.scratch;

public class A16PowerDigitSum {

    public static void main(String... args) {
        A16PowerDigitSum impl = new A16PowerDigitSum();
        impl.run(2, 15);
        impl.run(2, 1000);
    }

    void run(int no, int pow) {
        long power = (long) Math.pow(no, pow);
        System.out.println(power);
        long sum = 0;
        do {
            if (power <= 0)
                break;
            long reduced = power / 10;
            long mod = power % 10;
            sum += mod;
            power = reduced;
        } while (true);
        System.out.println(sum);
    }
}
