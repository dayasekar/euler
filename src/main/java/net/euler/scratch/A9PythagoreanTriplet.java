package net.euler.scratch;

public class A9PythagoreanTriplet {

    public static void main(String... args) {
        A9PythagoreanTriplet impl = new A9PythagoreanTriplet();
        impl.run(100, 1000);
    }

    public void run(int limit, int sum) {
        int a = 1;
        int total = 0;

        do {
            int b = 1;
            while (b <= sum) {
                int c = 1;
                while (c <= sum) {
                    total = a + b + c;
                    int squareSum = (a * a) + (b * b);
                    int square = c * c;
                    if (total == sum && squareSum == square) {
                        int product = a * b * c;
                        System.out.println(a + "\t" + b + "\t" + c + "\t" + product);
                        a = b = c = sum;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }
        while (a <= sum);
    }
}
