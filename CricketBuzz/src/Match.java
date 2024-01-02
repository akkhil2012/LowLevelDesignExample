import java.util.Queue;
import java.util.Scanner;

public class Match {
    Team TeamA, TeamB;
    DashBoard dashBoard;

    public Match() {
        this.dashBoard = new DashBoard();
    }

    Team previousTeamPlayed, currentTeamPlaying;

    final static int TOTAL_OVERS = 40;
    final static int BALLS_IN_OVERS = 6;

    enum Score {
        WICKET,
        EXTRA_BALL,
        RUNS
    }


    public void playMatch(Queue<Team> teams) {
        //Scanner scanner = new Scanner(System.in);
        currentTeamPlaying = teams.poll();

        Team team = currentTeamPlaying;
        dashBoard.display("Batting Team: " + currentTeamPlaying + " Bowling :" + teams.peek());

        Player batsManAtStrike = team.getPlayersInQueue().poll();
        Player batsManAtRunner = team.getPlayersInQueue().poll();

        for (int over = 1; over < TOTAL_OVERS; over++) {
            if (!team.canFetchBattingPlayer()) {

                for (int ball = 1; ball <= BALLS_IN_OVERS; ball++) {
                    Scanner scanner = new Scanner(System.in);
                    String score = scanner.nextLine();
                    team.updateScore(score);


                    if (teams.stream().filter(teamInMatch -> !teamInMatch.isPlayed()).findAny().isEmpty()) {
                        dashBoard.display("Match is Over.....");
                        return;
                    } else if(teams.peek().isPlayed()){
                        switchInnings(currentTeamPlaying, previousTeamPlayed);
                        dashBoard.display("Sides changed");
                        dashBoard.display("Batting Team: " + currentTeamPlaying + " Bowling :" + previousTeamPlayed);
                    }

                }


            }
            //Player batting = team.canFetchBattingPlayer();


        }


    }


    private void switchInnings(Team previous, Team current) {

        Team dummy = previous;
        previous = current;
        current = dummy;

    }


}
