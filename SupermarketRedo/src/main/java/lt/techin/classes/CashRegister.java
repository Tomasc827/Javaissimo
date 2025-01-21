package lt.techin.classes;

import lt.techin.enum_interface.Coins;
import lt.techin.exceptions.NotEnoughChangeExceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CashRegister {
    private final HashMap<Coins,Integer> coins;
    private final HashMap<Coins,Integer> currentTransactionCoins;

    public CashRegister(){
        this.coins = new HashMap<>();
        this.currentTransactionCoins = new HashMap<>();
        initialCoins();
    }

    private void initialCoins() {
        coins.put(Coins.TEN_CENT,50);
        coins.put(Coins.FIFTY_CENT,30);
        coins.put(Coins.POUND,15);
        coins.put(Coins.TWO_POUND,10);
    }

    public HashMap<Coins, Integer> getCoins() {
        return coins;
    }

    public HashMap<Coins, Integer> getCurrentTransactionCoins() {
        return currentTransactionCoins;
    }

    public void addCoin(double amount) {
        Coins matchingCoin = Arrays.stream(Coins.values())
                .filter(x -> x.getValue() == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid coin Amount: " + amount));

        coins.merge(matchingCoin,1,Integer::sum);
        currentTransactionCoins.merge(matchingCoin,1,Integer::sum);
    }

    public void addAllCoins(List<Double> amounts) {
        amounts.forEach(this::addCoin);
    }

    public HashMap<Coins,Integer> calcChange(double changeAmount) {
        HashMap<Coins,Integer> change = new HashMap<>();
        double remaining = changeAmount;

        Coins[] sorted = new Coins[] {
                Coins.TWO_POUND,
                Coins.POUND,
                Coins.FIFTY_CENT,
                Coins.TEN_CENT
        };

        for (Coins coin : sorted) {
            while (remaining >= coin.getValue() && coins.get(coin) > 0) {
                change.merge(coin,1,Integer::sum);
                coins.put(coin,coins.get(coin) - 1);
                remaining = Math.round((remaining - coin.getValue()) * 100.0) / 100.0;
            }
        }

        if (remaining > 0.001) {
            change.forEach((x1,x2) -> coins.put(x1,coins.get(x1) + x2));
            throw new NotEnoughChangeExceptions("Cannot provide exact change");
        }
        System.out.println("\nChange provided:");
        change.forEach((coin, count) ->
                System.out.printf("%.2f£ x %d\n", coin.getValue(), count));
        System.out.printf("Total change: %.2f£\n", changeAmount);
         return change;
    }

    public void displayCoins() {
        System.out.println("\nCash Register Contents:");
        coins.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e1.getKey().getValue(), e2.getKey().getValue()))
                .forEach(entry -> System.out.printf(" Value: %.2f£ | Quantity: %d%n",
                        entry.getKey().getValue(), entry.getValue()));
    }

    public void returnPayment() {
        currentTransactionCoins.forEach((x1,x2) -> coins.put(x1,coins.get(x1) - x2));
        currentTransactionCoins.clear();
    }
    public void clearCurrentTransaction() {
        currentTransactionCoins.clear();
    }


}
