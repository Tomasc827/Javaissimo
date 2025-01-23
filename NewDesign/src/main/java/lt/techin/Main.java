package lt.techin;


import itadesign.beerdrinker.DefaultBeerBottle;

public class Main {
    public static void main(String[] args) {
        Homer h = new Homer();
        DefaultBeerBottle d = new DefaultBeerBottle(0.6,4);
        h.shouldConsumeBeer(d);
    }
}