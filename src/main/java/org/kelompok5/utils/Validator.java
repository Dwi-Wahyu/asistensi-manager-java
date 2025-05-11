package org.kelompok5.utils;

import java.util.Scanner;

// TODO: Indira buat method input tipe data lain pelajari cara pakai method di App.java
public class Validator {
    private Scanner scanner = new Scanner(System.in);

    public String inputString(String placeholder, String pesanError) {
        System.out.println(placeholder);
        System.out.print("> ");
        String variable = scanner.nextLine();

        while (variable.isEmpty()) {
            System.out.println("ERROR: " + pesanError);
            System.out.print("> ");
            variable = scanner.nextLine();
        }

        return variable;
    }
}