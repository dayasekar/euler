package net.euler.scratch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class A24LexicographicPermutations {

    private CountDownLatch latch = new CountDownLatch(1);
    private ListeningMap<String, Boolean> map = new ListeningMap<>();
    private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    private int factLength = 0;

    public static void main(String... args) throws InterruptedException {
        A24LexicographicPermutations impl = new A24LexicographicPermutations();
        impl.run("0123456789");
    }

    int fact(int size) {
        int fact = 1;
        for (int i = 1; i <= size; i++) {
            fact *= i;
        }
        return fact;
    }

    void run(String n) throws InterruptedException {
        factLength = fact(n.length());
        System.out.println(new Date());
        map.addListener(new MapPutEntryListener());
        map.put(n, false);

        Thread thread = new Thread(new MapMonitor());
        thread.start();
    }

    class ListeningMap<K, V> extends ConcurrentHashMap<K, V> {
        PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

        public void addListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        @Override
        public V put(K key, V value) {
            V val = super.put(key, value);
            propertyChangeSupport.firePropertyChange((String) key, val, value);
            return val;
        }
    }

    class MapPutEntryListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ((Boolean) evt.getNewValue() == false) {
                Runner runner = new Runner(evt.getPropertyName());
                executor.execute(runner);
            }
        }
    }

    class Runner implements Runnable {
        private String n;

        public Runner(String n) {
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 1; i < n.length(); i++) {
                String shiftLeft = shiftLeft(n, i);
                if (!map.containsKey(shiftLeft)) {
                    map.put(shiftLeft, false);
                }
            }
            map.put(n, true);
            if (map.size() == factLength) {
                latch.countDown();
            }
        }

        String shiftLeft(String n, int index) {
            char indexChar = n.charAt(index);
            char prevChar = n.charAt(index - 1);
            char[] array = n.toCharArray();
            array[index - 1] = indexChar;
            array[index] = prevChar;
            return new String(array);
        }
    }

    class MapMonitor implements Runnable {

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(new Date());
            List<String> list = new ArrayList<>();
            list.addAll(map.keySet());
            Collections.sort(list);
            if (list.size() > 1000000) {
                System.out.println(list.get(1000000));
            }
            executor.shutdown();
            System.out.println(new Date());
        }
    }
}
