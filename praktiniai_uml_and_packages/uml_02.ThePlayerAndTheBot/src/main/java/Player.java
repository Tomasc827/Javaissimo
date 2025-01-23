public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }


    public void play(Bot bot) {
        System.out.println("Play");
        bot.play();
    }

    public void printName() {
        System.out.println(name);
    }

}
