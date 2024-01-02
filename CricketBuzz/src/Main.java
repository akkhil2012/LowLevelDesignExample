import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        Match match = new Match();
        Team teamA = new Team("India");
        teamA.addPlayersToTeam(List.of(new Player("A1"),new Player("A2"),new Player("A3"),new Player("A4"),new Player("A5")));
        Team teamB = new Team("Srilanka");
        teamA.addPlayersToTeam(List.of(new Player("B1"),new Player("B2"),new Player("B3"),new Player("B4"),new Player("B5")));

        Queue<Team> teams = new ArrayDeque<>();
        teams.add(teamA);
        teams.add(teamB);

        match.playMatch(teams);



    }
}