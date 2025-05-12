package org.kelompok5.utils;

import java.util.Scanner;

// TODO: Indira buat method input tipe data lain pelajari cara pakai method di App.java
public class Validator {
    private Scanner scanner = new Scanner(System.in);

    public String inputString(String placeholder, String pesanError) {
        System.out.println(placeholder);
        System.out.print("> ");
        String string = scanner.nextLine();

        while (string.isEmpty()) {
            System.out.println("ERROR: " + pesanError);
            System.out.print("> ");
            string = scanner.nextLine();
        }
        return string;
    }

    public int inputInt(String placehorder, String pesanError) {
        System.out.println(placehorder);
        System.out.println("> ");
        int integer = scanner.nextInt();

        while (integer == 0) {
            System.out.println("Error: " + pesanError);
            System.out.println("> ");
            integer = scanner.nextInt();

        }
        return integer;
    }
}