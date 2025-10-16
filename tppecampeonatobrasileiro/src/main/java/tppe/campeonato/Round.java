package tppe.campeonato;

import java.util.Comparator;
import java.util.ArrayList;

public class Round {
    private ArrayList<Match> matches;
    private int roundNumber;
  

    public Round(int roundNumber){
        this.roundNumber = roundNumber;
        this.matches = new ArrayList<Match>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<>();

        for (Match match : getMatches()) {
            teams.add(match.getHomeTeam());
            teams.add(match.getAwayTeam());
        }

        return teams;
    }

    public Match getMatch(Team t1, Team t2) {
        for (Match match : getMatches()) {
            if (match.getHomeTeam().equals(t1) && match.getAwayTeam().equals(t2)) {
                return match;
            }
        }

        return null;
        
    }

    public ArrayList<Team> processRoundResult(ArrayList<Team> teams) {
        // ArrayList<Team> teams = getTeams();
        teams.sort((t1, t2) -> {
            int pointsCompare = Integer.compare(t2.getPoints(), t1.getPoints());
            if (pointsCompare != 0) return pointsCompare;

            int winsCompare = Integer.compare(t2.getWins(), t1.getWins());
            if (winsCompare != 0) return winsCompare;

            int goalsDifference = Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
            if (goalsDifference != 0) return goalsDifference;
            // confronto direto

            // int goalsScored = Integer.compare(t2.getGoalsScored(), t1.getGoalsScored());
            // if (goalsScored != 0) return goalsDifference;

            // Match m = getMatch(t1, t2);
            
            // return Integer.compare(m.getAwayGoals(), m.getHomeGoals());

            return Integer.compare(t2.getGoalsScored(), t1.getGoalsScored());
        });

        return teams;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rodada ").append(roundNumber).append(":\n");
        for (Match match : matches) {
            sb.append(" - ").append(match.toString()).append("\n");
        }

        return sb.toString();
        
    }

    

}
