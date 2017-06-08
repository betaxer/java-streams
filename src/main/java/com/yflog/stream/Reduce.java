package com.yflog.stream;

import com.yflog.util.Trader;
import com.yflog.util.Transaction;
import com.yflog.util.TransactionCollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vincent on 02/06/2017.
 */
public class Reduce {

    private static void sum_lamba() {
        List<Integer> numbs = Arrays.asList(1, 3, 4, 23, 2, 4, 54);
        numbs.stream().reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }

    private static void sum() {
        List<Integer> numbs = Arrays.asList(1, 3, 4, 23, 2, 4, 54);
        Optional<Integer> sum = numbs.stream().reduce(Integer::sum);
        if (sum.isPresent()) {
            System.out.println("Sum of " + numbs + " is " + sum.get());
        }
        else {
            System.out.println("Sum not present");
        }
    }

    private static void min() {
        List<Integer> numbs = Arrays.asList(1, 3, 4, 23, 2, 4, 54);
        Optional<Integer> min = numbs.stream().reduce((a,b) -> a > b ? b : a);
        min.ifPresent(integer -> System.out.println("min of " + numbs + " is " + integer));


        int result = numbs.stream().reduce(0, Integer::min);
        System.out.println("Min of 0 and " + numbs + " is " + result);
    }

    // 1. Find all transactions in year 2011 and sort them by the value (small to high)
    private static void filterAndSort() {
        List<Transaction> transactions = TransactionCollection.getTransactionList().stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)/*.reversed()*/)
                .collect(Collectors.toList());

        transactions.stream().map(Transaction::toString).forEach(System.out::println);
    }
    // 2. What are all the unique cities where the traders work
    private static void findAllCities() {
        TransactionCollection.getTransactionList().stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
    }

    // 3. Find all traders from Cambridge and sort them by name
    private static void findTraders() {
        TransactionCollection.getTransactionList().stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    // 4. Return a string of all traders' names sorted alphabetically
    private static void mapTraderName() {
        TransactionCollection.getTransactionList().stream().map(t -> t.getTrader().getName())
                .distinct().sorted().reduce((t1, t2) -> t1 + ";" +  t2)
                .ifPresent(System.out::println);
    }
    // 5. Are any traders based in Milan
    private static void anyTraderInMilan() {
        boolean anyOne = TransactionCollection.getTransactionList().stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Any trader in Milan? " + (anyOne ? "yes" : "no") );
    }
    // 6. Print all transactions's values from the traders living in Cambridge
    private static void print() {
        TransactionCollection.getTransactionList().stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }
    // 7. What's the highest value of all the transactions
    private static void maxTransaction() {
        TransactionCollection.getTransactionList().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);

    }

    public static void main(String[] args) {
        sum_lamba();
        sum();
        min();

        filterAndSort();
        findAllCities();
        findTraders();
        mapTraderName();
        anyTraderInMilan();
        print();
        maxTransaction();
    }
}
