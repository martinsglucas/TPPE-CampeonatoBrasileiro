package tppe.campeonato;

import java.util.ArrayList;

public class Round {
    private ArrayList<Match> matches;
  

    public Round(){
      this.matches = new ArrayList<Match>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    

}
