package com.yflog.util;

/**
 * Created by vincent on 29/05/2017.
 */
public class Team {
    private final String name;
    private final Leagure leagure;
    private final boolean isUEFATeam;
    private final int playerCount;


    public Team(String name, Leagure leagure, boolean isUEFATeam, int playerCount) {
        this.name = name;
        this.leagure = leagure;
        this.isUEFATeam = isUEFATeam;
        this.playerCount = playerCount;
    }

    public String getName() {
        return name;
    }

    public Leagure getLeagure() {
        return leagure;
    }

    public boolean isUEFATeam() {
        return isUEFATeam;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public enum Leagure {
        PremierLeague,
        Bundesliga,
        LaLiga,
        SerieA,
        FranceLigueOne,
        ChineseSuperLeague
    }
}
