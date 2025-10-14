package tppe.campeonato;

public class Match {

  private Team homeTeam;
  private Team awayTeam;

  public Match(Team awayTeam, Team homeTeam){
      this.awayTeam = awayTeam;
      this.homeTeam = homeTeam;
  }

  public Team getAwayTeam(){
    return this.awayTeam;
  }
  public Team getHomeTeam(){
    return this.homeTeam;
  }

  
  
}
