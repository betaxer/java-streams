package com.yflog.stream.collectors;

import com.yflog.util.Team;
import com.yflog.util.TeamSet;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;


/**
 * Created by vincent on 09/06/2017.
 * Use predefined Collectors class to perform reduce and summarize
 *
 */
public class ReduceWithCollectors {

    /**
     * join strings with Collectors#joining()
     * 1. no argument
     * 2. one argument as delimiter
     * 3. three arguments: delimiter, prefix, suffix. Eg: ("hello", "world", "I")  join(",", "pre_", "_suffix") -> pre_hello,world_suffix
     */
    private static void stringJoin() {
        String uefaTeams = TeamSet.teams.stream().filter(Team::isUEFATeam).map(Team::getName).collect(Collectors.joining());
        System.out.println("UEFA teams joined without token: " + uefaTeams);

        uefaTeams = TeamSet.teams.stream().filter(Team::isUEFATeam).map(Team::getName).collect(Collectors.joining(", "));
        System.out.println("UEFA teams joined with token: " + uefaTeams);

        uefaTeams = TeamSet.teams.stream().filter(Team::isUEFATeam).map(Team::getName).collect(Collectors.joining(",", "UEFA_", "_TEAM"));
        System.out.println("UEFA teams joined with token and with prefix/suffix: " + uefaTeams);
    }

    private static void counting() {
        System.out.println("Do counting with collectors: ");
        System.out.println(TeamSet.teams.stream().filter(Team::isUEFATeam).collect(Collectors.counting()));
        System.out.println("can be more simple: ");
        System.out.println(TeamSet.teams.stream().filter(Team::isUEFATeam).count());
    }

    private static void maximum() {
        Comparator<Team> teamComparator = Comparator.comparingInt(Team::getPlayerCount);
        Optional<Team> team = TeamSet.teams.stream().collect(maxBy(teamComparator));
        team.ifPresent(t -> System.out.println(t.getName() + " has the most players"));
    }

    private static void minimum() {
        Comparator<Team> teamComparator = Comparator.comparing(Team::getPlayerCount);
        Optional<Team> team = TeamSet.teams.stream().collect(minBy(teamComparator));
        team.ifPresent(t -> System.out.println("Team " + t.getName() + " from " + t.getLeagure() + " has fewest players."));
    }

    private static void average() {
        double avg = TeamSet.teams.stream().collect(Collectors.averagingInt(Team::getPlayerCount));
        System.out.println("Average players count: " + avg);
    }

    private static void summarizing() {
        IntSummaryStatistics statistics = TeamSet.teams.stream().collect(summarizingInt(Team::getPlayerCount));
        System.out.println("statistic for team members: " + statistics);
    }

    public static void main(String[] args) {
        stringJoin();
        counting();
        maximum();
        minimum();
        average();
        summarizing();
    }
}
