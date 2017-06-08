package com.yflog.stream;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vincent on 07/06/2017.
 */
public class StreamBuilder {

    private static void fromValues() {
        System.out.println("Stream from values:");
        Stream<String> strStream = Stream.of("Java 8", "Lambdas", "In", "Action");
        strStream.map(String::toUpperCase).forEach(System.out::println);
    }

    private static void emptyStream() {
        System.out.println("Empty stream by Stream.empty()");
        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream.count());
    }

    private static void fromArrays() {
        int [] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Stream from array by Arrays.stream(arr), and find max:");
        IntStream intStream = Arrays.stream(arr);
        intStream.max().ifPresent(System.out::println);

    }

    public static void main(String[] args) {
        fromValues();
        emptyStream();
        fromArrays();
    }
}
