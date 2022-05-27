package net.euler.scratch;

public class A5SmallestMultiple {

    public static void main(String... args) {
        A5SmallestMultiple object = new A5SmallestMultiple();
        object.run(1, 10);
        object.run(1, 20);
    }

    public void run(int start, int stop) {
        int j = 1;
        boolean cont = true;

        do {
            for (int i = start; i <= stop; i++) {
                if (j % i == 0 && i == stop) {
                    System.out.println(j);
                    cont = false;
                } else if (j % i == 0) {
                    continue;
                } else {
                    break;
                }
            }
            j++;
        } while (cont);
    }
}
