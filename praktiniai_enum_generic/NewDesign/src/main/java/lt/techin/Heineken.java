package lt.techin;

import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

import java.util.Random;

public class Heineken implements BeerFactory {
    private int malt;
    private final Random r = new Random();
    public Heineken() {
        this.malt = 1000;
    }


    @Override
    public void receiveMaltShippment(double amountInKgs) {
        malt += (int) (amountInKgs * 1000);
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {
        if (malt >= 25) {
            malt -= 25;
            return new DefaultBeerBottle(r.nextDouble(0.33, 0.5), r.nextDouble(4.5,5.7));
        }

        else {
            throw new NoMoreMaltException("No more malt left");
        }
    }
}
