package net.euler.scratch;

import java.util.Calendar;

public class A19CountingSundays {

    public static void main(String... args) {
        A19CountingSundays impl = new A19CountingSundays();
        int count = impl.run(1901, 2000, Calendar.SUNDAY);
        System.out.println(count);
    }

    int run(int startYear, int endYear, int day) {
        Calendar calendar = Calendar.getInstance();
        int count = 0;
        for (int y = startYear; y <= endYear; y++) {
            for (int m = 1; m <= 12; m++) {
                calendar.set(Calendar.YEAR, y);
                calendar.set(Calendar.MONTH, m);
                calendar.set(Calendar.DAY_OF_MONTH, 1);

                if (calendar.get(Calendar.DAY_OF_WEEK) == day) {
                    System.out.println(calendar.getTime());
                    count++;
                }
            }
        }
        return count;
    }
}
