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
public class TestTieBreakerByCards {

    private ArrayList<Team> teams;
    private Team firstTeam;
    private Team fla;
    private Team pal;
    private Competition copaBrasil;
    private int redCardsTeam1;
    private int redCardsTeam2;
    private int yellowCardsTeam1;
    private int yellowCardsTeam2;


    @Before
    public void setup(){
        fla = new Team("Flamengo");
        pal = new Team("Palmeiras");

        fla.setRedCards(redCardsTeam1);
        pal.setRedCards(redCardsTeam2);
        fla.setYellowCards(yellowCardsTeam1);
        pal.setYellowCards(yellowCardsTeam2);
       
        teams = new ArrayList<>(Arrays.asList(fla, pal));
        copaBrasil = new Competition(teams);
    }

    public TestTieBreakerByCards(int redCardsTeam1, int redCardsTeam2, int yellowCardsTeam1, int yellowCardsTeam2, String firsTeam){
        this.redCardsTeam1 = redCardsTeam1;
        this.redCardsTeam2 = redCardsTeam2;
        this.yellowCardsTeam1 = yellowCardsTeam1;
        this.yellowCardsTeam2 = yellowCardsTeam2;
        this.firstTeam = new Team(firsTeam);
    }

    @Parameters
    public static Collection<Object[]> getParameters(){

        Object[][] parametros = new Object[][]{
          {0,1,0,0,"Flamengo"},
          {2,1,0,0,"Palmeiras"},
          {2,2,1,2,"Flamengo"},
          {0,0,2,1,"Palmeiras"},
          {1,1,0,3,"Flamengo"},
          {2,1,3,2,"Palmeiras"},
          {1,3,1,1,"Flamengo"}
        };
        return Arrays.asList(parametros);
    }

    @Test
    public void test() {
        Team actualFirst = copaBrasil.getClassification().get(0);
        System.out.println(copaBrasil);
        assertEquals(firstTeam.getName(), actualFirst.getName());
    }
    
}
