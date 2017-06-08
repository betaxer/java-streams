package com.yflog.stream;

import com.yflog.util.Team;
import com.yflog.util.TeamSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vincent on 29/05/2017.
 */
public class Mapping {

    private static void simpleMapping() {
        System.out.println("Start simple map Team -> team name ... ");
        List<String> result = TeamSet.teams.stream().filter(t -> t.getLeagure() == Team.Leagure.ChineseSuperLeague)
                .map(Team::getName).collect(Collectors.toList());
        System.out.println("result: " + result);
    }

    private static void flattening() {
        System.out.println("Start maping [\"hello\", \"word\"] to char sequences");
        List<String> result = Stream.of("Hello", "world")
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Result: " + result);
    }

    private static void flattening2() {
        System.out.println("Start flattening mapping numbers to number pairs");
        List<String> pairs = Stream.of(1, 2, 3)
                .flatMap(num -> Stream.of(3, 4).map(
                        j -> "(" + num +", " + j + ")")
                )
                .collect(Collectors.toList());
        System.out.println("Result: " + pairs);

    }

    /**
     * (1,2,3), (3,4) to pairs whose sum is divided by 3
     */
    private static void flattening3() {
        System.out.println("Start flattening mapping to pairs whose sum is divided by 3");
        List<String> pairs = Stream.of(1, 2, 3)
                .flatMap(i ->
                        Stream.of(3, 4).filter(j -> ((i+j) % 3 == 0))
                        .map(j -> ("(" + i + ","  + j + ")"))
                )
                .collect(Collectors.toList());
        System.out.println("Result: " + pairs);
    }
    public static void main(String[] args) {
        // map Team -> name
        simpleMapping();
        // flattening
        flattening();
        // flattening 2
        flattening2();
        // flattening 3
        flattening3();
    }
}
