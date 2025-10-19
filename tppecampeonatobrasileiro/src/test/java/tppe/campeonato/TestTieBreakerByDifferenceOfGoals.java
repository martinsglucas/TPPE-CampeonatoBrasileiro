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
public class TestTieBreakerByDifferenceOfGoals {

    private ArrayList<Team> teams;
    private Team firstTeam;
    private Team fla;
    private Team pal;
    private Competition copaBrasil;
    private int goalsScoredTeam1;
    private int goalsScoredTeam2;

    
    @SuppressWarnings("unused")
    private int goalsConcededTeam1;
    @SuppressWarnings("unused")
    private int goalsConcededTeam2;


    @Before
    public void setup(){
        fla = new Team("Flamengo");
        pal = new Team("Palmeiras");

        fla.setGoalsScored(goalsScoredTeam1);
        pal.setGoalsScored(goalsScoredTeam2);
        fla.setGoalsConceded(goalsScoredTeam2);
        pal.setGoalsConceded(goalsScoredTeam1);


        teams = new ArrayList<>(Arrays.asList(fla, pal));
        copaBrasil = new Competition(teams);
    }

    public TestTieBreakerByDifferenceOfGoals(int goalsScoredTeam1, int goalsScoredTeam2, String firstTeam){
        this.goalsScoredTeam1 = goalsScoredTeam1;
        this.goalsScoredTeam2 = goalsScoredTeam2;
        this.goalsConcededTeam1 = goalsScoredTeam2;
        this.goalsConcededTeam2 = goalsScoredTeam1;
        this.firstTeam = new Team(firstTeam);
    }

    @Parameters
    public static Collection<Object[]> getParameters(){

        Object[][] parametros = new Object[][]{
          {1,0,"Flamengo"},
          {0,2,"Palmeiras"},
          {2,1,"Flamengo"}
        };
        return Arrays.asList(parametros);
    }

    @Test
    public void TesteTieBreakerByDifferenceOfGoals() {
        Team actualFirst = copaBrasil.getClassification().get(0);
        System.out.println(copaBrasil);
        assertEquals(firstTeam.getName(), actualFirst.getName());
    }
    
}
