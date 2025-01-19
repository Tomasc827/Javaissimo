import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalorieCounter {
    private Weekdays day;
    private List<Product> products;
    private Gender pick;

    public CalorieCounter() {
        this.products = new ArrayList<>();
    }
    public CalorieCounter(Weekdays day) {
        this.products = new ArrayList<>();
        this.day = day;
    }
    public CalorieCounter(Gender pick) {
        this.products = new ArrayList<>();
        this.pick = pick;
    }
    public CalorieCounter(Weekdays day,Gender pick) {
        this.products = new ArrayList<>();
        this.day = day;
        this.pick = pick;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }
    public void addAllProducts(Product... productss) {
        Arrays.stream(productss).forEach(this::addProduct);
    }

    public void printOne(String name) {
        products.stream().filter(x -> name.length() >= 2 && x.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .ifPresent(System.out::println);
    }

    public void printAll() {
        products.forEach(System.out::println);
    }

    public double calcCalories() {
        double total = products.stream().mapToDouble(Product::getCalorie).sum();
        if(pick != null && pick.equals(Gender.Male) && total > 2500) {
            System.out.println("\nDaily limit for average male reached of 2500 calories.");
        }
        if(pick != null && pick.equals(Gender.Female) && total > 2000){
            System.out.println("\nDaily limit for average female reached of 2000 calories.");
        }

        return products.stream().mapToDouble(Product::getCalorie).sum();
    }
    public double calcFats() {
        return products.stream().mapToDouble(Product::getFat).sum();
    }
    public double calcProteins() {
        return products.stream().mapToDouble(Product::getProtein).sum();
    }
    public double calcCarbs() {
        return products.stream().mapToDouble(Product::getCarb).sum();
    }
    public double calcKjs() {
        return products.stream().mapToDouble(Product::getKilojoule).sum();
    }
    public double calcEthanol() {
        return products.stream().filter(x -> x instanceof Alcohol).mapToDouble(x -> ((Alcohol) x).getEthanol()).sum();
    }

    public Stream<Product> stream() {
        return products.stream();
    }
    public void sort() {
        Collections.sort(products);
    }

    @Override
    public String toString() {
        sort();
        return  "\nTotal Values:\n " +
                (day == null ? "" : "\nDay: " + day) +
                (pick == null ? "" : "\nGender: " + pick) +
                "\nKilojoules: " + String.format("%.2f", calcKjs()) +
                "\nCalories: " + String.format("%.2f", calcCalories()) +
                "\nFats: " + String.format("%.2f", calcFats()) +
                "\nProteins: " + String.format("%.2f", calcProteins()) +
                "\nCarbs: " + String.format("%.2f", calcCarbs()) +
                (calcEthanol() == 0 ? "" : "\nEthanol: " + calcEthanol()) +
                "\n\nProducts (sorted by calories):\n" +
                products.stream()
                        .map(Product::toString)
                        .collect(Collectors.joining("\n"));
    }
}
