package com.yflog.stream;

import com.yflog.util.Team;
import com.yflog.util.TeamSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by vincent on 08/06/2017.
 * Grouping
 */
public class Grouping {

    private static void nonStreamGrouping() {
        System.out.println("Do grouping in non stream way ... ..");
        System.out.println("Grouping teams by leagure");
        Map<Team.Leagure, List<Team>> teamsByLeague = new HashMap<>();
        for (Team team : TeamSet.teams) {
            if (!teamsByLeague.containsKey(team.getLeagure())) {
                teamsByLeague.put(team.getLeagure(), new ArrayList<Team>());
            }

            teamsByLeague.get(team.getLeagure()).add(team);
        }

        for (Team.Leagure leagure : teamsByLeague.keySet()) {
            System.out.println("Teams in " + leagure);
            for (Team team : teamsByLeague.get(leagure)) {
                System.out.println("    " + team.getName());
            }
        }
    }

    private static void streamGrouping() {
        System.out.println("Do grouping in stream way .... ");
        System.out.println("Grouping teams by leagures");
        Map<Team.Leagure, List<Team>> teamsByStream = TeamSet.teams.stream().collect(Collectors.groupingBy(Team::getLeagure));
        teamsByStream.entrySet().forEach(
                ts -> {
                    System.out.println("Teams in " + ts.getKey());
                    ts.getValue().stream().map(t -> "    " + t.getName()).forEach(System.out::println);
                }
        );
    }

    public static void main(String[] args) {
        nonStreamGrouping();
        streamGrouping();
    }
}

