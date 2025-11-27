package tppe.campeonato;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ArrayList<Team> teams = new ArrayList<Team>(
            Arrays.asList(
                new Team("Palmeiras"),
                new Team("Flamengo"),
                new Team("Cruzeiro"),
                new Team("Mirassol"),
                new Team("Botafogo"),
                new Team("Bahia"),
                new Team("Fluminense"),
                new Team("Vasco"),
                new Team("São Paulo"),
                new Team("Bragantino"),
                new Team("Corinthians"),
                new Team("Grêmio"),
                new Team("Ceará"),
                new Team("Internacional"),
                new Team("Atlético Mineiro"),
                new Team("Santos"),
                new Team("Vitória"),
                new Team("Juventude"),
                new Team("Fortaleza"),
                new Team("Sport")
            )
        );

        Competition brasileirao = new Competition(teams);

        System.out.println(brasileirao.allMatches);
    }
}
