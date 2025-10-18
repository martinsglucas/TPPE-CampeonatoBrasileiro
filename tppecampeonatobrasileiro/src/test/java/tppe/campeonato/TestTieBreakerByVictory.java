package tppe.campeonato;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTieBreakerByVictory {

    private ArrayList<Team> teams;
    private Team firstTeam;
    private Team fla;
    private Team pal;
    private Competition copaBrasil;
    private int victoriesTeam1;
    private int victoriesTeam2;
    private int drawsTeam1;
    private int drawsTeam2;

    @Before
    public void setup(){
        fla = new Team("Flamengo");
        pal = new Team("Palmeiras");

        fla.setWins(victoriesTeam1);
        pal.setWins(victoriesTeam2);
        fla.setDraws(drawsTeam1);
        pal.setDraws(drawsTeam2);

        teams = new ArrayList<>(Arrays.asList(fla, pal));
        copaBrasil = new Competition(teams);
    }

    public TestTieBreakerByVictory( int victoriesTeam1, int victoriesTeam2, int drawsTeam1, int drawsTeam2, String firsTeam){
        this.victoriesTeam1 = victoriesTeam1;
        this.victoriesTeam2 = victoriesTeam2;
        this.drawsTeam1 = drawsTeam1;
        this.drawsTeam2 = drawsTeam2;
        this.firstTeam = new Team(firsTeam);
    }

    @Parameters
    public static Collection<Object[]> getParameters(){

        Object[][] parametros = new Object[][]{
          {1,0,0,3,"Flamengo"},
          {1,2,3,0,"Palmeiras"},
          {2,1,0,3,"Flamengo"}  
        };
        return Arrays.asList(parametros);
    }

    @Test
    public void test() {
        Team actualFirst = copaBrasil.getClassification().get(0);
        System.out.println(actualFirst);
        assertEquals(firstTeam.getName(), actualFirst.getName());
    }
    
}
