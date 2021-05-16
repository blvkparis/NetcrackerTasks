package ru.ncedu.popkov.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anton Popkov
 */
public class JavaCode {
    private final Path currentPath = Paths.get("").toAbsolutePath();
    private Path filePath;
    private String fileName;

    /**
     * Constructor
     *
     * @param name name of a file to read
     */
    public JavaCode(String name) {
        setFileNameAndPath(name);
    }

    public Path getCurrentPath() {
        return currentPath;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * Method that set fileName and path of a file
     *
     * @param name name of a file to read
     */
    public void setFileNameAndPath(String name) {
        Path filePath = currentPath.resolve("src/ru/ncedu/popkov/nio2/" + name + ".java");

        this.filePath = filePath;
        this.fileName = filePath.getFileName().toString();
    }

    /**
     * Method that print code from the .java file
     *
     * @throws IOException
     */
    public void printCode() throws IOException {
        Stream<String> lines = Files.lines(filePath);
        String data = lines.collect(Collectors.joining("\n"));

        System.out.println(data);
    }
}