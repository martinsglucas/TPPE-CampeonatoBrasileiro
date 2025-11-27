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
      new Team("Mirassol")
    ));

    Competition brasileirao = new Competition(teams);

    // Rodada 0
    brasileirao
      .getMatch("Palmeiras", "Flamengo")
      .setResult(0, 2)
      .setYellowCards(1, 1);
    brasileirao
      .getMatch("Cruzeiro", "Mirassol")
      .setResult(2, 1);
    
    // Rodada 1
    brasileirao
      .getMatch("Palmeiras", "Cruzeiro")
      .setResult(2, 3);
    brasileirao
      .getMatch("Flamengo", "Mirassol")
      .setResult(1, 1);
    
    // Rodada 2
    brasileirao
      .getMatch("Palmeiras", "Mirassol")
      .setResult(1, 1);
    brasileirao
      .getMatch("Flamengo", "Cruzeiro")
      .setResult(1, 1);
    
    // Rodada 3
    brasileirao
      .getMatch("Flamengo", "Palmeiras")
      .setResult(2, 2);
    brasileirao
      .getMatch("Mirassol", "Cruzeiro")
      .setResult(2, 1);
    
    // Rodada 4
    brasileirao
      .getMatch("Cruzeiro", "Palmeiras")
      .setResult(1, 2);
    brasileirao
      .getMatch("Mirassol", "Flamengo")
      .setResult(1, 1);
    
    // Rodada 5
    brasileirao
      .getMatch("Cruzeiro", "Flamengo")
      .setResult(1, 1);
    brasileirao
      .getMatch("Mirassol", "Palmeiras")
      .setResult(0, 0);

    brasileirao.getClassification();

    System.out.println(brasileirao);


    }
}