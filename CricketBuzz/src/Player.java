public class Player {
    String name;

    public String getName() {
        return name;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    PlayerData playerData;

    public Player(String name) {
        this.name = name;
        this.playerData = new PlayerData();
    }
}
