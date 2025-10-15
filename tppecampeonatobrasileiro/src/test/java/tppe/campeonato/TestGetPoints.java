package tppe.campeonato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestGetPoints {

  Team t;
  private int wins = 4;
  private int draws = 3;
  private int losses = 3;
  private int expectedPoints = (wins * 3) + draws;

  @Before
  public void setup() {
    t = new Team("Flamengo");
    t.setWins(wins);
    t.setDraws(draws);
    t.setLosses(losses);

    t.getPoints();
  }

  @Test
  public void test() {
    assertEquals(expectedPoints, t.getPoints());
  }

}
