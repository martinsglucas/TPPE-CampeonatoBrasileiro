package tppe.campeonato;

import java.util.ArrayList;

public class RoundScheduler {

    private final ArrayList<Team> teams;
    private final ArrayList<Match> allMatches;
    private final int numRounds;

    public RoundScheduler(ArrayList<Team> teams, ArrayList<Match> allMatches, int numRounds) {
        this.teams = teams;
        this.allMatches = allMatches;
        this.numRounds = numRounds;
    }

    public ArrayList<Round> schedule() {
        int n = teams.size();
        if (n % 2 != 0) {
            throw new IllegalStateException("Número de times deve ser par para o método do círculo");
        }

        ArrayList<Round> rounds = new ArrayList<>(numRounds);
        for (int i = 0; i < numRounds; i++) {
            rounds.add(new Round(i));
        }

        ArrayList<Match> remainingMatches = new ArrayList<>(allMatches);

        int roundsPerLeg = n - 1;

        scheduleLeg(rounds, remainingMatches, roundsPerLeg, true);
        scheduleLeg(rounds, remainingMatches, roundsPerLeg, false);

        if (!remainingMatches.isEmpty()) {
            throw new IllegalStateException(
                    "Partidas restantes não alocadas: " + remainingMatches.size());
        }

        return rounds;
    }

    private void scheduleLeg(ArrayList<Round> rounds,
                             ArrayList<Match> remainingMatches,
                             int roundsPerLeg,
                             boolean firstLeg) {

        int n = teams.size();
        ArrayList<Team> rotation = new ArrayList<>(teams);

        for (int r = 0; r < roundsPerLeg; r++) {
            Round round = rounds.get(firstLeg ? r : (r + roundsPerLeg));

            for (int i = 0; i < n / 2; i++) {
                Team t1 = rotation.get(i);
                Team t2 = rotation.get(n - 1 - i);

                Team home;
                Team away;

                if (firstLeg) {
                    home = (r % 2 == 0) ? t1 : t2;
                    away = (r % 2 == 0) ? t2 : t1;
                } else {
                    home = (r % 2 == 0) ? t2 : t1;
                    away = (r % 2 == 0) ? t1 : t2;
                }

                Match match = getMatch(home, away);
                if (match == null) {
                    throw new IllegalStateException(
                            "Partida não encontrada: " + home.getName() + " x " + away.getName());
                }

                round.addMatch(match);
                remainingMatches.remove(match);
            }

            rotate(rotation);
        }
    }

    private Match getMatch(Team home, Team away) {
        for (Match match : allMatches) {
            if (match.getHomeTeam().equals(home) &&
                match.getAwayTeam().equals(away)) {
                return match;
            }
        }
        return null;
    }

    private void rotate(ArrayList<Team> rotation) {
        int n = rotation.size();
        if (n > 2) {
            Team last = rotation.remove(n - 1);
            rotation.add(1, last);
        }
    }
}
