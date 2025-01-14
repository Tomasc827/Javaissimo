import java.time.LocalDate;

public class CD implements  Packable{
   private String artist;
   private String name;
   private int year;
   private double weight;


   public CD(String artist, String name, int year) {
       this.artist = artist;
       this.name = name;
       this.year = year;
       if (this.year < 1982) {
           throw new IllegalArgumentException("Cds did not exist before 1982");
       }
       int currentYear = LocalDate.now().getYear();
       if (this.year > currentYear) {
           throw new IllegalArgumentException("Cds cannot be made in the future");
       }
       this.weight = 0.1;
   }

    public String toString() {
        return this.artist + ": " + this.name + " " + this.year;
    }


    @Override
    public double weight() {
        return this.weight;
    }
}
