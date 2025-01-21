package lt.techin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class CashRegister {
    private HashMap<Coins,Integer> coins;

    public CashRegister() {
        this.coins = new HashMap<>();
    }

    public void addCoin(double amount) {
            Coins type = getCoinTypeByEnum(amount);
            if(type != null) {
                int current = coins.getOrDefault(type,0);
                coins.put(type,current +1);
            } else {
                System.out.println("Coin not recognised: " + amount);
            }

    }

    public Coins getCoinTypeByEnum(double value) {
        return Arrays.stream(Coins.values())
                .filter(coin ->coin.getValue() == value)
                .findFirst()
                .orElse(null);
    }

    public void printCoins() {
        coins.forEach((key,value) -> {
            System.out.println("Value: " + key + ", quantity: " + value);
        });
    }

}
