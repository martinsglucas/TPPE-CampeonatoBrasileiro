package tppe.campeonato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestScheduleRounds {

  Competition c;

  @Before
  public void setup() {
    c = new Competition();
  }

  @Test
  public void test() {
    assertEquals(10, c.scheduleMatches());
  }
  
}
