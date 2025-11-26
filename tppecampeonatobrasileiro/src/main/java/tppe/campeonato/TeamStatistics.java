package tppe.campeonato;

public class TeamStatistics {
    private int wins;
    private int draws;
    private int losses;
    private int goalsScored;
    private int goalsConceded;
    private int yellowCards;
    private int redCards;

    public int getPoints() {
        return (this.wins * 3) + this.draws;
    }

    public void registerResults(int matchGoalsScored, int matchGoalsConceded) {
        this.goalsScored += matchGoalsScored;
        this.goalsConceded += matchGoalsConceded;

        if (matchGoalsScored > matchGoalsConceded) {
            this.wins++;
        } else if (matchGoalsScored < matchGoalsConceded) {
            this.losses++;
        } else {
            this.draws++;
        }
    }

    public int getGoalDifference() {
      return goalsScored - goalsConceded;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws += draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses += losses;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int setGoalsScored(int goals) {
        return this.goalsScored += goals;
    }

    public int getGoalsConceded() {
        return this.goalsConceded;
    }

    public int setGoalsConceded(int goals) {
        return this.goalsConceded += goals;
    }

    public int getYellowCards() {
        return this.yellowCards;
    }

    public int setYellowCards(int yellowCards) {
        return this.yellowCards += yellowCards;
    }

    public int getRedCards() {
        return this.redCards;
    }

   public int setRedCards(int redCards) {
        return this.redCards += redCards;
    }
}