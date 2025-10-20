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

public class TestCompetition {

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

  @Test
  public void testLibertadoresRetorna6Times() {
    ArrayList<Team> libertadores = c.getLibertadores();
    assertEquals("Libertadores deve ter 6 times (posições 1-6)", 6, libertadores.size());
  }

  @Test
  public void testSulAmericanaRetorna6Times() {
    ArrayList<Team> sulAmericana = c.getSulAmericana();
    assertEquals("Sul-Americana deve ter 6 times (posições 7-12)", 6, sulAmericana.size());
  }

  @Test
  public void testRebaixadosRetorna4Times() {
    ArrayList<Team> rebaixados = c.getRebaixados();
    assertEquals("Rebaixados deve ter 4 times (posições 17-20)", 4, rebaixados.size());
  }

  @Test
  public void testLibertadoresSaoOsTopTimes() {
    // Simula alguns resultados para criar diferenciação
    simulateRoundResults();
    
    ArrayList<Team> classification = c.getClassification();
    ArrayList<Team> libertadores = c.getLibertadores();

    // Os 6 primeiros da classificação devem estar na Libertadores
    for (int i = 0; i < 6; i++) {
      assertTrue("Time " + classification.get(i).getName() + " deve estar na Libertadores", 
                 libertadores.contains(classification.get(i)));
    }
  }

  @Test
  public void testSulAmericanaSaoTimesIntermediarios() {
    simulateRoundResults();
    
    ArrayList<Team> classification = c.getClassification();
    ArrayList<Team> sulAmericana = c.getSulAmericana();

    // Os times da posição 7 a 12 devem estar na Sul-Americana
    for (int i = 6; i < 12; i++) {
      assertTrue("Time " + classification.get(i).getName() + " deve estar na Sul-Americana", 
                 sulAmericana.contains(classification.get(i)));
    }
  }

  @Test
  public void testRebaixadosSaoOsUltimosTimes() {
    simulateRoundResults();
    
    ArrayList<Team> classification = c.getClassification();
    ArrayList<Team> rebaixados = c.getRebaixados();

    // Os últimos 4 times devem estar na zona de rebaixamento
    for (int i = 16; i < 20; i++) {
      assertTrue("Time " + classification.get(i).getName() + " deve estar rebaixado", 
                 rebaixados.contains(classification.get(i)));
    }
  }

  @Test
  public void testFaixasNaoSeInterceptam() {
    simulateRoundResults();
    
    ArrayList<Team> libertadores = c.getLibertadores();
    ArrayList<Team> sulAmericana = c.getSulAmericana();
    ArrayList<Team> rebaixados = c.getRebaixados();

    // Libertadores e Sul-Americana não devem ter times em comum
    for (Team t : libertadores) {
      assertTrue("Time da Libertadores não pode estar na Sul-Americana: " + t.getName(), 
                 !sulAmericana.contains(t));
      assertTrue("Time da Libertadores não pode estar rebaixado: " + t.getName(), 
                 !rebaixados.contains(t));
    }

    // Sul-Americana e Rebaixados não devem ter times em comum
    for (Team t : sulAmericana) {
      assertTrue("Time da Sul-Americana não pode estar rebaixado: " + t.getName(), 
                 !rebaixados.contains(t));
    }
  }

  @Test
  public void testOrdemDosTimesNasListas() {
    simulateRoundResults();
    
    ArrayList<Team> classification = c.getClassification();
    ArrayList<Team> libertadores = c.getLibertadores();

    // A ordem dentro de cada lista deve corresponder à ordem da classificação
    assertEquals("Primeiro da Libertadores deve ser o campeão", 
                 classification.get(0).getName(), libertadores.get(0).getName());
    assertEquals("Segundo da Libertadores deve ser o vice", 
                 classification.get(1).getName(), libertadores.get(1).getName());
  }

  @Test
  public void testComTodosTimesEmpatados() {
    // Sem simular resultados, todos ficam com 0 pontos
    // A ordem será definida por critérios de desempate (alfabético no final)
    
    ArrayList<Team> libertadores = c.getLibertadores();
    ArrayList<Team> sulAmericana = c.getSulAmericana();
    ArrayList<Team> rebaixados = c.getRebaixados();

    assertEquals(6, libertadores.size());
    assertEquals(6, sulAmericana.size());
    assertEquals(4, rebaixados.size());
  }

  @Test
  public void testIndicesCorretosDasSubLists() {
    ArrayList<Team> classification = c.getClassification();
    
    // Libertadores: posições 0-5 (6 times)
    ArrayList<Team> libertadores = c.getLibertadores();
    assertEquals(classification.get(0).getName(), libertadores.get(0).getName());
    assertEquals(classification.get(5).getName(), libertadores.get(5).getName());
    
    // Sul-Americana: posições 6-11 (6 times)
    ArrayList<Team> sulAmericana = c.getSulAmericana();
    assertEquals(classification.get(6).getName(), sulAmericana.get(0).getName());
    assertEquals(classification.get(11).getName(), sulAmericana.get(5).getName());
    
    // Rebaixados: posições 16-19 (4 times)
    ArrayList<Team> rebaixados = c.getRebaixados();
    assertEquals(classification.get(16).getName(), rebaixados.get(0).getName());
    assertEquals(classification.get(19).getName(), rebaixados.get(3).getName());
  }

  /**
   * Método auxiliar para simular alguns resultados e criar diferenciação na classificação
   */
  private void simulateRoundResults() {
    // Simula resultados da primeira rodada para criar alguma diferenciação
    Round round0 = c.getRound(0);
    ArrayList<Match> matches = round0.getMatches();
    
    // Define alguns placares variados
    if (matches.size() >= 5) {
      matches.get(0).setResult(3, 0);  // Vitória mandante
      matches.get(1).setResult(2, 1);  // Vitória mandante
      matches.get(2).setResult(1, 1);  // Empate
      matches.get(3).setResult(0, 2);  // Vitória visitante
      matches.get(4).setResult(1, 3);  // Vitória visitante
    }
    
    // Simula mais algumas rodadas para aumentar diferenciação
    if (c.getRounds().size() >= 3) {
      Round round1 = c.getRound(1);
      ArrayList<Match> matches1 = round1.getMatches();
      if (matches1.size() >= 3) {
        matches1.get(0).setResult(2, 0);
        matches1.get(1).setResult(1, 2);
        matches1.get(2).setResult(0, 0);
      }
    }
  }
}
