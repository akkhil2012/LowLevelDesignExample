import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

    Set<Pair> snakes = Set.of(new Pair(99, 12), new Pair(56, 4), new Pair(23, 1));

    Set<Pair> laddders = Set.of(new Pair(2, 33), new Pair(23, 78), new Pair(65, 98));

    Player currentPlayer;

    public void playGame(Player player1, Player player2) throws InterruptedException {

        if (player1.isHasWon() || player2.isHasWon()) {
            System.out.println("Game Over");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String toss = scanner.next();
        if (toss.equals("first")) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        Dice dice = new Dice();

        while (!player1.isHasWon() && !player2.isHasWon()) {

            System.out.println(" Player thrown dice  is " + currentPlayer.getName());
            int number = dice.throwDice();
            System.out.println(" Number on Dice... " + number);

            int newPosition = currentPlayer.getPosition() + number;

            for (Pair pair : snakes) {
                if (pair.getStart() == newPosition) {
                    newPosition = pair.getEnd();
                    System.out.println(" Biten by snake  : got to" + newPosition);
                    break;
                }
            }

            for (Pair pair : laddders) {
                if (pair.getStart() == newPosition) {
                    newPosition = pair.getEnd();
                    System.out.println(" Blessed by ladder  : got to" + newPosition);
                    break;
                }
            }

            currentPlayer.setPosition(newPosition);
            System.out.println("New Position is:::: " + currentPlayer.getPosition());


            if (newPosition >= 100) {
                System.out.println(" Player " + currentPlayer + " Won!!");
                currentPlayer.setHasWon(true);
                break;
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;

            Thread.sleep(2000);

            System.out.println("----------------------------------------");


        }

        Player winner = player1.isHasWon() == true ? player1 : player2;
        System.out.println(" WINNER IS " + winner.getName());


    }


}
