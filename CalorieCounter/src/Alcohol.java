public class Alcohol extends Product{
    private double volume;
    private double ethanolCalories;

    public Alcohol(String name, double fat, double protein, double carb,double miligrams,double volume) {
        super(name,fat,protein,carb,miligrams);
        this.volume = volume;
        this.ethanolCalories = calculateEthanolCalories();
    }

    private double calculateEthanolCalories() {
        double alcoholWeight = getGrams() * (volume / 100);
        return alcoholWeight * 0.789 * 7;
    }

    public double getEthanolCalories() {
        return ethanolCalories;
    }

    public double getEthanol(){
        return ethanolCalories / 7;
    }

    @Override
    public double getCalorie() {
        return super.getCalorie() + ethanolCalories;
    }

    @Override
    public double getKilojoule() {
        return getCalorie() * 4.184;
    }

    @Override
    public String toString() {
       return super.toString() +
               "\nEthanol: " + String.format("%.2f",getEthanol());
    }


}
