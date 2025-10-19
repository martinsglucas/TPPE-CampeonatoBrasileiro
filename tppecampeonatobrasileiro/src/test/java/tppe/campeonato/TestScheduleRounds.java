package tppe.campeonato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  @Test
  public void deveTer10JogosPorRodadaETimesUnicos() {
    ArrayList<Round> rounds = c.getRounds();
    int expectedMatchesPerRound = teams.size() / 2;

    for (Round round : rounds) {
      ArrayList<Match> matches = round.getMatches();
      assertEquals(expectedMatchesPerRound, matches.size());

      Set<String> teamNames = new HashSet<>();
      for (Match m : matches) {
        assertTrue(teamNames.add(m.getHomeTeam().getName()));
        assertTrue(teamNames.add(m.getAwayTeam().getName()));
      }
      assertEquals(teams.size(), teamNames.size());
    }
  }

  @Test
  public void totalDePartidasEUnicidadeGlobal() {
    ArrayList<Round> rounds = c.getRounds();

    int totalMatches = 0;
    Set<String> directedPairs = new HashSet<>();

    for (Round round : rounds) {
      for (Match m : round.getMatches()) {
        totalMatches++;
        String key = m.getHomeTeam().getName() + "->" + m.getAwayTeam().getName();
        assertTrue(key, directedPairs.add(key));
      }
    }

    assertEquals((teams.size() - 1) * teams.size(), totalMatches);
  }

  @Test
  public void cadaParJogaIdaEVoltaExatamenteUmaVez() {
    ArrayList<Round> rounds = c.getRounds();
    Map<String, Integer> unorderedCount = new HashMap<>();
    Map<String, Integer> homeCount = new HashMap<>();
    Map<String, Integer> awayCount = new HashMap<>();

    for (Round round : rounds) {
      for (Match m : round.getMatches()) {
        String a = m.getHomeTeam().getName();
        String b = m.getAwayTeam().getName();

        String unordered = (a.compareToIgnoreCase(b) < 0) ? a + "|" + b : b + "|" + a;
        unorderedCount.put(unordered, unorderedCount.getOrDefault(unordered, 0) + 1);

        String homeKey = a + "->" + b;
        String awayKey = b + "->" + a;
        homeCount.put(homeKey, homeCount.getOrDefault(homeKey, 0) + 1);
        awayCount.put(awayKey, awayCount.getOrDefault(awayKey, 0)); 
      }
    }

    for (Map.Entry<String, Integer> e : unorderedCount.entrySet()) {
      assertEquals(2, (int) e.getValue());
    }

    for (Map.Entry<String, Integer> e : homeCount.entrySet()) {
      assertEquals(1, (int) e.getValue());
    }
  }
}
