package tppe.campeonato;

import java.util.ArrayList;

public class Competition {

    private ArrayList<Team> teams;
    private ArrayList<Match> allMatches;
    private int numRounds;
    private ArrayList<Round> rounds;

    public Competition(ArrayList<Team> teams) {
        this.teams = teams;
        this.numRounds = (teams.size() - 1) * 2;
        this.allMatches = createAllMatches();
        this.rounds = scheduleRounds();
    }

    public Round getRound(int roundNumber) {
        return rounds.get(roundNumber);
    }

    public ArrayList<Match> createAllMatches() {

        ArrayList<Match> matches = new ArrayList<>();

        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size(); j++) {
                if (i != j) {
                    matches.add(new Match(teams.get(i), teams.get(j)));
                }
            }
        }

        return matches;

    }

    public ArrayList<Round> scheduleRounds() {

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

        ArrayList<Team> rotation = new ArrayList<>(teams);

        for (int r = 0; r < roundsPerLeg; r++) {
            Round round = rounds.get(r);

            for (int i = 0; i < n / 2; i++) {
                Team t1 = rotation.get(i);
                Team t2 = rotation.get(n - 1 - i);

                Team home = (r % 2 == 0) ? t1 : t2;
                Team away = (r % 2 == 0) ? t2 : t1;

                Match match = getMatch(home, away);
                if (match == null) {
                    throw new IllegalStateException(
                            "Partida não encontrada: " + home.getName() + " x " + away.getName());
                }

                round.addMatch(match);
                remainingMatches.remove(match);
            }

            if (n > 2) {
                Team last = rotation.remove(rotation.size() - 1);
                rotation.add(1, last);
            }
        }

        rotation = new ArrayList<>(teams);

        for (int r = 0; r < roundsPerLeg; r++) {
            Round round = rounds.get(roundsPerLeg + r);

            for (int i = 0; i < n / 2; i++) {
                Team t1 = rotation.get(i);
                Team t2 = rotation.get(n - 1 - i);

                Team home = (r % 2 == 0) ? t2 : t1;
                Team away = (r % 2 == 0) ? t1 : t2;

                Match match = getMatch(home, away);
                if (match == null) {
                    throw new IllegalStateException(
                            "Partida não encontrada: " + home.getName() + " x " + away.getName());
                }

                round.addMatch(match);
                remainingMatches.remove(match);
            }

            if (n > 2) {
                Team last = rotation.remove(rotation.size() - 1);
                rotation.add(1, last);
            }
        }

        if (!remainingMatches.isEmpty()) {
            throw new IllegalStateException("Partidas restantes não alocadas: " + remainingMatches.size());
        }

        this.rounds = rounds;
        return rounds;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public Match getMatch(String t1Name, String t2Name) {
        for (Match match : allMatches) {
            if (match.getHomeTeam().getName().equals(t1Name) && match.getAwayTeam().getName().equals(t2Name)) {
                return match;
            }
        }

        return null;

    }

    public Match getMatch(Team t1, Team t2) {
        for (Match match : allMatches) {
            if (match.getHomeTeam().equals(t1) && match.getAwayTeam().equals(t2)) {
                return match;
            }
        }

        return null;

    }

    private int compareTeams(Team t1, Team t2) {
        // Primeiro ordena por pontos
        int c = Integer.compare(t2.getPoints(), t1.getPoints());
        if (c != 0)
            return c;

        // Segundo, ordena por voitórias
        c = Integer.compare(t2.getWins(), t1.getWins());
        if (c != 0)
            return c;

        // Terceiro, ordena por saldo de gols
        c = Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
        if (c != 0)
            return c;

        // Quarto, ordena por gols marcados
        c = Integer.compare(t2.getGoalsScored(), t1.getGoalsScored());
        if (c != 0)
            return c;

        // Quinto, ordena por confronto direto entre dois times
        int h2h = compareHeadToHead(t1, t2);
        if (h2h != 0)
            return h2h;

        // Sexto, ordena por menos cartões vermelhos
        c = Integer.compare(t1.getRedCards(), t2.getRedCards());
        if (c != 0)
            return c;

        // Sétimo, ordena por menos cartões amarelos
        c = Integer.compare(t1.getYellowCards(), t2.getYellowCards());
        if (c != 0)
            return c;

        // Finalmente, ordena por sorteio (nome do time)
        return t1.getName().compareTo(t2.getName());
    }

    public ArrayList<Team> getClassification() {
        teams.sort(this::compareTeams);

        return teams;
    }

    private int compareHeadToHead(Team t1, Team t2) {
        Match p1 = getMatch(t1, t2);
        Match p2 = getMatch(t2, t1);

        int t1Goals = 0;
        int t2Goals = 0;

        if (p1 != null) {
            t1Goals += p1.getHomeGoals();
            t2Goals += p1.getAwayGoals();
        }
        if (p2 != null) {
            t1Goals += p2.getAwayGoals();
            t2Goals += p2.getHomeGoals();
        }

        return Integer.compare(t2Goals, t1Goals);
    }

    public ArrayList<Team> getLibertadores() {
        return new ArrayList<>(getClassification().subList(0, 6));
    }

    public ArrayList<Team> getSulAmericana() {
        return new ArrayList<>(getClassification().subList(6, 12));
    }

    public ArrayList<Team> getRebaixados() {
        return new ArrayList<>(getClassification().subList(16, 20));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Team team : teams) {
            sb.append(team);
        }
        return sb.toString();

    }

}
