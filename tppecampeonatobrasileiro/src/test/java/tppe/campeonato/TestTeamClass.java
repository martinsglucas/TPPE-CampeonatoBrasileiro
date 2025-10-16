package tppe.campeonato;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTeamClass {

  Team t;
  private int expectedPoints = 0;
  private Object[] partidas;
  private int expectedWins;
  private int expecteDraws;
  private int expecteLosses;

  @Before
  public void setup() {
    t = new Team("Flamengo");
  }

  public TestTeamClass(Object[] partidas, int expectedPoints, int expectedWins, int expecteDraws, int expectedLosses){
    this.partidas = partidas;
    this.expectedPoints = expectedPoints;
    this.expectedWins = expectedWins;
    this.expecteDraws = expecteDraws;
    this.expecteLosses = expectedLosses;
  }

  @Parameters
  public static Collection<Object[]> getParameters() {
     // Primeiro Teste (wins, draws) Segundo Teste (GolsMarcados, GolsSofridos)
    Object[] round1 = new Object[] {2, 1};
    Object[] round2 = new Object[] {3, 0};
    Object[] round3 = new Object[] {0, 2};
    Object[] round4 = new Object[] {1, 1};

    Object[][] tuplas = new Object[][] {
      // Vetor de Resultado das partidas, Total de Pontos, Todal de Vitorias, Total de Empates, Total de Derrotas
      {new Object[] {round1, round2}, 16, 2, 0, 0},
      {new Object[] {round3, round4}, 6, 0, 1, 1},
      {new Object[] {round1, round2, round3}, 18, 2, 0, 1},
      {new Object[] {round1, round2, round3, round4}, 22, 2, 1, 1},
    };

    return Arrays.asList(tuplas);
  } 

  @Test
  public void testePontosVariasRodadas() {
    for(Object o : partidas){
      Object[] dados = (Object[]) o;
      t.setWins((int) dados[0]);
      t.setDraws((int)dados[1]);

    }
    assertEquals(expectedPoints, t.getPoints());
  }

  @Test
  public void testRegistroDePartidas(){
    for(Object o : partidas){
      Object[] dados = (Object[]) o;
       t.registerResults((int)dados[0], (int)dados[1]);
    }
    assertEquals(expectedWins, t.getWins());
    assertEquals(expecteDraws, t.getDraws());
    assertEquals(expecteLosses, t.getLosses());
  }
}
