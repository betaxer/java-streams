package com.yflog.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

/**
 * Created by vincent on 07/06/2017.
 * Use jdk8 stream to find unique words
 */
public class FileStreams {
    private static void uniqueWords() throws IOException {
        String test = "This is a test file without punctuations\n" +
                "and is used to test file stream\n" +
                "and count distinct words";

        File newFile = new File("out.txt");
        newFile.createNewFile();
        newFile.deleteOnExit();
        Path path = Files.write(Paths.get("out.txt"), test.getBytes(), StandardOpenOption.WRITE);
        Files.lines(path)
                .flatMap(l -> Arrays.stream(l.split(" ")))
                .filter(w -> !w.isEmpty())
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        uniqueWords();
    }
}
