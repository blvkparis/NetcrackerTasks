package ru.ncedu.popkov.nio2;

import java.io.*;
import java.nio.file.Paths;
import java.util.Locale;

/**
 * JavaDocReader Class
 *
 * @author Anton Popkov
 */
public class JavaDocReader {

    /**
     * Method that reads the file until it has third <b>java</b> word
     * @param pathString path to the file to read
     * @return all lines until third <b>java</b> word
     */
    public static String read(String pathString) {
        String path = Paths.get("").toAbsolutePath() + pathString;

        int javaCount = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader(path));

            String line = reader.readLine();
            while (line != null && javaCount != 3) {
                sb.append(line);
                if (line.toLowerCase(Locale.ROOT).contains("java")) {
                    javaCount++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException exception) {
            exception.getMessage();
        }

        return sb.toString();
    }

    /**
     * Method that count symbol in file
     *
     * @param symbol target symbol
     * @param pathString path to the file to read
     * @return all counts
     */
    public static int countSymbol(char symbol, String pathString) {
        String path = Paths.get("").toAbsolutePath() + pathString;

        int chr, count = 0;
        try {
            Reader reader = new FileReader(path);
            while ((chr = reader.read()) != -1) {
                if ((char) chr == symbol) {
                    count++;
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return count;
    }
}