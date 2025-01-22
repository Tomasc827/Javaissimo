package lt.techin.strategy;

public class ManufacturerFilteringStrategy implements FilteringStrategy {
    private String name;

    public ManufacturerFilteringStrategy(String name) {
        this.name = name;
    }



    @Override
    public boolean filter(Product product) {
      return (product.getManufacturer().equalsIgnoreCase(name));
    }
}
