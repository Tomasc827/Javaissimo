package lt.techin;

import itadesign.beerdrinker.BeerBottle;


public class Juice implements BeerBottle {
    private BeerBottle beerBottle;

    public Juice(BeerBottle beerBottle) {
        this.beerBottle = beerBottle;
    }


    @Override
    public double getAlcoholContentInPercent() {
        return 0;
    }

    @Override
    public double getVolumeInLiters() {
        return beerBottle.getVolumeInLiters();
    }

    @Override
    public void takeASip(double v) {
        beerBottle.takeASip(v);
    }
}
