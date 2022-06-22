package net.euler.scratch;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A26ReciprocalCycles {

    public static void main(String... args) {
        A26ReciprocalCycles impl = new A26ReciprocalCycles();
        impl.run(10);
    }

    void run(int limit) {
        int max = 0;
        int iValue = 0;
        for (int i = 2; i <= limit; i++) {
            BigDecimal numerator = new BigDecimal("1");
            BigDecimal denominator = new BigDecimal(Integer.toString(i));
            BigDecimal dValue = numerator.divide(denominator, MathContext.DECIMAL128);
            String value = dValue.toPlainString();
            String decimal = value.substring(value.indexOf(".") + 1);
            System.out.println(i + " " + value + " " + decimal);
            for (int j = 0; j < decimal.length(); j++) {
                int match = 0;
                for (int k = j + 1; k < decimal.length(); k++) {
                    String sub = decimal.substring(j, k);
//                    System.out.println(sub);
                    Pattern pattern = Pattern.compile(sub);
                    Matcher matcher = pattern.matcher(decimal);
                    int prev = -1;
                    while (matcher.find()) {
                        match = sub.length();
                        if (match > max && (matcher.start() == prev)) {
                            System.out.println(sub + " " + prev + " " + matcher.start() + " " + matcher.end() + " " + (matcher.end() - matcher.start()));
                            max = match;
                            iValue = i;
                            k = decimal.length();
                            j = decimal.length();
                        }
                        prev = matcher.end();
                    }
                }
            }
        }

        System.out.println("Ans " + iValue + " " + max);
    }
}
