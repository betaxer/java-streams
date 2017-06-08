package com.yflog.util;

import java.util.Arrays;
import java.util.List;

import static com.yflog.util.Team.Leagure.*;

/**
 * Created by vincent on 29/05/2017.
 */
public class TeamSet {
    public static final List<Team> teams = Arrays.asList(
            new Team("Chelsea", PremierLeague, true, 26),
            new Team("Tottenham", PremierLeague, true, 27),
            new Team("ManCity", PremierLeague, true, 25),
            new Team("Arsenal", PremierLeague, true, 23),
            new Team("ManUtd", PremierLeague, false, 22),
            new Team("Everton", PremierLeague, false, 21),
            new Team("Juventus", SerieA, true, 30),
            new Team("Roma", SerieA, true, 31),
            new Team("Napoli", SerieA, true, 23),
            new Team("Atalanta", SerieA, true, 25),
            new Team("Lazio", SerieA, false, 26),
            new Team("Milan", SerieA, false, 27),
            new Team("InterMilan", SerieA, false, 28),
            new Team("Bayern", Bundesliga, true, 29),
            new Team("RBLeipzig", Bundesliga, true, 30),
            new Team("Dortmund", Bundesliga, true, 26),
            new Team("Hoffenheim", Bundesliga, true, 31),
            new Team("FCKoln", Bundesliga, true, 32),
            new Team("RealMadrid", LaLiga, true, 26),
            new Team("Barcelona", LaLiga, true, 27),
            new Team("AtlMadrid", LaLiga, true, 24),
            new Team("Sevilla", LaLiga, true, 26),
            new Team("Villarreal", LaLiga, false, 32 ),
            new Team("RealSociedad", LaLiga, false, 24),
            new Team("Monaco", FranceLigueOne, true, 24),
            new Team("Paris", FranceLigueOne, true, 27),
            new Team("OGCNice", FranceLigueOne, true, 28),
            new Team("Lyon", FranceLigueOne, true, 29),
            new Team("Marseille", FranceLigueOne, false, 21),
            new Team("Bordeaux", FranceLigueOne, false, 26),
            new Team("Guanzhou Evergrande", ChineseSuperLeague, false, 32),
            new Team("Shanghai SIPG", ChineseSuperLeague, false, 32)
    );
}
