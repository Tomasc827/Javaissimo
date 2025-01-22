package lt.techin.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeryHouse implements Warehouse {
    private List<Product> products = new ArrayList<>();


    @Override
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }

    @Override
    public List<Product> executeFilteringStrategy(FilteringStrategy strategy) {
        return products.stream().filter(strategy::filter)
                .collect(Collectors.toList());


    }
}
