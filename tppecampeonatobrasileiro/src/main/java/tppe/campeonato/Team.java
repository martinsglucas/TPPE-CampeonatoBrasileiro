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

  public String getName() {
    return teamName;
  }

  public int getPoints() {
    return (this.wins * 3) + this.draws;
  }
  
  public void setWins(int wins) {
    this.wins += wins;
  }

  public int getWins() {
    return this.wins;
  }

  public void setDraws(int draws) {
    this.draws += draws;
  }

  public int getDraws() {
    return this.draws;
  }

  public void setLosses(int losses) {
    this.losses += losses;
  }

    public int getLosses() {
    return this.losses;
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
    // return teamName;
    StringBuilder sb = new StringBuilder();

    sb.append(teamName).append(" - Pontos = ").append(getPoints()).append(" - Vitorias: ").append(getWins());

    return sb.toString();
  }

}
