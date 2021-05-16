package ru.ncedu.popkov.nio2;

import java.io.IOException;

/**
 * Main class
 * Entry point
 *
 * @author Anton Popkov
 */
public class MainNIO {
    public static void main(String[] args) throws IOException {
        JavaCode javaCode = new JavaCode("JavaCode");

        System.out.println("CurrentPath: " + javaCode.getCurrentPath());
        System.out.println();

        System.out.println("File Name: " + javaCode.getFileName());
        System.out.println();

        javaCode.printCode();

        System.out.println(JavaDocReader.read("\\src\\JDoc.txt"));
        char sym = 'e';
        System.out.println(
                "Symbol " + sym + " occurs " +
                JavaDocReader.countSymbol(sym, "\\src\\TestCounter.txt")
                + " times!");
    }
}