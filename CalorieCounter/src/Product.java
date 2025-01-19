import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Product implements Comparable<Product> {
    private String name;
    private double calorie;
    private double fat;
    private double protein;
    private double carb;
    private double grams;
    private double kilojoule;

    public Product(String name, double fat, double protein, double carb,double grams){
        if (name ==null || name.length() > 255 || name.isEmpty()) {
            throw new UpperThresholdException("The name cannot exceed 255 characters.");
        }
        if(fat < 0 || protein < 0 || carb < 0) {
            throw new IllegalArgumentException("Fats/Proteins/Carbs cannot be negative");
        }
        if (fat > 1111 || protein > 1250 || carb > 1250) {
            throw new UpperThresholdException("Proteins/Carbs threshold is 1250, Fats is 1111");
        }
        if (grams > 10000) {
            throw  new UpperThresholdException("Grams cannot exceed 10kg");
        }
        if (grams <= 0) {
            throw  new IllegalArgumentException("Grams cannot be 0 or negative");
        }
        this.name = Arrays.stream(name.split(" "))
                .filter(x -> !x.isEmpty())
                .map(x -> {
                    String firstLetter = x.substring(0,1).toUpperCase();
                    String rest = x.substring(1).toLowerCase();
                    return firstLetter + rest;})
                .collect(Collectors.joining(" "));
        this.grams = grams;
        this.fat = fat / 100 * grams;
        this.protein = protein / 100 * grams;
        this.carb = carb / 100 * grams;
        this.calorie = this.carb * 4 + this.protein * 4 + this.fat * 9;
        this.kilojoule = this.calorie * 4.184;
    }

    public String getName() {
        return name;
    }

    public double getGrams() {
        return grams;
    }

    public double getCalorie() {
        return calorie;
    }

    public double getCarb() {
        return carb;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getKilojoule() {
        return kilojoule;
    }


    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nKilojoules: " + String.format("%.2f", getKilojoule()) +
                "\nCalories: " + String.format("%.2f", getCalorie()) +
                "\nFats: " + String.format("%.2f", getFat()) +
                "\nProteins: " + String.format("%.2f", getProtein()) +
                "\nCarbs: " + String.format("%.2f", getCarb());
    }


    @Override
    public int compareTo(Product o) {
        return Double.compare(o.getCalorie(),this.getCalorie());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
