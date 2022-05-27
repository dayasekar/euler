package net.euler.scratch;

public class A4PalindromeProduct {

    public static void main(String... args) {
        A4PalindromeProduct object = new A4PalindromeProduct();
        object.run(10, 99);
        object.run(100, 999);
    }

    public void run(int start, int stop) {

        int left = 0;
        int right = 0;
        int product = 0;

        for (int i = start; i <= stop; i++) {
            for (int j = start; j <= stop; j++) {
                int prod = i * j;
                String value = String.valueOf(prod);
                StringBuilder sb = new StringBuilder(value);

                if (value.equals(sb.reverse().toString())) {
                    left = i;
                    right = j;
                    product = prod;
                }
            }
        }
        System.out.println(left + "*" + right + "\t" + product);
    }
}
