package tppe.campeonato;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestScheduleRounds {

  Competition c;
  ArrayList<Team> teams;

  @Before
  public void setup() {
    teams = new ArrayList<Team>(Arrays.asList(
      new Team("Palmeiras"),
      new Team("Flamengo"),
      new Team("Cruzeiro"),
      new Team("Mirassol"),
      new Team("Botafogo"),
      new Team("Bahia"),
      new Team("Fluminense"),
      new Team("Sao Paulo"),
      new Team("Bragantino"),
      new Team("Ceara"),
      new Team("Vasco"),
      new Team("Corinthians"),
      new Team("Gremio"),
      new Team("Atletico Mineiro"),
      new Team("Internacional"),
      new Team("Santos"),
      new Team("Vitoria"),
      new Team("Fortaleza"),
      new Team("Juventude"),
      new Team("Sport Recife")

    ));

    c = new Competition(teams);
  }

  @Test
  public void TesteScheduleRounds() {
    ArrayList<Round> rounds = c.getRounds();
    boolean notEqualsMatches = true;

    assertEquals((teams.size() - 1) * 2, rounds.size());

    for (Round x : rounds) {
      ArrayList<Match> matches = x.getMatches();

      for (Match m : matches) {
        for (Round y : rounds) {

          if (x == y) continue;

          if (y.getMatches().contains(m)) notEqualsMatches = false;
        }
      }
    }

    assertEquals(true, notEqualsMatches);
  
  }
}
