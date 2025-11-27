package tppe.campeonato;

public class Team {
  private String teamName;
  private TeamStatistics stats;

  public Team(String teamName) {
    this.teamName = teamName;
    this.stats = new TeamStatistics();
  }

  public String getName() {
    return teamName;
  }

  public int getPoints() {
    return stats.getPoints();
  }

  public void setWins(int wins) {
    stats.setWins(wins);
  }

  public int getWins() {
    return stats.getWins();
  }

  public void setDraws(int draws) {
    stats.setDraws(draws);
  }

  public int getDraws() {
    return stats.getDraws();
  }

  public void setLosses(int losses) {
    stats.setLosses(losses);
  }

  public int getLosses() {
    return stats.getLosses();
  }

  public void registerResults(int matchGoalsScored, int matchGoalsConceded) {
    stats.registerResults(matchGoalsScored, matchGoalsConceded);
  }

  public int getGoalDifference() {
    return stats.getGoalDifference();
  }

  public int setGoalsScored(int goals) {
    return stats.setGoalsScored(goals);
  }

  public int getGoalsScored() {
    return stats.getGoalsScored();
  }

  public int setGoalsConceded(int goals) {
    return stats.setGoalsConceded(goals);
  }

  public int getGoalsConceded() {
    return stats.getGoalsConceded();
  }

  public int setYellowCards(int cards) {
    return stats.setYellowCards(cards);
  }

  public int getYellowCards() {
    return stats.getYellowCards();
  }

  public int setRedCards(int cards) {
    return stats.setRedCards(cards);
  }

  public int getRedCards() {
    return stats.getRedCards();
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
