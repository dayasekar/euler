package net.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SaddleValueInAMatrix {

    public static void main(String... args) throws IOException {
        SaddleValueInAMatrix impl = new SaddleValueInAMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        impl.run(matrix);
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {10, 18, 4}};
        impl.run(matrix2);
        int[][] matrix3 = {{1, 2, 3, 9}, {4, 5, 6, 55}, {110, 118, 114, 66}, {-1, -2, -3, 5}};
        impl.run(matrix3);

        impl.readMatrix();
    }

    void run(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isMinInRow(matrix, i, j) && isMaxInColumn(matrix, i, j)) {
                    System.out.println(matrix[i][j] + "\t" + isMinInRow(matrix, i, j) + "\t" + isMaxInColumn(matrix, i, j));
                    return;
                }
            }
        }
        System.out.println("Invalid Input");
    }

    boolean isMinInRow(int[][] matrix, int i, int j) {
        int current = matrix[i][j];
        for (int col = 0; col < matrix.length; col++) {
            if (current > matrix[i][col]) {
                return false;
            }
        }
        return true;
    }

    boolean isMaxInColumn(int[][] matrix, int i, int j) {
        int current = matrix[i][j];
        for (int row = 0; row < matrix.length; row++) {
            if (current < matrix[row][j]) {
                return false;
            }
        }
        return true;
    }

    int[][] readMatrix() throws IOException {
        int[][] matrix = null;
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line = in.readLine();

        if (line != null) {
            int size = Integer.parseInt(line);
            int row = 0;
            matrix = new int[size][size];
            while (row < Integer.parseInt(line)) {
                int column = 0;
                String rowLine = in.readLine();
                String[] elements = rowLine.split(",");
                for (String element : elements) {
                    matrix[row][column] = Integer.parseInt(element);
                    column++;
                }
                row++;
            }
        }

        return matrix;
    }
}
