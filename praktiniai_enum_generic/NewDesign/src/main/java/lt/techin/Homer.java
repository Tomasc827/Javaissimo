package lt.techin;

import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.DefaultBeerBottle;

public class Homer extends BeerConsumer {
    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
            if (beerBottle.getVolumeInLiters() <= 0.5 &&
                beerBottle.getAlcoholContentInPercent() <= 6 &&
                getBloodAlcoholContentInLiters() < 0.12) {
                return true;

        } else {
                System.out.println("⠀⠀⠀⠀⠀⣀⡤⢤⣤⠤⠒⠒⠚⠒⠒⠤⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⣴⣋⣥⠶⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⠦⠤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⣠⡞⢉⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠓⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢠⠇⣹⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠦⣄⠀⠀⢀⣠⣴⣶⣿⡏⠉⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢸⣰⠋⠹⠄⠀⠀⠀⠀⠀⠀⠀⣀⠤⠖⠒⠋⠹⡖⠋⡴⠁⠀⠀⠙⡄⢸⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢸⣯⠀⠀⠀⠀⠀⠀⣦⢀⡴⠛⠟⠀⠀⠀⠀⠀⢱⡜⠀⠀⠀⠀⢸⡤⠊⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⣏⠛⠀⠀⠀⠀⠀⢹⡏⠀⠀⠀⠀⠀⠀⠀⠀⡼⠁⠀⠀⢀⡤⠟⠒⠂⠈⠙⠒⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠸⡄⠀⠀⠀⠀⠀⠀⠳⣄⠀⠀⠀⠀⠀⢀⠜⠁⠀⡤⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠲⣄⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠹⣄⠀⠀⢀⠀⠀⠀⠈⠑⠒⠲⠒⠚⠁⠀⡠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡆⠀⠀⠀\n" +
                        "⠀⠀⠀⠘⢦⡀⠘⢷⠦⣄⣀⠀⠀⠀⠀⠀⢠⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠆⡴⠃⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢿⣦⣌⣣⡀⠈⠉⠀⠀⠀⢠⠏⠀⠀⠀⣀⣠⠤⠶⠒⠒⠒⠒⠒⠒⢋⣩⡟⣡⠎⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠈⢳⡉⢫⣥⠶⠂⠀⠀⢀⡏⠀⢀⡴⠊⠁⣧⣤⣤⣤⣤⣴⡶⣖⠉⠉⣻⠞⠁⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠙⠤⡇⠸⡿⠂⠀⡼⠀⢠⠏⠀⣶⣾⣿⣿⣿⣿⣿⣿⣅⢈⣷⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣄⣀⣠⠾⡇⠀⡟⢠⣴⣿⣿⣿⣿⣿⣿⣿⣧⣨⢿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡽⠰⡇⢰⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⡇⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢳⠀⢻⣿⣿⣿⠿⠿⢿⣿⣿⣿⣧⣀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠈⣧⠞⠁⠛⠁⠀⢀⡴⠛⠉⠉⠉⠁⣠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡇⠀⢀⡏⠀⠀⠀⠀⣰⢋⣠⠆⠀⠀⣠⠞⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠏⠈⠧⣄⡀⣇⠀⠀⢀⠴⠉⠛⠷⠤⠶⠚⠁⠀⠸⡗⠒⢲⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠈⠉⠓⠚⠛⠒⠒⠒⣶⣦⡀⠀⠀⠀⠀⠹⣴⠁⢳⡀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠳⡀⠀⠀⠀⣰⠻⡀⠀⢧⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢀⡠⠼⠗⠒⠢⠤⣀⠀⠀⠀⠀⠀⠀⣼⠀⠀⠀⠹⣄⠀⢰⠃⠀⢳⠀⠘⣇⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⠀⠈⠙⣖⠒⠲⠤⠤⠇⠀⠀⠀⠀⠘⣶⠃⠀⠀⠈⢿⠒⠛⠣⣄⠀⠀⠀\n" +
                        "⠀⠀⠀⢀⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣇⠀⠀⠈⠳⡄⠀\n" +
                        "⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠹⡄\n" +
                        "⠀⠀⠸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢷⠀⠀⠀⠀⢳");
                return false;
            }
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean mightBeAPoliceMan) {
        if (mightBeAPoliceMan) {
            return new Juice(beerBottle);
        } else {
            return beerBottle;
        }
    }
}
