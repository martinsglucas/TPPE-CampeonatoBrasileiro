package tppe.campeonato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class TestGetPoints {

  Team t;
  private int wins = 0;
  private int draws = 0;
  private int losses = 0;
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
      
    }
  } 

  @Test
  public void test() {
    assertEquals(expectedPoints, t.getPoints());
  }

}
