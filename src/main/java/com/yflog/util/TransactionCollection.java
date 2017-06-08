package com.yflog.util;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vincent on 04/06/2017.
 */
public class TransactionCollection {
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    private static final List<Transaction> transactionList = Collections.unmodifiableList(Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    ));

    public static List<Transaction> getTransactionList() {
        return transactionList;
    }
}
