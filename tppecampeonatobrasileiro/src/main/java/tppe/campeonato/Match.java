package tppe.campeonato;

public class Match {

  private Team homeTeam;
  private Team awayTeam;
  private int GolsHome;
  private int GolsAway;

  public Match(Team awayTeam, Team homeTeam){
      this.awayTeam = awayTeam;
      this.homeTeam = homeTeam;
  }

  public Team getAwayTeam() {return this.awayTeam;}
  public Team getHomeTeam() {return this.homeTeam;}

  public int getGolsHome() {return GolsHome;}
  public int getGolsAway() {return GolsAway;}


  public void playGame(int GolsHomeTeam, int GolsAwayTeam){
    this.GolsHome = GolsHomeTeam;
    this.GolsAway = GolsAwayTeam;

    homeTeam.registerResults(GolsHomeTeam, GolsAwayTeam);
    awayTeam.registerResults(GolsAwayTeam, GolsHomeTeam);
  }


  @Override 
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
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
