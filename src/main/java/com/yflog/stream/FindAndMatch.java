package com.yflog.stream;

import com.yflog.util.Team;
import com.yflog.util.TeamSet;

/**
 * Created by vincent on 02/06/2017.
 */
public class FindAndMatch {

    private static void anyMatch() {
        if (TeamSet.teams.stream().anyMatch(t -> t.getLeagure() == Team.Leagure.Bundesliga)) {
            System.out.println("There is at least one club from Bundesliga");
        }
        else {
            System.out.println("There is not such club from Budesliga");
        }
    }

    private static void allMatch() {
        if (TeamSet.teams.stream().allMatch(t -> t.getPlayerCount() > 20)) {
            System.out.println("All teams have more than 20 players");
        }
        else {
            System.out.println("Not all teams have more than 20 players");
        }
    }

    private static void noneMatch() {
        if (TeamSet.teams.stream().noneMatch(t -> "Jiangsu suning".equals(t.getName()))) {
            System.out.println("There is no club whose name is 'Jiangsu suning'");
        }
        else {
            System.out.println("There is a club whose name is 'Jiangsu suning'");
        }
    }

    private static void findAny() {
        TeamSet.teams.stream()
                .filter(t -> t.getLeagure() == Team.Leagure.Bundesliga)
                .findAny() // returns Optional<T>
                .ifPresent(t -> System.out.println("Find one " + t.getName()));
    }

    private static void findFirst() {
        TeamSet.teams.stream()
                .filter(t -> t.getPlayerCount() > 20)
                .filter(Team::isUEFATeam)
                .map(Team::getName)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        anyMatch();
        allMatch();
        noneMatch();
        findAny();
        findFirst();
    }
}
