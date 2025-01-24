package lt.techin;

import lt.vtvpmc.vending.machine.Coin;
import lt.vtvpmc.vending.machine.ProductPurchaseResult;
import lt.vtvpmc.vending.machine.ProductType;
import lt.vtvpmc.vending.machine.VendingMachine;

import java.util.HashMap;

public class GachaVendingMachine implements VendingMachine {
    HashMap<ProductType,Integer> products;
    HashMap<Coin,Integer> coins;
    public GachaVendingMachine() {
        products = new HashMap<>();
        coins = new HashMap<>();
       clearCoins();
    }

    @Override
    public void addProduct(ProductType productType, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }
        if (productType == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }

        products.put(productType, amount);
    }

    @Override
    public ProductPurchaseResult buyProduct(ProductType productType) {
        Integer quantity = products.get(productType);
        if (quantity == null || quantity < 0 ) {
            return new ProductPurchaseResult(false,0.0,productType);
        }
        double totalInserted = getTotalCoins();

        if (totalInserted < productType.getPrice()) {
            clearCoins();
            return new ProductPurchaseResult(false,totalInserted,productType);
        }
        int currentQuantity = products.get(productType);
        products.put(productType, currentQuantity - 1);
        double changeAmount = Math.round((totalInserted - productType.getPrice()) * 100.0) / 100.0;
        clearCoins();
        return new ProductPurchaseResult(true,changeAmount,productType);

    }
    public void clearCoins(){
        coins.clear();
        for(Coin c : Coin.values()){
            coins.put(c,0);
        }
    }
    public double getTotalCoins() {
        return coins.entrySet().stream().mapToDouble(entry -> getCoinValue(entry.getKey()) * entry.getValue()).sum();
    }

    private double getCoinValue(Coin coin) {
        switch (coin) {
            case CENTS_10: return 0.10;
            case CENTS_20: return 0.20;
            case CENTS_50: return 0.50;
            case EURO_1: return 1.0;
            case EURO_2: return 2.0;
            default: throw new IllegalArgumentException("Unknown coin");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        coins.put(coin, coins.get(coin) + 1);
    }
}
