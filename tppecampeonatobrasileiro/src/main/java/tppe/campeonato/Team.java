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

  public Team(String teamName){
    this.teamName = teamName;
    this.wins = 0;
    this.draws = 0;
    this.losses = 0;
    this.goalsScored = 0;
    this.goalsConceded = 0;
    this.yellowCards = 0;
    this.redCards = 0;
  }

  public int getPoints() {
    return (this.wins * 3) + this.draws;
  }
  
  public void setWins(int wins) {
    this.wins = wins;
  }

  public void setDraws(int draws) {
    this.draws = draws;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }

  @Override
  public String toString() {
    return teamName;
  }

}
