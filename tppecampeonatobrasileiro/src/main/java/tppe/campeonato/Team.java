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

  public String getName() {
    return teamName;
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

  public int getGoalDifference() {
    return goalsScored - goalsConceded;
  }

  public int setGoalsScored(int goals){
    return this.goalsScored += goals;
  }
  public int getGoalsScored(){
    return this.goalsScored ;
  }

  public int setGoalsConceded(int goals){
    return this.goalsConceded += goals;
  }

  public int getGoalsConceded(){
    return this.goalsConceded ;
  }

  public int setYellowCards(int cards){
    return this.yellowCards += cards ;
  }

  public int getYellowCards( ){
    return this.yellowCards ;
  }

  public int setRedCards(int cards){
    return this.redCards += cards ;
  }

  public int getRedCards(){
    return this.redCards ;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("- ")
    .append(String.format("%-17s", teamName)).append(" : ")
    .append("P = ").append(String.format("%02d", getPoints())).append(" | ")
    .append("V = ").append(String.format("%02d", getWins())).append(" | ")
    .append("E = ").append(String.format("%02d", getDraws())).append(" | ")
    .append("D = ").append(String.format("%02d", getLosses())).append(" | ")
    .append("GM = ").append(String.format("%02d", getGoalsScored())).append(" | ")
    .append("GC = ").append(String.format("%02d", getGoalsConceded())).append(" | ")
    .append("SG = ").append(String.format("%02d", getGoalDifference())).append(" | ")
    .append("RC = ").append(String.format("%02d", getRedCards())).append(" | ")
    .append("YC = ").append(String.format("%02d", getYellowCards())).append(" | ")
    .append("\n");

    return sb.toString();
  }

}
