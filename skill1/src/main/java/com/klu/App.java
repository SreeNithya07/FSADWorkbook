package com.klu;

import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        String notes = Files.readString(Path.of("notes.txt"));
        System.out.println(notes);
    }
}
