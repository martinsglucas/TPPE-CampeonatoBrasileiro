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
            Match m = getMatch(t1, t2);
            return Integer.compare(m.getAwayGoals(), m.getHomeGoals());
        });
        

        return teams;
    }
    
}
