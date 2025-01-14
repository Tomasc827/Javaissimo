
public class Main {

    public static void main(String[] args) {
        TripleTacoBox taco = new TripleTacoBox();
        RealTaco tacoDelicious = new RealTaco();
        taco.eat();
        taco.eat();
        System.out.println(tacoDelicious.getTaco());
        System.out.println(taco.tacosRemaining());
    }
}
