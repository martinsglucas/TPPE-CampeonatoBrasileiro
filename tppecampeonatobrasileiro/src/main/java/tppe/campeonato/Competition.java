package tppe.campeonato;

import java.util.ArrayList;
 

public class Competition {

    private ArrayList<Team> teams;
    public ArrayList<Match> allMatches;
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

    public ArrayList<Match> createAllMatches(){

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
    RoundScheduler scheduler =
            new RoundScheduler(teams, allMatches, numRounds);

    this.rounds = scheduler.schedule();
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

    public ArrayList<Team> getClassification() {
        for (Round round : rounds) {
            teams = round.processRoundResult(teams);
        }

        teams.sort((t1, t2) -> {
            // Primeiro ordena por pontos
            int c = Integer.compare(t2.getPoints(), t1.getPoints());
            if (c != 0) return c;

            // Segundo, ordena por voitórias
            c = Integer.compare(t2.getWins(), t1.getWins());
            if (c != 0) return c;

            // Terceiro, ordena por saldo de gols
            c = Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
            if (c != 0) return c;

            // Quarto, ordena por gols marcados
            c = Integer.compare(t2.getGoalsScored(), t1.getGoalsScored());
            if (c != 0) return c;

            // Quinto, ordena por confronto direto entre dois times
            int h2h = compareHeadToHead(t1, t2);
            if (h2h != 0) return h2h;

            // Sexto, ordena por menos cartões vermelhos
            c = Integer.compare(t1.getRedCards(), t2.getRedCards());
            if (c != 0) return c;

            // Sétimo, ordena por menos cartões amarelos
            c = Integer.compare(t1.getYellowCards(), t2.getYellowCards());
            if (c != 0) return c;

            // Finalmente, ordena por sorteio (nome do time)
            return t1.getName().compareTo(t2.getName());
        });
        
        return teams;
    }

    private int compareHeadToHead(Team t1, Team t2) {
        Match p1 = getMatch(t1, t2);
        Match p2 = getMatch(t2, t1);

        int t1Goals = 0;
        int t2Goals = 0;

        if (p1 != null){
            t1Goals += p1.getHomeGoals();
            t2Goals += p1.getAwayGoals();
        }
        if (p2 != null){
            t1Goals += p2.getAwayGoals();
            t2Goals += p2.getHomeGoals();
        }

        return Integer.compare(t2Goals, t1Goals);
    }
 
    public ArrayList<Team> getLibertadores(){
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
        for (Team team: teams) {
            sb.append(team);
        }
        return sb.toString();

    }

}

