package tppe.campeonato;

import java.util.ArrayList;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {

      ArrayList<Team>  teams = new ArrayList<Team>(Arrays.asList(
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

    Competition brasileirao = new Competition(teams);
    brasileirao.createAllMatches();
    ArrayList<Round> rounds = brasileirao.scheduleRounds();

    brasileirao.getMatch("Flamengo", "Botafogo").setResult(3, 0, 0, 0, 0, 0);

    System.out.println(brasileirao.getClassification().getFirst());

    // System.out.println(rounds);
    // System.out.println(flaVsBot);

    // Round r = new Round(0);

    // Team flamengo = new Team("Flamengo");
    // Team palmeiras = new Team("Palmeiras");
    // Team cruzeiro = new Team("Cruzeiro");
    // Team santos = new Team("Santos");

    // Match flaVsPal = new Match(flamengo, palmeiras);
    // Match cruVsSan = new Match(cruzeiro, santos);

    // r.addMatch(flaVsPal);
    // r.addMatch(cruVsSan);

    // flaVsPal.setResult(3, 1, 1, 2, 0, 0);
    // cruVsSan.setResult(1, 0, 2, 2, 0, 1);
    // ArrayList<Team> result = r.processRoundResult();


    // System.out.print(result.getFirst().getName());
    




    }
}
