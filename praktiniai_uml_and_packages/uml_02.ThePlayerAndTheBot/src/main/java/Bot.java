public class Bot extends Player{


    public Bot(String name) {
        super(name);
    }

    public void play() {
        System.out.println("Bot Play");
    }

    public void addMove(String move) {
        System.out.println(move);
    }
}
