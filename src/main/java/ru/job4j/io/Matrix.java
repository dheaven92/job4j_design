package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            int size = 9;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String cell = (i + 1) * (j + 1) + "\t";
                    out.write(cell.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
