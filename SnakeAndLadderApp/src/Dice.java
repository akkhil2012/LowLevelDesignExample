public class Dice {

    public int throwDice(){
        return (int) (Math.floor(Math.random() * 6) + 1);
    }
}
