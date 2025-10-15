package tppe.campeonato;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Competition {

    private ArrayList<Team> teams;
    private ArrayList<Match> allMatches;
    private int numRounds;
    private ArrayList<Round> rounds;

    public Competition(ArrayList<Team> teams) {
      this.teams = teams;
      this.allMatches = new ArrayList<>();
      this.numRounds = (teams.size() - 1) * 2;
    }

    public Round getRound(int roundNumber) {
        return rounds.get(roundNumber);
    }

    public ArrayList<Match> createAllMatches(){
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size(); j++) {
                if (i != j) {
                    allMatches.add(new Match(teams.get(i), teams.get(j)));
                }
            }
        }

      return allMatches;

    }
    
    public ArrayList<Round> scheduleRounds(){

        ArrayList<Round> rounds = new ArrayList<>(numRounds);
        for (int i = 0; i < numRounds; i++) {
            rounds.add(new Round(i));
        }

        ArrayList<Match> remainingMatches = new ArrayList<>(allMatches);

        for (Round round : rounds) {
            Set<Team> usedTeams = new HashSet<>();
            
            Iterator<Match> it = remainingMatches.iterator();

            while (it.hasNext()) {
                Match match = it.next();
                Team home = match.getHomeTeam();
                Team away = match.getAwayTeam();

                if (!usedTeams.contains(home) && !usedTeams.contains(away)) {
                    round.addMatch(match);
                    usedTeams.add(home);
                    usedTeams.add(away);
                    it.remove(); 
                }
            }
        }

        this.rounds = rounds;

        return rounds;
    }

}
