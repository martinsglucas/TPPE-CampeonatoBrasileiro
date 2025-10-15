package tppe.campeonato;

public class Match {

  private Team homeTeam;
  private Team awayTeam;
  private int homeGoals;
  private int awayGoals;
  private int homeYellowCards;
  private int awayYellowCards;
  private int homeRedCards;
  private int awayRedCards;

  public Match(Team homeTeam, Team awayTeam) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeGoals = 0;
    this.awayGoals = 0;
    this.homeYellowCards = 0;
    this.awayYellowCards = 0;
    this.homeRedCards = 0;
    this.awayRedCards = 0;
  }

  public Team getAwayTeam() {
    return this.awayTeam;
  }

  public Team getHomeTeam() {
    return this.homeTeam;
  }

  public int getHomeGoals() {
    return this.homeGoals;
  }

  public int getAwayGoals() {
    return this.awayGoals;
  }

  public int getHomeYellowCards() {
    return this.homeYellowCards;
  }

  public int getAwayYellowCards() {
    return this.awayYellowCards;
  }

  public int getHomeRedCards() {
    return this.homeRedCards;
  }

  public int getAwayRedCards() {
    return this.awayRedCards;
  }

  public void setResult(int homeGoals, int awayGoals, int homeYellowCards, int awayYellowCards, int homeRedCards, int awayRedCards) {
    // Cards
    homeTeam.setYellowCards(homeYellowCards);
    homeTeam.setRedCards(homeRedCards);
    awayTeam.setYellowCards(awayYellowCards);
    awayTeam.setRedCards(awayRedCards);

    // Goals
    homeTeam.setGoalsConceded(awayGoals);
    homeTeam.setGoalsScored(homeGoals);
    awayTeam.setGoalsConceded(homeGoals);
    awayTeam.setGoalsScored(awayGoals);
    
    if (homeGoals > awayGoals) {
        homeTeam.setWins(1);  
        awayTeam.setLosses(1);
    } else if (awayGoals > homeGoals) {
        awayTeam.setWins(1);  
        homeTeam.setLosses(1);
    } else {
      homeTeam.setDraws(1);
      awayTeam.setDraws(1);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Match other = (Match) obj;
    return this.getHomeTeam().equals(other.getHomeTeam()) && this.getAwayTeam().equals(other.getAwayTeam());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(homeTeam.toString()).append(" x ").append(awayTeam.toString());

    return sb.toString();
  }

}
