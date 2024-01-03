public class App {

    public static void main(String args[]) throws InterruptedException {
        Player player1 = new Player("first");
        Player player2 = new Player("second");

        new Game().playGame(player1,player2);
    }
}
