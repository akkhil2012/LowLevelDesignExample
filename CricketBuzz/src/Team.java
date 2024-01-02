import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Team {

    String name;

    boolean played=false;

    Player batsManAtStrike,batsManAtRunningEnd;

    int teamTotalscore;

    public boolean isPlayed() {
        return played;
    }

    List<Player> players;

    Player battingPlayer,stickingBatsman;

    Queue<Player> playersInQueue;

    public Queue<Player> getPlayersInQueue() {
        return playersInQueue;
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        playersInQueue = new ArrayBlockingQueue<>(11);

    }

    public void addPlayersToTeam(List<Player> playerList){
        players = playerList;
        players.stream().forEach(player -> playersInQueue.add(player));
        batsManAtStrike = playersInQueue.poll();
        batsManAtRunningEnd = playersInQueue.poll();
    }


    public boolean canFetchBattingPlayer() {
        return  playersInQueue.size()>=2;

    }

    public void updateScore(String score) {
          int intScore = Integer.parseInt(score);
           updateTeamScore(intScore);

           // update player score
           batsManAtStrike.getPlayerData().score++;


       /* if(score.equals("Wicket")){

        }*/

    }

    private void updateTeamScore(int score) {
        teamTotalscore +=score;
    }
}
