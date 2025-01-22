package lt.techin;

import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

public class Heineken implements BeerFactory {
    @Override
    public void receiveMaltShippment(double v) {

    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {
        return null;
    }
}
