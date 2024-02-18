package net.euler.scratch;

import com.google.common.base.Stopwatch;

import java.util.*;

public class A32PanDigitalProducts {

    private static final Set<Integer> allNos = new TreeSet<>();

    {
        allNos.addAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public static void main(String... args) {
        A32PanDigitalProducts impl = new A32PanDigitalProducts();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        impl.run();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }

    void run() {
        Set<Integer> proceessedIteration = new HashSet<>();
        Set<Integer> products = new HashSet<>();

        for (int i = 2; i < 2000; i++) {
            if (!proceessedIteration.contains(i)) {
                List<Integer> modI = mod(i);
                for (int j = 2; j < 2000; j++) {
                    int product = i * j;
                    List<Integer> modList = mod(product);
                    List<Integer> modJ = mod(j);

                    if ((modList.size() + modI.size() + modJ.size()) > 9) {
                        break;
                    } else {
                        products.addAll(modList);
                        products.addAll(modI);
                        products.addAll(modJ);
                        if (products.containsAll(allNos)) {
                            proceessedIteration.add(j);
                            System.out.println(String.format("%d x %d = %d", i, j, product));
                        }
                        products.clear();
                    }
                }
            }
        }
    }

    List<Integer> mod(int no) {
        List<Integer> values = new ArrayList<>();
        int mod = 0;
        do {
            mod = no % 10;
            no = no / 10;
            values.add(mod);
        } while (no != 0);
        Collections.reverse(values);
        return values;
    }
}
