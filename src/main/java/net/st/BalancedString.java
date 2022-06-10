package net.st;

import java.util.ArrayList;
import java.util.List;

public class BalancedString {

    public static void main(String... args) {
        BalancedString impl = new BalancedString();
        impl.run("()(())");
        impl.run(")((()");
        impl.run("()()()())(");
    }

    void run(String input) {
        char[] c = input.toCharArray();
        List<Character> open = new ArrayList<>();
        List<Character> closed = new ArrayList<>();

        for (int i = 0; i < c.length; i++) {

            if (c[i] == ')') {
                closed.add(c[i]);
            } else if (c[i] == '(') {
                open.add(c[i]);
            }
        }
        if (open.size() == closed.size()) {
            System.out.println(open.size() * 2);
        } else {
            System.out.println(Math.min(open.size(), closed.size()) * 2);
        }
    }

}
