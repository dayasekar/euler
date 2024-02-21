package net.euler.scratch;

import java.util.ArrayList;
import java.util.List;

public class A7Prime1001 {

    public static void main(String... args) {
        A7Prime1001 impl = new A7Prime1001();
        impl.run(6);
        impl.run(10001);
    }

    public void run(int occurrence) {
        int i = 2;
        List<Integer> list = new ArrayList<>();
        do {
            if (isPrime(i)) {
                list.add(i);
            }
            if (list.size() == occurrence) {
                break;
            }
            i++;
        } while (true);
        System.out.println(list.get(occurrence -1));
    }

    private boolean isPrime(long no) {
        double limit = Math.sqrt(no);
        for (long i = 2; i <= limit; i++) {
            if (no % i == 0) {
                return false;
            }
        }
        return true;
    }
}
