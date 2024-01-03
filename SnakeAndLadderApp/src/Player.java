public class Player {


    String name;

    boolean hasWon;

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public Player(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    int position;
}
