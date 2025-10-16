package tppe.campeonato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestResultProcessorByRound {

  Round r;
  ArrayList<Team> teams;

  @Before
  public void setup() {
    r = new Round(0);

    Team flamengo = new Team("Flamengo");
    Team palmeiras = new Team("Palmeiras");
    Team cruzeiro = new Team("Cruzeiro");
    Team santos = new Team("Santos");

    teams = new ArrayList<>(Arrays.asList(
      flamengo,
      palmeiras,
      cruzeiro,
      santos
    ));

    Match flaVsPal = new Match(flamengo, palmeiras);
    Match cruVsSan = new Match(cruzeiro, santos);

    r.addMatch(flaVsPal);
    r.addMatch(cruVsSan);

    flaVsPal.setResult(3, 1, 1, 2, 0, 0);
    cruVsSan.setResult(1, 0, 2, 2, 0, 1);

  }

  @Test
  public void test() {
    ArrayList<Team> result = r.processRoundResult(teams);
    assertTrue("Flamengo".equals(result.getFirst().getName()));
  }


}