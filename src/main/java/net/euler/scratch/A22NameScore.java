package net.euler.scratch;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class A22NameScore {

    private List<Character> alphabets = Arrays.asList(' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    public static void main(String... args) throws IOException {
        A22NameScore impl = new A22NameScore();
        impl.run();
    }

    void run() throws IOException {
        ClassPathResource resource = new ClassPathResource("p022_names.txt");
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = null;
            do {
                line = br.readLine();
                sb.append(line);
            } while (Objects.nonNull(line));
        } finally {
            if (Objects.nonNull(br)) {
                br.close();
            }
        }

        System.out.println(sb);

        String[] split = sb.toString().replace("\"", "").split(",");
        List<String> names = Arrays.asList(split);
        Collections.sort(names);

        for (String s : names) {
            int sum = 0;
            for (Character c : s.toCharArray()) {
                sum += alphabets.indexOf(c);
            }
            Arrays.stream(new char[][]{s.toCharArray()}).forEach(c -> {
                alphabets.indexOf(c);
            });
            System.out.println(s + "\t" + names.indexOf(s) + "\t" + (sum * (names.indexOf(s) + 1)));
        }
    }
}
