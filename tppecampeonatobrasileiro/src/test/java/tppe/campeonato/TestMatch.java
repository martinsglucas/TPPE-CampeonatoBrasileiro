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
public class TestMatch {
    Match m;
    private int awayGolsScored = 0;
    private int homeGolsScored = 0;
    
    @Before
    public void setup() {
        m = new Match(new Team("Flamengo"), new Team("Palmeiras"));
    }

    public TestMatch(int homeGolsScored, int awayGolsScored){
        this.homeGolsScored = homeGolsScored;
        this.awayGolsScored = awayGolsScored;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] tuplas = new Object[][] {
            {3, 1},
            {1, 0}
        };
        return Arrays.asList(tuplas);
    }

    @Test
    public void testPlayGame(){
        m.playGame(homeGolsScored, awayGolsScored);
        assertEquals(homeGolsScored, m.getGolsHome());
        assertEquals(awayGolsScored, m.getGolsAway());   
        m.playGame(awayGolsScored, homeGolsScored);
        assertEquals(awayGolsScored, m.getGolsHome());
        assertEquals(homeGolsScored, m.getGolsAway());    
    }

}
