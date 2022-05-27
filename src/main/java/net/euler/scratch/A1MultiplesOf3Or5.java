package net.euler.scratch;

import java.util.Arrays;
import java.util.stream.Collectors;

public class A1MultiplesOf3Or5 {

    public static void main(String... args) {
        A1MultiplesOf3Or5 object = new A1MultiplesOf3Or5();
        object.run(10, 3, 5);
        object.run(1000, 3, 5);
        object.run(1000, 3);
        object.run(1000);
    }

    public void run(int limit, int... multiples) {
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            for (int multi : multiples) {
                if (i % multi == 0) {
                    sum = sum + i;
                }
            }
        }
        System.out.println(limit + "\t[" + Arrays.stream(multiples).mapToObj(String::valueOf).collect(Collectors.joining(",")) + "]\t" + sum);
    }
}
