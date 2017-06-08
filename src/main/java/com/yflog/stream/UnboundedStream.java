package com.yflog.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by vincent on 08/06/2017.
 */
public class UnboundedStream {

    private static void generateUnboundedStream() {
        System.out.println("Generate random numbers");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void iterateUnboundedStream() {
        System.out.println("Generate unbounded stream with Stream.iterate: ");
        Stream.iterate(0, a -> a+2)
                .limit(5)
                .forEach(System.out::println);
    }

    /**
     * Generate infinite stream with iterate.
     * And use the iterate to calculate the fibonacci sequences
     */
    private static void fibonacciWithIterate() {
        System.out.println("Calc fibonacci with Stream.iterate: ");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(5)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void fibonacciWithGenerate() {
        System.out.println("Calc fibonacci with Stream.generate: ");
        Stream.generate(new FibonacciSupplier())
                .limit(5)
                .forEach(System.out::println);
    }

    private static class FibonacciSupplier implements Supplier<Integer> {

        private int _lastOne = -1;
        private int _current = 0;

        @Override
        public Integer get() {

            if (_lastOne == -1) {
                _lastOne = _current = 0;
                return 0;
            }
            else if (_current == 0) {
                _lastOne = _current;
                _current = 1;
                return 1;
            }
            else {
                int next = _current + _lastOne;
                _lastOne = _current;
                _current = next;
                return next;
            }
        }
    }

    public static void main(String[] args) {
        iterateUnboundedStream();
        generateUnboundedStream();
        fibonacciWithIterate();
        fibonacciWithGenerate();
    }
}
