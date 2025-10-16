package tppe.campeonato;

public class Team {
  private String teamName;
  private int wins;
  private int draws;
  private int losses;
  private int goalsScored;
  private int goalsConceded;
  private int yellowCards;
  private int redCards;
  private int points;

  public Team(String teamName){
    this.teamName = teamName;
    this.wins = 0;
    this.draws = 0;
    this.losses = 0;
    this.goalsScored = 0;
    this.goalsConceded = 0;
    this.yellowCards = 0;
    this.redCards = 0;
    this.points = 0;
  }

  public int getPoints() {
    this.points = (this.wins * 3) + this.draws;
    return points;
  }
  
  public void setWins(int wins) {this.wins += wins;}

  public int getWins() {return wins;}

  public void setDraws(int draws) {this.draws += draws;}

  public int getDraws() {return draws;}

  public void setLosses(int losses) {this.losses += losses;}

  public int getLosses() {return losses;}

  public int getGoldDifference() {return goalsScored - goalsConceded;}

  public void registerResults(int matchGoalsScored, int matchGoalsConceded){
    this.goalsScored += matchGoalsScored;
    this.goalsConceded += matchGoalsConceded;
    
    if(matchGoalsScored > matchGoalsConceded){
      this.wins++;
    }else if(matchGoalsScored < matchGoalsConceded){
      this.losses++;
    }else{
      this.draws++;
    }
  }

  @Override
  public String toString() {return teamName;}

}
