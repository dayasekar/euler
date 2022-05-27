package net.euler.scratch;

import java.util.HashMap;
import java.util.Map;

public class A17NumberLetterCounts {
    public static void main(String... args) {
        A17NumberLetterCounts impl = new A17NumberLetterCounts();
        impl.run(6);
        impl.run(15);
        impl.run(40);
        impl.run(55);
        impl.run(110);
        impl.run(115);
        impl.run(234);
        impl.run(342);
        impl.run(501);
        impl.run(799);
        impl.run(900);
        impl.run(999);
        impl.run(1999);
    }

    void run(int number) {
        Map<Integer, String> onesMap = new HashMap<>() {{
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
        }};
        Map<Integer, String> tensMap = new HashMap<>() {{
            put(2, "Twenty");
            put(3, "Thirty");
            put(4, "Forty");
            put(5, "Fifty");
            put(6, "Sixty");
            put(7, "Seventy");
            put(8, "Eighty");
            put(9, "Ninety");
        }};
        Map<Integer, String> teensSeriesMap = new HashMap<>() {{
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
        }};
        Map<Integer, String> hundredsMap = new HashMap<>() {{
            put(1, "One Hundred");
            put(2, "Two Hundred");
            put(3, "Three Hundred");
            put(4, "Four Hundred");
            put(5, "Five Hundred");
            put(6, "Six Hundred");
            put(7, "Seven Hundred");
            put(8, "Eight Hundred");
            put(9, "Nine Hundred");
        }};

        int ones = number % 10;
        int tens = number / 10 % 10;
        int hundred = number / 100;

        StringBuilder sb = new StringBuilder();

        if (hundred > 0) {
            if (tens > 0 || ones > 0) {
                sb.append(hundredsMap.get(hundred) + " and ");
            } else {

                sb.append(hundredsMap.get(hundred));
            }
        }

        if (tens > 1 && hundred > 0) {
            sb.append(tensMap.get(tens));
        } else if (tens == 1) {
            sb.append(teensSeriesMap.get(Integer.parseInt(String.valueOf(tens) + String.valueOf(ones))));
        } else if (tens > 1) {
            sb.append(tensMap.get(tens));
        }

        if (ones > 0 && tens > 1) {
            sb.append(" " + onesMap.get(ones));
        } else if (ones > 0 && tens != 1) {
            sb.append(onesMap.get(ones));
        }
        System.out.println(number + " " + sb.toString());
        System.out.println(sb.toString().replace(" ", "").length());
        System.out.println("");
    }
}
