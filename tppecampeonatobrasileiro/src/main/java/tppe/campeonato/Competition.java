package tppe.campeonato;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Competition {

    private ArrayList<Team> teams;
    private ArrayList<Match> allMatches;

    public Competition(ArrayList<Team> teams) {
      this.teams = teams;
      this.allMatches = new ArrayList<>();
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
    
    public static Round[] scheduleMatches(ArrayList<Match> allMatches, int totalRounds){

        Round[] rounds = new Round[totalRounds];
        for (int i = 0; i < totalRounds; i++) {
            rounds[i] = new Round();
        }

        ArrayList<Match> remainingMatches = new ArrayList<>(allMatches);

        for (int i = 0; i < totalRounds; i++) {
            Round round = rounds[i];
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
        return rounds;
    }
    
}
