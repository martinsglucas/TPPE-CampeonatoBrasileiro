package tppe.campeonato;

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
