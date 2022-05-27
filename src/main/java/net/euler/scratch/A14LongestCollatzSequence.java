package net.euler.scratch;

public class A14LongestCollatzSequence {

    public static void main(String... args) {
        A14LongestCollatzSequence impl = new A14LongestCollatzSequence();
        impl.run();
    }

    void run() {
        int highest = 0;
        for (int i = 106239; i < 106240; i++) {
            int currentSize = 0;
            int j = i;
            System.out.print(i);
            do {
                j = compute(j);
                System.out.print("->" + j);
                currentSize++;
            } while (j != 1);
            System.out.println("");
            if (currentSize > highest) {
                highest = currentSize;
                System.out.print(i + " " + highest);
                System.out.println("");
            }
        }
    }

    int compute(int i) {
        if (i % 2 == 0) {
            return (i / 2);
        } else {
            return (3 * i) + 1;
        }
    }
}
