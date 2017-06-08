package com.yflog.stream;

import com.yflog.util.Team;
import com.yflog.util.TeamSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.yflog.util.Team.Leagure.PremierLeague;

/**
 * Created by vincent on 29/05/2017.
 */
public class Slicing {
    private static void uniqueOne() {
        System.out.println("start unique one... ");
        List<Integer> integers = Arrays.asList(1,2,3,4,5,4,3,5,3);
        System.out.println("origin list: " + integers);
        System.out.println("filter even numbers ... ");
        List<Integer> results = integers.stream().filter(i -> i%2 == 0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("result list: " + results);
        System.out.println("done");

    }

    private static void skip() {
        System.out.println("start stream skip ...");
        System.out.println("filter Premiere teams in UEFA and skip first 2 ...");
        List<String> skip2 = TeamSet.teams.stream()
                .filter(t -> t.getLeagure() == PremierLeague)
                .filter(Team::isUEFATeam)
                .skip(2)
                .map(Team::getName)
                .collect(Collectors.toList());
        System.out.println("result: " + skip2);

    }

    private static void truncate() {
        System.out.println("start truncate teams ... ");
        List<String> result = TeamSet.teams.stream()
                .filter(Team::isUEFATeam)
                .skip(2)
                .limit(4)
                .map(Team::getName)
                .collect(Collectors.toList());
        System.out.println("result: " + result);
    }
    public static void main(String[] args) {
        // unique one
        uniqueOne();
        // skip
        skip();
        // truncate with skip and limit
        truncate();
    }
}
