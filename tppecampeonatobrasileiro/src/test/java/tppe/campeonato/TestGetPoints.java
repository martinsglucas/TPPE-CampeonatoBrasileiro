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
public class TestGetPoints {

  Team t;
  private int expectedPoints = 0;
  private Object[] resultadoPartidas;

  @Before
  public void setup() {
    t = new Team("Flamengo");
  }

  public TestGetPoints(Object[] resultadoPartidas, int expectedPoints){
    this.resultadoPartidas = resultadoPartidas;
    this.expectedPoints = expectedPoints;
  }

  @Parameters
  public static Collection<Object[]> getParameters() {
    Object[] round1 = new Object[] {2, 1}; // (wins, draws)
    Object[] round2 = new Object[] {3, 0}; // (wins, draws)
    Object[] round3 = new Object[] {0, 2}; // (wins, draws)
    Object[] round4 = new Object[] {1, 1}; // (wins, draws)

    Object[][] tuplas = new Object[][] {
      {new Object[] {round1, round2}, 16},
      {new Object[] {round3, round4}, 6},
      {new Object[] {round1, round2, round3}, 18},
      {new Object[] {round1, round2, round3, round4}, 22},     
    };

    return Arrays.asList(tuplas);
  } 

  @Test
  public void testePontosVariasRodadas() {
    for(Object o : resultadoPartidas){
      Object[] dados = (Object[]) o;
      t.setWins((int) dados[0]);
      t.setDraws((int)dados[1]);

    }
    assertEquals(expectedPoints, t.getPoints());
  }

}
