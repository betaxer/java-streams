package com.yflog.stream;

import com.yflog.util.Transaction;
import com.yflog.util.TransactionCollection;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by vincent on 06/06/2017.
 * Use IntStream to introduce the usage of primitive streams provided by jdk8 stream.
 * 1. min
 * 2. max
 * 3. sum
 * 4. ranges
 * 5. use IntStream to generate Pythagorean triples
 */
public class PrimitiveStream {

    private static void notIntStream() {
        System.out.print("Sum with non-int stream: ");
        long start = System.nanoTime();
        TransactionCollection.getTransactionList().stream()
                .map(Transaction::getValue) //return Stream<Integer>
                .reduce(Integer::sum)       // sum takes int as parameter, so there is a box cost
                .ifPresent(System.out::println);
        System.out.println("cost: " + (System.nanoTime() - start));
    }

    private static void withIntStream() {
        System.out.print("Sum with int stream: ");
        long start = System.nanoTime();
        int sum = TransactionCollection.getTransactionList().stream()
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(sum);
        System.out.println("Cost: " + (System.nanoTime() - start));
    }

    private static void funcsOfIntStream() {
        System.out.print("Find max with IntStream: ");
        System.out.println(
                TransactionCollection.getTransactionList().stream()
                .mapToInt(Transaction::getValue)
                .max().orElse(-1)
        );
        System.out.print("Find min with IntStream: ");
        System.out.println(
                TransactionCollection.getTransactionList().stream()
                .mapToInt(Transaction::getValue)
                .min().orElse(0)
        );

        System.out.print("Find avg with IntStream: ");
        System.out.println(
                TransactionCollection.getTransactionList().stream()
                .mapToInt(Transaction::getValue)
                .average().orElse(-1)
        );
    }

    private static void ranges() {
        System.out.print("[1,5) -> range(1,5):   ");
        IntStream.range(1,5).boxed().map(s -> " " + s).forEach(System.out::print);  //
        System.out.println();
        System.out.print("[1,5] -> rangeClosed(1,5): ");
        IntStream.rangeClosed(1,5)
                .boxed()
                .map(s -> " " + s)
                .forEach(System.out::print); //
        System.out.println();
    }

    /**
     * (a, b, c) should satisfy c*c = a*a + b*b
     */
    private static void pythagoreanTriple() {
        // solution a
        System.out.println("Calculate the first 5 pythagorean triples A: ");
        IntStream.range(1,100).boxed().flatMap(
                a -> IntStream.range(a, 100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b , (int) Math.sqrt(a*a + b* b)}))
                .limit(5)
                .map(Arrays::toString)
                .forEach(System.out::println);
        // solution b
        System.out.println("Calculate the first 5 pythagorean triples B: ");
        IntStream.range(1, 100)
                .boxed()
                .flatMap(a -> IntStream.range(a, 100)
                        .boxed()
                        .map( b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
                )
                .filter(arr -> arr[2] % 1 == 0 )
                .map(Arrays::toString)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Transactions: " + TransactionCollection.getTransactionList().size());
        notIntStream();
        withIntStream();
        funcsOfIntStream();
        ranges();
        pythagoreanTriple();
    }
}
